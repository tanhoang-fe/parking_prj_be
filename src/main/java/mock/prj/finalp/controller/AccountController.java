package mock.prj.finalp.controller;
import mock.prj.finalp.dto.LoginResponseDTO;
import mock.prj.finalp.dto.UserDTO;
import mock.prj.finalp.dto.UserUpdateDTO;
import mock.prj.finalp.model.Vehicle;
import mock.prj.finalp.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import mock.prj.finalp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class AccountController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody UserDTO userDTO) {
        Optional<User> userOptional = userService.getUserByUsername(userDTO.getUsername());
        return (ResponseEntity<LoginResponseDTO>) userOptional.map(acc -> {
            if (userDTO.getPassword().equals(acc.getPassword())) {
                LoginResponseDTO a = modelMapper.map(acc, LoginResponseDTO.class);
                a.setVehicles(new HashSet<Vehicle>());
                Set<Vehicle> vehicles = a.getVehicles();
                acc.getVehicles().forEach(v -> {
                    vehicles.add(v);
                });
                return ResponseEntity.ok(a);
            }
            return new ResponseEntity<String>("Wrong Username or Password1", HttpStatus.BAD_REQUEST);
        }).orElseGet(() -> new ResponseEntity<String>("Wrong Username or Password", HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO) {
        if (!userService.existedUsername(userDTO.getUsername())) {
            User user = convertToEntity(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userService.save(user), UserDTO.class));
        } else return null;
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody UserUpdateDTO userUpdateDTO) {
        Optional<User> userOptional = userService.getById(userUpdateDTO.getId());
        return userOptional
                .map(user ->
                        ResponseEntity.status(HttpStatus.OK)
                                      .body(modelMapper.map(userService.save(user.update(userUpdateDTO)), UserDTO.class))
                )
                .orElse(ResponseEntity.notFound().build());
    }
}

