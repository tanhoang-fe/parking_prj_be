package mock.prj.finalp.controller;

import mock.prj.finalp.dto.SlotDTO;
import mock.prj.finalp.dto.UserInvoiceDTO;
import mock.prj.finalp.model.Slot;
import mock.prj.finalp.model.User;
import mock.prj.finalp.model.UserInvoice;
import mock.prj.finalp.model.Vehicle;
import mock.prj.finalp.services.impl.SlotServiceImpl;
import mock.prj.finalp.services.impl.UserInvoiceServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SlotServiceImpl slotService;

    @Autowired
    UserInvoiceServiceImpl userInvoiceService;



    @PostMapping
    public ResponseEntity<UserInvoiceDTO> booking(@RequestBody UserInvoiceDTO userInvoiceDTO) throws NoSuchFieldException {
        UserInvoice userInvoice = convertToEntity(userInvoiceDTO);
        Optional<Slot> slotOptional = slotService.getById(userInvoice.getSlot().getId());
        if(slotOptional.isEmpty()) return ResponseEntity.notFound().build();
        else {
            Slot slot = slotOptional.get();
            slot.setUser(new User());
            slot.getUser().setId(userInvoiceDTO.getUserId());
            slot.setVehicle(new Vehicle());
            slot.getVehicle().setId(userInvoiceDTO.getVehicleId());
            Double totalPrice =(slot.getSlotPricePerDay() * userInvoice.getPackageType().dayInPackage );
            userInvoice.setTotalPrice(totalPrice);
            Long timestamp= new Date().getTime();
            userInvoice.setCreatedAt(timestamp);
            return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userInvoiceService.save(userInvoice), UserInvoiceDTO.class));
        }
    }

    public UserInvoice convertToEntity(UserInvoiceDTO userInvoiceDTO) throws NoSuchFieldException {
        UserInvoice userInvoice = new UserInvoice();
        Slot slot = new Slot();
        userInvoice.setUser(new User());
        userInvoice.getUser().setId(userInvoiceDTO.getUserId());
        userInvoice.setSlot(new Slot());
        userInvoice.getSlot().setId(userInvoiceDTO.getSlotId());
        userInvoice.setVehicle(new Vehicle());
        userInvoice.getVehicle().setId(userInvoiceDTO.getVehicleId());
        userInvoice.setPackageType(userInvoiceDTO.getPackageType());
        userInvoice.setStartDate(userInvoiceDTO.getStartDate());

        return userInvoice;
    }
}
