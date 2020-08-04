package app.service;


import app.entity.Customer;
import app.repo.CustomerRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo repo;

    public List<Customer> select_customers(int pay, int month){
        int pay_per_month=pay/month;
        return repo.findAll().stream()
                .filter(c -> c.getMax_pay() >= pay_per_month).collect(Collectors.toList());

    }

}
