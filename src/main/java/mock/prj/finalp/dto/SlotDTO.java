package mock.prj.finalp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlotDTO {
    private Long slotId;
    private String slotName;
    private Double slotPrice;
    private Long userId;
    private Long parkingId;
    private String vehicleId;
}
