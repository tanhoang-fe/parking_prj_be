package mock.prj.finalp.services;

import mock.prj.finalp.model.User;
import mock.prj.finalp.model.UserInvoice;

import java.util.List;
import java.util.Optional;

public interface UserService extends IService<User,Long> {
    public Optional<User> getUserByUsername(String username);
    boolean existedUsername (String username);
}
