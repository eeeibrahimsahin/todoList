package com.capgemini.todoList.service;

import com.capgemini.todoList.model.User;

import java.util.List;

public interface IUserService {
    public List<User> getUsers();
    public User getUserById(int id);
    public boolean checkUserPassword(User user, String password);

}
