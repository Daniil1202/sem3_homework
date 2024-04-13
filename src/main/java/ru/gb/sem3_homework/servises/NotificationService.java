package ru.gb.sem3_homework.servises;

import org.springframework.stereotype.Service;
import ru.gb.sem3_homework.domain.User;

@Service
public class NotificationService {
    // метод для логирования информации
    public void notificationUser(User user){
        System.out.println("Пользователь зарегистрирован " + user.getName());

    }
    // консоль принтер(сообщение о том что кто то зарегитрировался)
    public void sendNotification(String s){
        System.out.println(s);
    }
    UserService userService;

}
