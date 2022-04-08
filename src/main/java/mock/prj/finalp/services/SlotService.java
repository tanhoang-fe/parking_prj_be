package mock.prj.finalp.services;

import mock.prj.finalp.model.ParkingLot;
import mock.prj.finalp.model.Slot;

import java.util.List;

public interface SlotService {
    Slot findById(Long id);

    void booking();

    List<Slot> findSlotByStatus(String status);
    List<Slot> findSlotByParkingLotId(Long id);

}
