package ru.gb.sem3_homework.servises;

import org.springframework.stereotype.Service;
import ru.gb.sem3_homework.domain.User;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class UserService {
    private NotificationService notificationService;

//    public UserService(NotificationService notificationService){
//        this.notificationService = notificationService;
//    }

    // подключение пользователя
    public User createUser(String name,int age,String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // уведомление о создании нового пользователя
        notificationService.notificationUser(user);
        return user;
    }

}
