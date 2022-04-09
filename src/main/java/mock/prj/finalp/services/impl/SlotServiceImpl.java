package mock.prj.finalp.services.impl;

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
    public List<Slot> findSlotByParkingLotId(Long id) {
        return this.slotRepository.findAllByParkingLotId(id);
    }

    @Override
    public List<Slot> getAll() {
        return slotRepository.findAll();
    }

    @Override
    public Optional<Slot> getById(Long id) {
        return slotRepository.findById(id);
    }

    @Override
    public Slot save(Slot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public void deleteById(Long key) {
    }


}
