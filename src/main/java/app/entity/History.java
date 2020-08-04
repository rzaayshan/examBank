package app.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "h_id")
    private Long id;

    private LocalDate date_req;
    private LocalDate date_act;
    private int money_req;
    private int mon_act;

    @ManyToOne()
    @JoinTable(name = "r_cust_hist",
            joinColumns = {@JoinColumn(name="history_id",
                    referencedColumnName = "h_id"),
            },
            inverseJoinColumns = {@JoinColumn(name = "customer_id",
                    referencedColumnName = "c_id")})
    private Customer customer;


}
