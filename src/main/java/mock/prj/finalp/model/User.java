package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;

    @OneToMany(mappedBy="user")
    private Set<Vehicle> vehicles;

    @OneToMany(mappedBy = "user")
    private Set<UserInvoice> userInvoiceSet;

    @OneToMany(mappedBy = "user")
    private Set<Slot> slots;
}
