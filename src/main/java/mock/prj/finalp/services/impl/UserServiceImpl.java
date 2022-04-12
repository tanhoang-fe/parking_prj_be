package mock.prj.finalp.services.impl;

import mock.prj.finalp.model.Slot;
import mock.prj.finalp.model.User;
import mock.prj.finalp.repositories.UserRepository;
import mock.prj.finalp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existedUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getById(Long key) {
        return Optional.empty();
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void deleteById(Long key) {

    }


}
