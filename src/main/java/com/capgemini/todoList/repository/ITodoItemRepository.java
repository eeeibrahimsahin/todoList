package com.capgemini.todoList.repository;

import com.capgemini.todoList.model.TodoItem;

import java.util.List;

public interface ITodoItemRepository {
    public List<TodoItem> getTodoItems();
    public TodoItem getTodoItemById(int id);
    public TodoItem createTodoItem(TodoItem todoItem);
}
