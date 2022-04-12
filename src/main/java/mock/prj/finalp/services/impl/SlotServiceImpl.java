package mock.prj.finalp.services.impl;

import mock.prj.finalp.model.Slot;
import mock.prj.finalp.repositories.SlotRepository;
import mock.prj.finalp.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SlotServiceImpl implements SlotService {
    @Autowired
    SlotRepository slotRepository;


    @Override
    public List<Slot> findSlotByParkingLotId(String id) {
        return this.slotRepository.findAllByParkingLotId(id);
    }

    @Override
    public Optional<Slot> getBySlotName(String slotName) {
        return slotRepository.findBySlotName(slotName);
    }

    @Override
    public String generateSlotId(String id) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }

    @Override
    public List<Slot> getAll() {
        return slotRepository.findAll();
    }

    @Override
    public Optional<Slot> getById(String id) {
        return slotRepository.findById(id);
    }

    @Override
    public Slot save(Slot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public void deleteById(String key) {
    }


}
