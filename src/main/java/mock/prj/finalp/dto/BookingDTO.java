package mock.prj.finalp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mock.prj.finalp.model.PackageType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long slotId;
    private Long slotName;
    private String licensePlate;
    private PackageType packageType;
}
