package com.capgemini.todoList.service;

import com.capgemini.todoList.model.TodoList;
import com.capgemini.todoList.model.User;
import com.capgemini.todoList.repository.ITodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListServiceImpl implements ITodoListService {
    @Autowired
    private ITodoListRepository todoListRepository;

    @Override
    public List<TodoList> getTodoList() {
        return todoListRepository.getTodoList();
    }



}
