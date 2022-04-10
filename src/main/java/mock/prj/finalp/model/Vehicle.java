package mock.prj.finalp.model;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @Column(name = "vehicle_id")
    private String id;
    private String vehicleColor;
    private String vehicleBrand;
    private String vehicleType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private User user;

    @OneToMany(mappedBy = "vehicle")
    private Set<Slot> slots;
}
