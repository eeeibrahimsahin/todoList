package com.capgemini.todoList.repository;

import com.capgemini.todoList.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "ibrahim", "Sahin", "ibra", "12345", new TodoListRepositoryImpl().getTodoList()),
            new User(2, "Alex", "De Souza", "alex", "12345", new TodoListRepositoryImpl().getTodoList()),
            new User(3, "Rihanna", "Fox", "fox", "12345", new TodoListRepositoryImpl().getTodoList())
    ));

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user1 = users.stream().filter(user -> user.getId() == id).findFirst().get();
        System.out.println("user1 = " + user1);
        return user1;
    }
}
