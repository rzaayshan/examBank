package app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rt_id")
    private long id;
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "r_reset_user",
            joinColumns = {@JoinColumn(name="reset_id",
                    referencedColumnName = "rt_id"),
            },
            inverseJoinColumns = {@JoinColumn(name = "user_id",
                    referencedColumnName = "u_id")})
    private Userr user;

    public ResetToken(Userr user, String token) {
    this.user = user;
    this.token = token;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("Post{id=%d}", id);
    }


}
