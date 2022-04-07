package mock.prj.finalp.services;

import mock.prj.finalp.model.Slot;

public interface SlotService {
    Slot findById(Long id);

    void booking();
}
