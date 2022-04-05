package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private Long slotId;
    private String slotName;
    private String status;
    private Double slotPrice;

    @ManyToOne
    @JoinColumn(name = "slot_type_id", nullable = false, referencedColumnName = "slot_type_id")
    private SlotType slotTypeId;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id", nullable = false, referencedColumnName = "parking_lot_id")
    private ParkingLot parkingLotId;

    @OneToMany(mappedBy = "slotId")
    @JsonBackReference
    private Set<UserInvoice> userInvoiceSet;
}
