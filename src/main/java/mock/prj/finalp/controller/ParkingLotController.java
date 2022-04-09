package mock.prj.finalp.controller;

import mock.prj.finalp.dto.ParkingDTO;
import mock.prj.finalp.dto.SlotDTO;
import mock.prj.finalp.model.ParkingLot;
import mock.prj.finalp.model.Slot;
import mock.prj.finalp.services.impl.ParkingLotServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parking")
public class ParkingLotController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ParkingLotServiceImpl parkingLotService;

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> getAllParkingLot() {
        List<ParkingLot> parkingLots = parkingLotService.getAll();
        List<ParkingDTO> subParkings = parkingLots.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(subParkings, HttpStatus.OK);
    }

    public ParkingDTO convertToDTO(ParkingLot parkingLot) {
        ParkingDTO parkingDTO = modelMapper.map(parkingLot, ParkingDTO.class);
        return parkingDTO;
    }
}
