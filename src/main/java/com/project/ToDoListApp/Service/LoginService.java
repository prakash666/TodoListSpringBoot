package com.project.ToDoListApp.Service;


import com.project.ToDoListApp.Entity.LoginEntity;
import com.project.ToDoListApp.Entity.RegisterEntity;
import com.project.ToDoListApp.Exception.MyException;
import com.project.ToDoListApp.Repository.LoginRepository;
import com.project.ToDoListApp.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class LoginService {
    @Autowired
    public LoginRepository todoAppLoginRepository;

    @Autowired
    public RegisterRepository todoAppRegisterRepository;



    public void todoLogin(LoginEntity todoAppLoginEntity) throws MyException {
      Optional<RegisterEntity> todoAppRegisterRepository1 = todoAppRegisterRepository.findByEmail(todoAppLoginEntity.getEmail());
      if (todoAppRegisterRepository1.isPresent()){
          RegisterEntity todoAppRegisterEntity = todoAppRegisterRepository1.get();
          if (todoAppRegisterEntity.getEmail().equals(todoAppLoginEntity.getEmail())&& todoAppRegisterEntity.getPassword().equals(todoAppLoginEntity.getPassword())){
              todoAppLoginRepository.save(todoAppLoginEntity);
          }
      } else {
          throw new MyException("you have exception");
      }

    }



}
