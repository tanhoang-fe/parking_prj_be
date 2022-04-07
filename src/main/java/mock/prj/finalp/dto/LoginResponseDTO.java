package mock.prj.finalp.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String role;
    private String licensePlate;
    private String vehicleColor;
    private String vehicleBrand;
    private String vehicleType;

}
