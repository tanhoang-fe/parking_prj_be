package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_type_id")
    private Long vehicleTypeId;
    private String vehicleTypeName;

    @OneToMany(mappedBy = "vehicleTypeId")
    @JsonBackReference
    private Set<Vehicle> vehicleSet;
}
