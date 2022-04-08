package mock.prj.finalp.services.impl;

import mock.prj.finalp.services.VehicleService;

import java.util.List;
import java.util.Optional;

public class VehicleServiceImpl implements VehicleService {
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
