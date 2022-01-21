package kz.iitu.aray.my_todo_list.repository;

import kz.iitu.aray.my_todo_list.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

