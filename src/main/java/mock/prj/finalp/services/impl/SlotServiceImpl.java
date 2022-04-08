package mock.prj.finalp.services.impl;

import mock.prj.finalp.model.ParkingLot;
import mock.prj.finalp.model.Slot;
import mock.prj.finalp.repositories.SlotRepository;
import mock.prj.finalp.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotServiceImpl implements SlotService {
    @Autowired
    SlotRepository slotRepository;

    @Override
    public Slot findById(Long id) {
        return slotRepository.findById(id).orElse(null);
    }

    @Override
    public void booking() {

    }

    @Override
    public List<Slot> findSlotByStatus(String status) {
        return this.slotRepository.findAllByStatus(status);
    }

    @Override
    public List<Slot> findSlotByParkingLotId(Long id) {
        return this.slotRepository.findAllByParkingLotId(id);
    }
}
