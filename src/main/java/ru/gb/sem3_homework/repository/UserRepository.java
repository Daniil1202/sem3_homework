package ru.gb.sem3_homework.repository;

import org.springframework.stereotype.Repository;
import ru.gb.sem3_homework.domain.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
