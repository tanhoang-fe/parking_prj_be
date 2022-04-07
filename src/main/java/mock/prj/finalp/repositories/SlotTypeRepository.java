package mock.prj.finalp.repositories;

import mock.prj.finalp.model.SlotType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotTypeRepository extends JpaRepository<SlotType, Long> {
}
