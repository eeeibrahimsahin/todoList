package com.capgemini.todoList.repository;

import com.capgemini.todoList.model.TodoList;

import java.util.List;

public interface ITodoListRepository {
    public List<TodoList> getTodoList();
}
