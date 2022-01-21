package kz.iitu.aray.my_todo_list.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "todo_task")
public class ToDoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String priority;
    private String description;
    private Boolean isDone = false;
    private Date createdAt = new Date();


}
