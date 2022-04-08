package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;
    private String role;

    @OneToMany(mappedBy="user")
    private Set<Vehicle> vehicles;

    @OneToMany(mappedBy = "user")
    private Set<UserInvoice> userInvoiceSet;

    @OneToOne(mappedBy = "user")
    private Slot slot;
}
