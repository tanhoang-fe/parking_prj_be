package mock.prj.finalp.controller;

import mock.prj.finalp.dto.SlotDTO;
import mock.prj.finalp.model.Slot;
import mock.prj.finalp.services.impl.SlotServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/slot")
public class SlotController {
    @Autowired
    SlotServiceImpl slotService;
    @Autowired
    ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<SlotDTO>> getAllSlot() {
        List<Slot> slots = slotService.getAll();
        List<SlotDTO> subSlot = slots.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(subSlot, HttpStatus.OK);
    }

    public SlotDTO convertToDTO(Slot slot) {
        SlotDTO snotDTO = modelMapper.map(slot, SlotDTO.class);
        return snotDTO;
    }

    @GetMapping("/n/{parkingId}")
    public ResponseEntity<List<SlotDTO>> getSlotByParkingLotID(@PathVariable("parkingId") Long parkingId) {
        List <Slot> slots=slotService.findSlotByParkingLotId(parkingId);
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
