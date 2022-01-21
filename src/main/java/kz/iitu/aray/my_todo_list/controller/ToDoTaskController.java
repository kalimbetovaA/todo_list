package kz.iitu.aray.my_todo_list.controller;

import kz.iitu.aray.my_todo_list.model.ToDoTask;
import kz.iitu.aray.my_todo_list.service.ToDoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoTaskController {

    @Autowired
    private ToDoTaskService toDoTaskService;

    @GetMapping("/{id}")
    public ToDoTask getToDoTask(@PathVariable Long id) {
        return toDoTaskService.getToDoTask(id);
    }

    @PostMapping("")
    public void createToDoTask(@RequestBody ToDoTask toDoTask) {
        toDoTaskService.createToDoTask(toDoTask);
    }

    @PutMapping("/{id}")
    public void updateToDoTask(@PathVariable Long id, @RequestBody ToDoTask toDoTask) {
        toDoTaskService.updateToDoTask(id, toDoTask);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoTask(@PathVariable Long id) {
        toDoTaskService.deleteToDoTask(id);
    }

    @PutMapping("/done/{id}")
    public void markAsDone(@PathVariable Long id) {
        toDoTaskService.markAsDone(id);
    }

}
