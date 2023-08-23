package com.project.ToDoListApp.Repository;

import com.project.ToDoListApp.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    @Query (value = "SELECT * FROM todo_entity WHERE task= :task",nativeQuery = true)
    List<TodoEntity>searchData(String task);

}
