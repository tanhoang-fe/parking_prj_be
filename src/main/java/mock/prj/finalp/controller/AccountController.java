package mock.prj.finalp.controller;
import mock.prj.finalp.dto.LoginResponseDTO;
import mock.prj.finalp.dto.UserDTO;
import mock.prj.finalp.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import mock.prj.finalp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class AccountController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ModelMapper modelMapper;

   @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@RequestBody UserDTO userDTO) {
        Optional<User> userOptional=userService.getUserByUsername(userDTO.getUsername());
        return (ResponseEntity<LoginResponseDTO>) userOptional.map(acc -> {
            if (userDTO.getPassword().equals(acc.getPassword())) {
                LoginResponseDTO a = modelMapper.map(acc, LoginResponseDTO.class);
//                a.setVehicleIds(new HashSet<String>());
//                Set<String> vehicleIds = a.getVehicleIds();
//                acc.getVehicles().forEach(v -> {
//                    vehicleIds.add(v.getId());
//                });
                return ResponseEntity.ok(a);
            }
            return new ResponseEntity<String>("Wrong Username or Password1", HttpStatus.BAD_REQUEST);
        }).orElseGet(()->new ResponseEntity<String>("Wrong Username or Password",HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO) {
       if (!userService.existedUsername(userDTO.getUsername()))
       {
            User user = convertToEntity(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userService.save(user), UserDTO.class));
        } else return null;
    }
    public User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

//    @GetMapping("/info")
//    public ResponseEntity<LoginResponseDTO> userInfo(@RequestBody User user) {
//
//        Optional<User> userOptional = userService.userRepository.findByUsername(user.getUsername());
//
//        return userOptional
//                .map(user1 -> ResponseEntity.ok(modelMapper.map(user1, LoginResponseDTO.class)))
//                .orElse(ResponseEntity.notFound().build());
//    }


}

