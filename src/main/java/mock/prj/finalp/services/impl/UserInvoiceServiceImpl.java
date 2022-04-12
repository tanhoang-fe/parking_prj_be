package mock.prj.finalp.services.impl;

import mock.prj.finalp.model.UserInvoice;
import mock.prj.finalp.repositories.UserInvoiceRepository;
import mock.prj.finalp.services.UserInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInvoiceServiceImpl implements UserInvoiceService {

    @Autowired
    UserInvoiceRepository userInvoiceRepository;

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Optional<UserInvoice> getById(Long key) {
        return userInvoiceRepository.findById(key);
    }

    @Override
    public UserInvoice save(UserInvoice entity) {
        return userInvoiceRepository.save(entity);
    }

    @Override
    public void deleteById(Long key) {

    }


    @Override
    public List<UserInvoice> findAllByUserId(Long userId) {
        return userInvoiceRepository.findAllByUserId(userId);
    }
}
