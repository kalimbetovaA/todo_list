package kz.iitu.aray.my_todo_list.service;

import kz.iitu.aray.my_todo_list.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User getUser(Long id);
    public void createUser(User user);
    public void updateUser(Long id, User user);
    public void deleteUser(Long id);
}
