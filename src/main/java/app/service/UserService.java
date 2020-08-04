package app.service;

import app.entity.Userr;
import app.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;

    public Optional<Userr> findUserForLogin(String email) {
        return userRepo.findByEmail(email);
    }
}
