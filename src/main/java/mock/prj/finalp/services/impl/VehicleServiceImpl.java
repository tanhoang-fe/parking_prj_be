package mock.prj.finalp.services.impl;

import mock.prj.finalp.model.Vehicle;
import mock.prj.finalp.repositories.VehicleRepository;
import mock.prj.finalp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAll() {
        return null;
    }

    @Override
    public Optional<Vehicle> getById(String key) {
        return Optional.empty();
    }

    @Override
    public Vehicle save(Vehicle entity) {
        return vehicleRepository.save(entity);
    }

    @Override
    public void deleteById(String key) {

    }
}
