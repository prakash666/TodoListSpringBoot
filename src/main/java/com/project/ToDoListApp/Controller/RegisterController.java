package com.project.ToDoListApp.Controller;

import com.project.ToDoListApp.Entity.RegisterEntity;
import com.project.ToDoListApp.Service.RegisterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;


    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    @PostMapping("")
    public String registerUser(@RequestBody RegisterEntity todoAppRegisterEntity){
        registerService.registerUser(todoAppRegisterEntity);
        return "Register successful";
    }
}
