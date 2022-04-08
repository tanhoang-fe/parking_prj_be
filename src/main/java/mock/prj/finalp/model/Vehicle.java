package mock.prj.finalp.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Vehicle {
    @Id
    @Column(name = "licence_Plate")
    private String licensePlate;
    private String vehicleColor;
    private String vehicleBrand;
    private String vehicleType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private User user;
}
