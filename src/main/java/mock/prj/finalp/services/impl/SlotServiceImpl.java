package mock.prj.finalp.services.impl;

import mock.prj.finalp.model.ParkingLot;
import mock.prj.finalp.model.Slot;
import mock.prj.finalp.repositories.SlotRepository;
import mock.prj.finalp.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Optional getById(Object key) {
        return Optional.empty();
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public void deleteById(Object key) {

    }
}
