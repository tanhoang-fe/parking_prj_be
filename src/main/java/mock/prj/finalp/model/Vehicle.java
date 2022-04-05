package mock.prj.finalp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;
    private String licensePlates;
    private String color;
    private String brand;

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id", nullable = false, referencedColumnName = "vehicle_type_id")
    private VehicleType vehicleTypeId;
}
