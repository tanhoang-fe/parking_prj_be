package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {
    @Id
    @Column(name = "parking_lot_id")
    private String id;
    private String parkingName;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "parkingLot")
    private Set<Slot> slots;

    @OneToMany (mappedBy = "parkingLot")
    private Set<UserInvoice> userInvoices;

}
