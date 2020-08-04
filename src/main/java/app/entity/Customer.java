package app.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Set;


@Entity
@Data
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long id;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    Set<History> history;

    private int max_pay;




}
