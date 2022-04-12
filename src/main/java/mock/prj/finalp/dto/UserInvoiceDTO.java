package mock.prj.finalp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mock.prj.finalp.model.PackageType;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInvoiceDTO {
    private Long id;
    private PackageType packageType;
    private Long startDate;
    private Long createdAt;
    private double totalPrice;
    private Long userId;
    private String vehicleId;
    private String vehicleColor;
    private String vehicleBrand;
    private String slotName;
    private String slotId;
    private String parkingLotId;
}
