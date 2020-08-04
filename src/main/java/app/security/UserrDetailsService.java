package app.security;

import app.entity.Userr;
import app.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

@Log4j2
@Configuration
@AllArgsConstructor
public class UserrDetailsService implements UserDetailsService {

  private final UserService userService;

  //Converting from Application User app.entity to conventional UserDetail
  public static UserDetails userToUserDetails(Userr user) {
    return User
            .withUsername(user.getEmail())
            .password(user.getPassword())
            .roles()
            .build();
  }

  //Converting from Application User app.entity to Application UserrDetail
  public static UserDetails userToUserrDetails(Userr user) {
    return new UserrDetails(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getRoles().stream()
                    .map(r -> "ROLE_" + r)
                    .map(r -> (GrantedAuthority) () -> r.toString()).collect(Collectors.toSet()),
            true,
            true,
            true,
            true
    );
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userService.findUserForLogin(email)
            .map(UserrDetailsService::userToUserrDetails).orElseThrow(()-> new UsernameNotFoundException("User not found"));
  }
}
