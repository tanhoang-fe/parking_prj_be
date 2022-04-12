package mock.prj.finalp.repositories;

import mock.prj.finalp.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepository extends JpaRepository<Slot, String> {
//    List<Slot> findAllByStatus(Status status);

    @Query("SELECT s FROM Slot s WHERE s.parkingLot.id = ?1")
    List<Slot> findAllByParkingLotId(String id);

    Optional<Slot> findBySlotName(String slotName);
}
