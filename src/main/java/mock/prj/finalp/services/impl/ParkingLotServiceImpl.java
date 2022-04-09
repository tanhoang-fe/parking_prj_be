package mock.prj.finalp.services.impl;

import mock.prj.finalp.model.ParkingLot;
import mock.prj.finalp.repositories.ParkingLotRepository;
import mock.prj.finalp.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Override
    public List getAll() {
        return parkingLotRepository.findAll();
    }

    @Override
    public Optional<ParkingLot> getById(Long key) {
        return Optional.empty();
    }

    @Override
    public ParkingLot save(ParkingLot entity) {
        return null;
    }

    @Override
    public void deleteById(Long key) {

    }

}

