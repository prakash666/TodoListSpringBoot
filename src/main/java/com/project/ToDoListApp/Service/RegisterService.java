package com.project.ToDoListApp.Service;
import com.project.ToDoListApp.Entity.RegisterEntity;
import com.project.ToDoListApp.Repository.RegisterRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository todoAppRegisterRepository){
        this.registerRepository = todoAppRegisterRepository;
    }

    public void registerUser(RegisterEntity todoAppRegisterEntity){
        registerRepository.save(todoAppRegisterEntity);
    }

}
