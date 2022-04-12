package mock.prj.finalp.services;

import mock.prj.finalp.model.Slot;

import java.util.List;
import java.util.Optional;

public interface SlotService extends IService<Slot,String> {

//    List<Slot> findSlotByStatus(Status status);
    List<Slot> findSlotByParkingLotId(Long id);
    Optional<Slot> getBySlotName (String slotName);
    String generateSlotId(String id);


}
