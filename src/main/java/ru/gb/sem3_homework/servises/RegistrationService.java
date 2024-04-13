package ru.gb.sem3_homework.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sem3_homework.domain.User;

@Service
public class RegistrationService {
    @Autowired
    public DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;


    @Autowired
    public DataProcessingService getGetDataProcessingService(){
        return dataProcessingService;
    }
    //регистрация пользователя
    public void processRegistration(String name, int age, String email){
        User user = userService.createUser(name, age, email);
        getGetDataProcessingService().addUserToList(user);
        notificationService.sendNotification("User add" + user); // вывод на консоль о добавлении пользователя
    }
}


