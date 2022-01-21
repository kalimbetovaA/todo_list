package kz.iitu.aray.my_todo_list.service.impl;

import kz.iitu.aray.my_todo_list.model.ToDoTask;
import kz.iitu.aray.my_todo_list.model.User;
import kz.iitu.aray.my_todo_list.repository.ToDoTaskRepository;
import kz.iitu.aray.my_todo_list.service.ToDoTaskService;
import kz.iitu.aray.my_todo_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoTaskServiceImpl implements ToDoTaskService {

    @Autowired
    private UserService userService;

    @Autowired
    private ToDoTaskRepository toDoTaskRepository;

    @Override
    public ToDoTask getToDoTask(Long id) {
        return toDoTaskRepository.getById(id);
    }

    @Override
    public void createToDoTask(ToDoTask toDoTask, Long userId) {
        User user = userService.getUser(userId);
        toDoTask.setUser(user);
        toDoTaskRepository.save(toDoTask);
    }

    @Override
    public void updateToDoTask(Long id, ToDoTask toDoTask) {
        Optional<ToDoTask> toDoTaskOptional = toDoTaskRepository.findById(id);

        if (toDoTaskOptional.isPresent()) {
            ToDoTask dbToDoTask = toDoTaskOptional.get();
            dbToDoTask.setTitle(toDoTask.getTitle());
            dbToDoTask.setDescription(toDoTask.getDescription());
            dbToDoTask.setIsDone(toDoTask.getIsDone());
            dbToDoTask.setPriority(toDoTask.getPriority());
            toDoTaskRepository.saveAndFlush(dbToDoTask);
        }
    }

    @Override
    public void deleteToDoTask(Long id) {
        Optional<ToDoTask> toDoTaskOptional = toDoTaskRepository.findById(id);

        if (toDoTaskOptional.isPresent()) {
            toDoTaskRepository.deleteById(id);
        }
    }

    @Override
    public void markAsDone(Long id) {
        Optional<ToDoTask> toDoTaskOptional = toDoTaskRepository.findById(id);

        if (toDoTaskOptional.isPresent()) {
            ToDoTask dbToDoTask = toDoTaskOptional.get();
            dbToDoTask.setIsDone(true);
            toDoTaskRepository.saveAndFlush(dbToDoTask);
        }
    }

    @Override
    public List<ToDoTask> findByUserId(Long userId) {
        return toDoTaskRepository.findByUserId(userId);
    }
}
