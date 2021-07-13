package com.capgemini.todoList.repository;

import com.capgemini.todoList.model.User;

import java.util.List;

public interface IUserRepository {
    public List<User> getUsers();
    public User getUserById(int id);
}
