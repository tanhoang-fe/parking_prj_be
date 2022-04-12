package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
    @Id
    @Column(name = "slot_id")
    private String id;
    private String slotName;
     private Double slotPricePerDay;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id", nullable = false, referencedColumnName = "parking_lot_id")
    private ParkingLot parkingLot;

    @JsonIgnore
    @OneToMany(mappedBy = "slot")
    private Set<UserInvoice> userInvoices;

    @ManyToOne
    @JoinColumn (name="vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;
}
