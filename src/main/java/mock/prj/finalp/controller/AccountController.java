package mock.prj.finalp.controller;
import mock.prj.finalp.dto.LoginResponseDTO;
import mock.prj.finalp.dto.UserDTO;
import mock.prj.finalp.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import mock.prj.finalp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ModelMapper modelMapper;

   @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@RequestBody User user) {
        Optional<User> accountOptional=userService.getUserByUsername(user.getUsername());
        return (ResponseEntity<LoginResponseDTO>) accountOptional.map(acc -> {
            if (user.getPassword().equals(acc.getPassword())) {
                LoginResponseDTO a = modelMapper.map(acc, LoginResponseDTO.class);
                a.setVehicleIds(new HashSet<String>());
                Set<String> vehicleIds = a.getVehicleIds();
                acc.getVehicles().forEach(v -> {
                    vehicleIds.add(v.getId());
                });
                return ResponseEntity.ok(a);
            }
            return new ResponseEntity<String>("Wrong Username or Password1", HttpStatus.BAD_REQUEST);
        }).orElseGet(()->new ResponseEntity<String>("Wrong Username or Password",HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createEmployee(@RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userService.save(user), UserDTO.class));
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }



}

