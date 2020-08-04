package app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/", "/signup", "/index", "/resetpass/**", "/img/**", "/css/**", "/js/**", "/uploaded/**")
            .permitAll()
            .antMatchers(
                    "/dashboard", "/message",
                    "/mypost", "/myposts", "/search",
                    "/info", "/update", "/user", "/wishlist").hasRole("USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/signin").permitAll()
            .defaultSuccessUrl("/info", true)
            .usernameParameter("login")
            .passwordParameter("pass")
            .and()
            .logout()
            .logoutUrl("/logout")
            .clearAuthentication(true)
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .logoutSuccessUrl("/");
  }


}
