package mock.prj.finalp.repositories;

import mock.prj.finalp.model.ParkingLot;
import mock.prj.finalp.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findAllByStatus(String status);

    @Query("SELECT s FROM Slot s WHERE s.parkingLot.parkingLotId = ?1")
    List<Slot> findAllByParkingLotId(Long id);

}
