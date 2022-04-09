package mock.prj.finalp.controller;

import mock.prj.finalp.dto.UserDTO;
import mock.prj.finalp.dto.UserInvoiceDTO;
import mock.prj.finalp.model.Slot;
import mock.prj.finalp.model.User;
import mock.prj.finalp.model.UserInvoice;
import mock.prj.finalp.services.SlotService;
import mock.prj.finalp.services.UserInvoiceService;
import mock.prj.finalp.services.impl.UserInvoiceServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SlotService slotService;

    @Autowired
    UserInvoiceServiceImpl userInvoiceService;

    @PostMapping
    public ResponseEntity<UserInvoiceDTO> booking(UserInvoiceDTO userInvoiceDTO) {
        UserInvoice userInvoice = convertToEntity(userInvoiceDTO);
//        Optional<Slot> slotOptional = slotService.getById(userInvoice.getId());
//        Slot slot = modelMapper.map(slotOptional,Slot.class);
//        Double totalPrice =( slot.getSlotPricePerDay() * userInvoice.getPackageType().dayInPackage );
//        userInvoice.setTotalPrice(totalPrice);
        Long timestamp= new Date().getTime();
        userInvoice.setCreatedAt(timestamp);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userInvoiceService.save(userInvoice), UserInvoiceDTO.class));
    }

    public UserInvoice convertToEntity(UserInvoiceDTO userInvoiceDTO) {
        UserInvoice userInvoice = modelMapper.map(userInvoiceDTO, UserInvoice.class);
        return userInvoice;
    }
}
    