package com.project.ToDoListApp.Controller;


import com.project.ToDoListApp.Entity.LoginEntity;
import com.project.ToDoListApp.Exception.MyException;
import com.project.ToDoListApp.Service.LoginService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService todoAppLoginService;

    public LoginController(LoginService todoAppLoginService){
        this.todoAppLoginService = todoAppLoginService;
    }

    @PostMapping("")
    public String todoLogin(@RequestBody @Valid LoginEntity loginEntity) throws MyException {
        todoAppLoginService.todoLogin(loginEntity);
        return "you have successfully Login";
    }






}
