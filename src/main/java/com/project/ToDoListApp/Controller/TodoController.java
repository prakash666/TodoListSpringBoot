package com.project.ToDoListApp.Controller;

import com.project.ToDoListApp.Entity.QuoteEntity;
import com.project.ToDoListApp.Entity.TodoEntity;
import com.project.ToDoListApp.Exception.MyException;
import com.project.ToDoListApp.Service.QuoteService;
import com.project.ToDoListApp.Service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/home")
@CrossOrigin("http://localhost:4200/")
public class TodoController {

    private final TodoService todoService;

    @Autowired
   public QuoteService quoteService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/")
    public List<QuoteEntity> description(){
        return quoteService.descriptions();
    }

    @PostMapping("/")
    public String Postdescription(@RequestBody QuoteEntity quoteEntity){
        return quoteService.Postdescriptions(quoteEntity);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postData(@RequestBody @Valid TodoEntity vo){
            todoService.postData(vo);
            return ResponseEntity.ok("List has been posted");
    }

    @GetMapping("/viewList")
    public ResponseEntity <List<TodoEntity>> getData(){
        return todoService.getData();
    }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<TodoEntity>> deleteData(@PathVariable ("id")Long id){
        return ResponseEntity.ok(todoService.deleteData(id));
   }

   @PatchMapping ("/update/{id}")
    public String updateData(@RequestBody TodoEntity todoEntity) throws MyException {
        todoService.updateData(todoEntity);
        return "List has been updated!!";
   }

   @GetMapping("/search/{task}")
    public List<TodoEntity> search(@PathVariable  ("task") String task ) throws MyException{
        return todoService.searchData(task);
   }
    @GetMapping("/get/{id}")
    public TodoEntity getData(@PathVariable ("id") TodoEntity todo) throws MyException{
        return todoService.getData(todo);
    }
}


