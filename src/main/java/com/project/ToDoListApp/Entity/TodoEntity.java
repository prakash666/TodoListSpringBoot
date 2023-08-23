package com.project.ToDoListApp.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Enter task category")
    private String task;
    @NotBlank(message = "Enter type of task")
    private String type;
    @NotBlank(message = "Enter taskDescriptions")
    private String taskDescription;
    @Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date taskCreatedTime;





}
