package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
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
    private String licensePlate;
    private String vehicleColor;
    private String vehicleBrand;
    private String vehicleType;
    @OneToMany(mappedBy = "userId")
    @JsonBackReference
    private Set<UserInvoice> userInvoiceSet;

    @OneToOne(mappedBy = "userId")
    @JsonBackReference
    private Slot slotId;
}
