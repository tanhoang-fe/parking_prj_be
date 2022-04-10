package mock.prj.finalp.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mock.prj.finalp.model.Vehicle;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private Set<String> vehicleIds;
}
