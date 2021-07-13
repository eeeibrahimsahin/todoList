package com.capgemini.todoList.service;

import com.capgemini.todoList.model.User;
import com.capgemini.todoList.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }
    @Override
    public boolean checkUserPassword(User user, String password) {
        if (user.getPassword().equals(password))
            return true;
        return false;
    }
}
