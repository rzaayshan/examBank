package app.repo;

import app.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Userr, Long> {
    Optional<Userr> findByEmail(String email);
}
