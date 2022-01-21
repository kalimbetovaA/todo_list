package kz.iitu.aray.my_todo_list.service;

import kz.iitu.aray.my_todo_list.model.ToDoTask;
import org.springframework.stereotype.Service;

@Service
public interface ToDoTaskService {
    public ToDoTask getToDoTask(Long id);
    public void createToDoTask(ToDoTask toDoTask);
    public void updateToDoTask(Long id, ToDoTask toDoTask);
    public void deleteToDoTask(Long id);
    public void markAsDone(Long id);
}
