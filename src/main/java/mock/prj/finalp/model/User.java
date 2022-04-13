package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import mock.prj.finalp.dto.UserUpdateDTO;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    public User update(UserUpdateDTO userUpdateDTO){
        if(!userUpdateDTO.getId().equals(this.getId())) throw new IllegalArgumentException("id not found");
        this.setEmail(userUpdateDTO.getEmail());
        this.setName(userUpdateDTO.getName());
        this.setPhone(userUpdateDTO.getPhone());
        return this;
    }

}
