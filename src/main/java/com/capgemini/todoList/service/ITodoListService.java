package com.capgemini.todoList.service;

import com.capgemini.todoList.model.TodoList;
import com.capgemini.todoList.model.User;

import java.util.List;

public interface ITodoListService {
    public List<TodoList> getTodoList();
}
