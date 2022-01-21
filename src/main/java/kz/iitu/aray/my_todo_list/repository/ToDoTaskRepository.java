package kz.iitu.aray.my_todo_list.repository;

import kz.iitu.aray.my_todo_list.model.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoTaskRepository extends JpaRepository<ToDoTask, Long> {
    List<ToDoTask> findByUserId(Long userId);
}
