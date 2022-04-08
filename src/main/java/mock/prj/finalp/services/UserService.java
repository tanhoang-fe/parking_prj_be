package mock.prj.finalp.services;

import mock.prj.finalp.model.User;

import java.util.Optional;

public interface UserService extends IService<User,Long> {
    public Optional<User> getUserByUsername(String username);
}
