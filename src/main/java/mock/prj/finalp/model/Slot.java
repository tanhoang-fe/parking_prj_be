package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    private Status status;
    private Double slotPricePerDay;

    @OneToOne(fetch =FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch =FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_invoice_id")
    private UserInvoice userInvoice;

    @ManyToOne
    @JoinColumn(name = "slot_type_id", nullable = false, referencedColumnName = "slot_type_id")
    private SlotType slotType;


    @ManyToOne
    @JoinColumn(name = "parking_lot_id", nullable = false, referencedColumnName = "parking_lot_id")
    private ParkingLot parkingLot;

    @JsonIgnore
    @OneToMany(mappedBy = "slot")
    private Set<UserInvoice> userInvoices;
}
