package kz.iitu.aray.my_todo_list.service.impl;

import kz.iitu.aray.my_todo_list.model.User;
import kz.iitu.aray.my_todo_list.repository.UserRepository;
import kz.iitu.aray.my_todo_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User dbUser = userOptional.get();
            dbUser.setUsername(user.getUsername());
            dbUser.setPassword(user.getPassword());
            userRepository.saveAndFlush(dbUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        }
    }
}
