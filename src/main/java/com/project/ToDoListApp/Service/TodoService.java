package com.project.ToDoListApp.Service;


import com.project.ToDoListApp.Entity.QuoteEntity;
import com.project.ToDoListApp.Entity.TodoEntity;
import com.project.ToDoListApp.Exception.MyException;
import com.project.ToDoListApp.Repository.QuoteRepository;
import com.project.ToDoListApp.Repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {


    private final TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void postData(TodoEntity vo) {
        todoRepository.save(vo);
    }

    public ResponseEntity<List<TodoEntity>> getData() {
        return ResponseEntity.ok(todoRepository.findAll());

    }

    public List<TodoEntity> deleteData(Long id) {
        todoRepository.deleteById(id);
        List<TodoEntity> updatedList = todoRepository.findAll();
        return updatedList;
    }

    public void updateData(TodoEntity todoEntity) throws MyException {
        Optional<TodoEntity> optionalTodoEntity = todoRepository.findById(todoEntity.getId());
        if (optionalTodoEntity.isPresent()) {
            TodoEntity todoEntity1 = optionalTodoEntity.get();
            if (todoEntity.getTask() != null) {
                todoEntity1.setTask(todoEntity.getTask());
            }
            if (todoEntity.getType() != null) {
                todoEntity1.setType(todoEntity.getType());
            }
            if (todoEntity.getTaskDescription() != null) {
                todoEntity1.setTaskDescription(todoEntity.getTaskDescription());
            }
            if (todoEntity.getTaskCreatedTime() != null) {
                todoEntity1.setTaskCreatedTime(todoEntity.getTaskCreatedTime());
            } else {
                throw new MyException("It not found!!");
            }
            todoRepository.save(todoEntity);
        }

    }

    public List<TodoEntity> searchData(String task) throws MyException {
        List<TodoEntity> todoEntities = todoRepository.searchData(task);
        if (!todoEntities.isEmpty()) {
            return todoRepository.searchData(task);
        } else {
            throw new MyException("Search result not found !!" + task);
        }

    }

    public TodoEntity getData(TodoEntity todo) throws MyException {
        Optional<TodoEntity> getData = todoRepository.findById(todo.getId());
        if (getData.isPresent()) {
            return getData.get();
        } else {
            throw new MyException("you have Exceptions");
        }
    }

}






