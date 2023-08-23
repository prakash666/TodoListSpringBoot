package com.project.ToDoListApp.Repository;

import com.project.ToDoListApp.Entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Integer> {
}
