package kz.iitu.aray.my_todo_list.service;

import kz.iitu.aray.my_todo_list.model.ToDoTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoTaskService {
    public ToDoTask getToDoTask(Long id);
    public void createToDoTask(ToDoTask toDoTask, Long userId);
    public void updateToDoTask(Long id, ToDoTask toDoTask);
    public void deleteToDoTask(Long id);
    public void markAsDone(Long id);
    public List<ToDoTask> findByUserId(Long userId);
}
