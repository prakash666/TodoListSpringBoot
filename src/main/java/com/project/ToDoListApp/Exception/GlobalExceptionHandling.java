package com.project.ToDoListApp.Exception;
import com.project.ToDoListApp.Model.TodoAppModel;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandling {


    @ExceptionHandler (MethodArgumentNotValidException.class)
    public List<TodoAppModel> MethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<TodoAppModel> todoAppModelList = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            todoAppModelList.add(new TodoAppModel(fieldError.getDefaultMessage()));
        });
        return todoAppModelList;
    }
    
    @ExceptionHandler (MyException.class)
    public String MyException(MyException e){
        return e.getMessage();
    }
}
