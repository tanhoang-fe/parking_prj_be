package mock.prj.finalp.controller;

import mock.prj.finalp.model.Slot;
import mock.prj.finalp.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class BookingController {
    @Autowired
    SlotService slotService;

    //KienHQ
    @GetMapping("/slot/{id}")
    public ResponseEntity<?> checkStatus(@RequestBody @PathVariable("id") Long id) {
        Slot slot = slotService.findById(id);
        if (slot.getStatus().equals("free")) {
            return new ResponseEntity<>(slot, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
