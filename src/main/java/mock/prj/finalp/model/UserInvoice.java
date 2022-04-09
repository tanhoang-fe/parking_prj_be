package mock.prj.finalp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class UserInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_invoice_id")
    private Long id;
    private PackageType packageType;
    private Long startDate;
    private Long createdAt;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="vehicle_id", nullable = false, referencedColumnName = "vehicle_id")
    private Vehicle vehicle;


    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false, referencedColumnName = "slot_id")
    private Slot slot;
}
