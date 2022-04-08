package mock.prj.finalp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class SlotType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_type_id")
    private Long slotTypeId;
    private String slotTypeName;

    @OneToMany(mappedBy = "slotType")
    private Set<Slot> slots;
}
