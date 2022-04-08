package mock.prj.finalp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mock.prj.finalp.model.ParkingLot;
import mock.prj.finalp.model.SlotType;
import mock.prj.finalp.model.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlotDTO {
    private Long slotId;
    private String slotName;
    private String status;
    private Double slotPrice;
    private Long userId;
    private String slotTypeName;
    private Long parkingLotId;
}
