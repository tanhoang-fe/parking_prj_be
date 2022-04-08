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
    private Long userInvoiceId;
    private PackageType packageType;
    private Date startDate;
    private Date endDate;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="slotId")

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false, referencedColumnName = "slot_id")
    private Slot slot;
}
