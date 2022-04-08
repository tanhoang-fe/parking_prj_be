package mock.prj.finalp.controller;

import mock.prj.finalp.dto.BookingDTO;
import mock.prj.finalp.dto.SlotDTO;
import mock.prj.finalp.dto.UserDTO;
import mock.prj.finalp.dto.UserInvoiceDTO;
import mock.prj.finalp.model.ParkingLot;
import mock.prj.finalp.model.Slot;
import mock.prj.finalp.model.UserInvoice;
import mock.prj.finalp.services.SlotService;
import mock.prj.finalp.services.impl.SlotServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parking")
public class BookingController {
    @Autowired
    SlotServiceImpl slotService;
    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/status/{status}")
    public ResponseEntity<List<SlotDTO>> getAllSlotByStatus(@PathVariable("status") String status) {
        List<Slot> slots = slotService.findSlotByStatus(status);
        List<SlotDTO> subSlot = slots.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(subSlot, HttpStatus.OK);
    }

    public SlotDTO convertToDTO(Slot slot) {
        SlotDTO snotDTO = modelMapper.map(slot, SlotDTO.class);
        return snotDTO;
    }

    @GetMapping("/{parkingLotId}")
    public ResponseEntity<List<SlotDTO>> getSlotByParkingLotID(@PathVariable("parkingLotId") Long parkingLotId) {
        List <Slot> slots=slotService.findSlotByParkingLotId(parkingLotId);
        List<SlotDTO> subSlot = slots.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        return new ResponseEntity<>(subSlot,HttpStatus.OK);

    }

//    @PostMapping("/booking/{slotId}")
//    public ResponseEntity<BookingDTO> bookingSlot(@PathVariable("slotId") String slotId) {
//        BookingDTO bookingDTO=new BookingDTO();
//        Optional<Slot> slotOptional = slotService.getById(slotId);
//
//    }

//    @GetMapping ("/{parkingLotId}")
//    public ResponseEntity<List<SlotDTO>> getAllSlotByStatus

//    public double totalPrice() {
//
//    }

}
