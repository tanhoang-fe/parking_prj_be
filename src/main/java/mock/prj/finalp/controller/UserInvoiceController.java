package mock.prj.finalp.controller;


import mock.prj.finalp.dto.SlotDTO;
import mock.prj.finalp.dto.UserDTO;
import mock.prj.finalp.dto.UserInvoiceDTO;
import mock.prj.finalp.model.Slot;
import mock.prj.finalp.model.User;
import mock.prj.finalp.model.UserInvoice;
import mock.prj.finalp.services.UserInvoiceService;
import mock.prj.finalp.services.impl.UserInvoiceServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userInvoice")
public class UserInvoiceController {
    @Autowired
    UserInvoiceServiceImpl userInvoiceService;
    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/{userId}")
    public ResponseEntity<List<UserInvoiceDTO>> getAll(@PathVariable("userId") Long userId) {
        List<UserInvoice> userInvoices = userInvoiceService.findAllByUserId(userId);
        List<UserInvoiceDTO> subUserInvoiceDTO = userInvoices.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(subUserInvoiceDTO, HttpStatus.OK);
    }
    public UserInvoice convertToEntity(UserInvoiceDTO userInvoiceDTO) {
        UserInvoice userInvoice = modelMapper.map(userInvoiceDTO, UserInvoice.class);
        return userInvoice;
    }

    public UserInvoiceDTO convertToDTO(UserInvoice userInvoice) {
        UserInvoiceDTO userInvoiceDTO = modelMapper.map(userInvoice, UserInvoiceDTO.class);
        return userInvoiceDTO;
    }


}
