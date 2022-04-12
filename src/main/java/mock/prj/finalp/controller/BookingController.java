package mock.prj.finalp.controller;

import mock.prj.finalp.dto.SlotDTO;
import mock.prj.finalp.dto.UserInvoiceDTO;
import mock.prj.finalp.dto.VehicleDTO;
import mock.prj.finalp.model.*;
import mock.prj.finalp.services.impl.SlotServiceImpl;
import mock.prj.finalp.services.impl.UserInvoiceServiceImpl;
import mock.prj.finalp.services.impl.VehicleServiceImpl;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SlotServiceImpl slotService;

    @Autowired
    UserInvoiceServiceImpl userInvoiceService;

    @Autowired
    VehicleServiceImpl vehicleService;



    @PostMapping
    public ResponseEntity<UserInvoiceDTO> booking(@RequestBody UserInvoiceDTO userInvoiceDTO) throws NoSuchFieldException {
        Vehicle vehicle= new Vehicle();
        vehicle.setVehicleBrand(userInvoiceDTO.getVehicleBrand());
        vehicle.setVehicleColor(userInvoiceDTO.getVehicleColor());
        vehicle.setUser(new User());
        vehicle.getUser().setId(userInvoiceDTO.getUserId());
        vehicle.setId(userInvoiceDTO.getVehicleId());
        vehicleService.save(vehicle);

        Slot slot=new Slot();
        slot.setVehicle(new Vehicle());
        slot.getVehicle().setId(userInvoiceDTO.getVehicleId());
        slot.setId(userInvoiceDTO.getParkingLotId()+'-'+userInvoiceDTO.getSlotName());
        slot.setSlotName(userInvoiceDTO.getSlotName());
        slot.setUser(new User());
        slot.getUser().setId(userInvoiceDTO.getUserId());
        slot.setParkingLot(new ParkingLot());
        slot.getParkingLot().setId(userInvoiceDTO.getParkingLotId());
        slot.setSlotPricePerDay(100000.0);
        slotService.save(slot);
        UserInvoice userInvoice = convertToEntity(userInvoiceDTO);
        userInvoice.setSlot(slot);
        userInvoice.setVehicle(vehicle);
        Double totalPrice =(slot.getSlotPricePerDay() * userInvoice.getPackageType().dayInPackage);
        userInvoice.setTotalPrice(totalPrice);
        Long timestamp= new Date().getTime();
        userInvoice.setCreatedAt(timestamp);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userInvoiceService.save(userInvoice), UserInvoiceDTO.class));
    }


    public UserInvoice convertToEntity(UserInvoiceDTO userInvoiceDTO) throws NoSuchFieldException {
        UserInvoice userInvoice = new UserInvoice();
        userInvoice.setUser(new User());
        userInvoice.getUser().setId(userInvoiceDTO.getUserId());
        userInvoice.setSlot(new Slot ());
        userInvoice.getSlot().setId(userInvoiceDTO.getSlotId());
        userInvoice.getSlot().setSlotName(userInvoiceDTO.getSlotName());
        userInvoice.setVehicle(new Vehicle());
        userInvoice.getVehicle().setId(userInvoiceDTO.getVehicleId());
        userInvoice.setPackageType(userInvoiceDTO.getPackageType());
        userInvoice.setStartDate(userInvoiceDTO.getStartDate());
        userInvoice.setParkingLot(new ParkingLot());
        userInvoice.getParkingLot().setId(userInvoiceDTO.getParkingLotId());
        userInvoice.setVehicle(new Vehicle());
        userInvoice.getVehicle().setVehicleBrand(userInvoiceDTO.getVehicleBrand());
        userInvoice.getVehicle().setVehicleColor(userInvoiceDTO.getVehicleColor());
        return userInvoice;
    }

    public Vehicle convertVehicleToEntity (VehicleDTO vehicleDTO) {
        Vehicle vehicle=new Vehicle();
        vehicle.setUser(new User());
        vehicle.getUser().setId(vehicleDTO.getUserId());
        vehicle.setId(vehicleDTO.getId());
        vehicle.setVehicleBrand(vehicleDTO.getVehicleBrand());
        vehicle.setVehicleColor(vehicleDTO.getVehicleColor());
        return vehicle;
    }


    public Slot convertSlotToEntity(SlotDTO slotDTO) {
        Slot slot = new Slot();

        slot.setUser(new User());
        slot.getUser().setId(slotDTO.getUserId());

        slot.setVehicle(new Vehicle());
        slot.getVehicle().setId(slotDTO.getVehicleId());

        slot.setSlotPricePerDay(slotDTO.getPrice());
        slot.setId(slotDTO.getId());
        slot.setSlotName(slotDTO.getName());

        slot.setParkingLot(new ParkingLot());
        slot.getParkingLot().setId(slotDTO.getParkingId());
    return slot;

    }

}
