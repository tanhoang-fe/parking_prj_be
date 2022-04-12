package mock.prj.finalp.services;

import mock.prj.finalp.model.UserInvoice;

import java.util.List;

public interface UserInvoiceService extends IService<UserInvoice,Long>{
    List<UserInvoice> findAllByUserId(Long userId);

}
