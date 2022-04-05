package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_lot_id")
    private Long parkingLotId;
    private String parkingLotName;
    private String status;
    private Long carSlots;
    private Long motorSlots;
    private Long vanSlots;

    @OneToMany(mappedBy = "parkingLotId")
    @JsonBackReference
    private Set<Slot> slotSet;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private User userId;
}
