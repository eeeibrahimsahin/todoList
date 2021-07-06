package com.capgemini.todoList.service;

import com.capgemini.todoList.model.TodoItem;

import java.util.List;

public interface ITodoItemService {
    public List<TodoItem> getTodoItems();
    public TodoItem createTodoItem(TodoItem todoItem);
}
