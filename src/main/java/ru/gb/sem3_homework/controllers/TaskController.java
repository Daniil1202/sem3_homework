package ru.gb.sem3_homework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.sem3_homework.domain.User;
import ru.gb.sem3_homework.servises.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;
    @GetMapping  // подключене методов в бруузер
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    //сортировка по возрасту
    public List<User> sortUserByAge(){
        return service.sortedUserByAge(service.getUserRepository().getUserList());
    }
    // фильтрация по возрасту
    @GetMapping(value = "/filter")
    public List<User> filterUserByAge(@RequestParam(defaultValue = "0")int age){
        return service.filterUserByAge(service.getUserRepository().getUserList(),age);

    }
    @GetMapping(value = "/filter/{age}")
    public List<User> filterUserByAgePath(@PathVariable int age){
        return service.filterUserByAge(service.getUserRepository().getUserList(),age);
    }

    //метод для вычесления среднего возраста
    @GetMapping("/calc")
    public double calcAverageAge(){
        return service.calculateAverageAge(service.getUserRepository().getUserList());
    }

}
