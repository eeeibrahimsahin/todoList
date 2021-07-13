package com.capgemini.todoList.service;

import com.capgemini.todoList.model.TodoItem;
import com.capgemini.todoList.repository.ITodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoItemService implements ITodoItemService{
    @Autowired
    private ITodoItemRepository todoItemRepository;
    @Override
    public List<TodoItem> getTodoItems() {
        return todoItemRepository.getTodoItems();
    }

    @Override
    public TodoItem createTodoItem(TodoItem todoItem) {
        return todoItemRepository.createTodoItem(todoItem);
    }

    @Override
    public TodoItem deleteItem(int id) {
        return todoItemRepository.deleteItem(id);
    }
}
