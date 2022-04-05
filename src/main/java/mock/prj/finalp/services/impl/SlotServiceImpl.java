package mock.prj.finalp.services.impl;

import mock.prj.finalp.model.Slot;
import mock.prj.finalp.repositories.SlotRepository;
import mock.prj.finalp.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
