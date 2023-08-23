package com.project.ToDoListApp.Repository;

import com.project.ToDoListApp.Entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RegisterRepository extends JpaRepository<RegisterEntity, Long> {
    Optional<RegisterEntity> findByEmail(String email);

}
