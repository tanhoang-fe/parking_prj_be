package mock.prj.finalp.repositories;

import mock.prj.finalp.model.UserInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInvoiceRepository extends JpaRepository<UserInvoice, Long> {
    List<UserInvoice> findAllByUserId(Long userId);
}
