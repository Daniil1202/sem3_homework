package ru.gb.sem3_homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.sem3_homework.domain.User;
import ru.gb.sem3_homework.servises.RegistrationService;

import java.util.List;

@RestController                // взаимодействие с браузером
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService registrationService;              // связь с сервисом регистрации
    @GetMapping                 // отправление на браузер всех зарегистрированных пользователей
    public List<User> userList(){                   //получение списка пользователей
        return registrationService.getGetDataProcessingService().
                getUserRepository().getUserList();
    }
    public String userAddFromParam(
            @RequestParam(defaultValue = "UserName") String name,
            @RequestParam(defaultValue = "0") int age,
            @RequestParam(defaultValue = "userName@email.ru") String email
    ){
        registrationService.processRegistration(name,age,email);
        return "User add from body";

    }

    @PostMapping("/body")      // добавление пользователей
    public String userAddFromBody(@RequestBody User user){
        registrationService.getGetDataProcessingService().getUserRepository().getUserList().add(user);
        return "User added from body";
    }

}
