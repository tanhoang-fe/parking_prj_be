package mock.prj.finalp.repositories;

import mock.prj.finalp.model.UserInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInvoiceRepository extends JpaRepository<UserInvoice, Long> {
}
