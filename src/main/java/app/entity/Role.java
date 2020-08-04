package app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "r_role_user",
            joinColumns = {@JoinColumn(name="role_id",
                    referencedColumnName = "r_id"),
            },
            inverseJoinColumns = {@JoinColumn(name = "user_id",
                    referencedColumnName = "u_id")})
    private Set<Userr> users;

    @Override
    public String toString() {
        return name;
    }

}
