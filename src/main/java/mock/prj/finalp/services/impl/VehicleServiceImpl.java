package mock.prj.finalp.services.impl;

import mock.prj.finalp.model.Vehicle;
import mock.prj.finalp.services.VehicleService;

import java.util.List;
import java.util.Optional;

public class VehicleServiceImpl implements VehicleService {

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
        return null;
    }

    @Override
    public void deleteById(String key) {

    }
}
