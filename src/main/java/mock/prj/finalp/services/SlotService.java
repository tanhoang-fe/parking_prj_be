package mock.prj.finalp.services;

import mock.prj.finalp.model.Slot;

import java.util.List;

public interface SlotService extends IService<Slot,Long> {

//    List<Slot> findSlotByStatus(Status status);
    List<Slot> findSlotByParkingLotId(Long id);

}
