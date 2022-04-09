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
public class ParkingLot {
    @Id
    @Column(name = "parking_lot_id")
    private Long id;
    private String parkingName;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "parkingLot")
    private Set<Slot> slots;

}
