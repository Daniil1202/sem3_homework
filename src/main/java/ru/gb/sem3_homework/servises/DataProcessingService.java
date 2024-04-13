package ru.gb.sem3_homework.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sem3_homework.domain.User;
import ru.gb.sem3_homework.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void addUserToList(User user){
        userRepository.getUserList().add(user);
    }
    public List<User> sortedUserByAge(List<User> userList){
        return userList.stream().sorted
                (Comparator.comparing(User::getAge)).collect(Collectors.toList());
    }
    public List<User> filterUserByAge(List<User> userList, int age){
        return userList.stream().filter(user -> user.getAge()>age).collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> userList){
        return userList.stream().mapToInt
                (User::getAge).average().orElse(0);
    }

}
