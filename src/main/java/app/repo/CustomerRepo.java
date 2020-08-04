package app.repo;

import app.entity.Customer;
import app.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
