package com.project.ToDoListApp.Repository;

import com.project.ToDoListApp.Entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

}
