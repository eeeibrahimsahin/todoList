package com.capgemini.todoList.repository;

import com.capgemini.todoList.model.TodoItem;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoItemRepositoryImpl implements ITodoItemRepository {
    private List<TodoItem> todoItems = new ArrayList<>(Arrays.asList(
            new TodoItem(1, "Shopping", "Make shopping",
                    LocalDateTime.of(2021, 07, 23, 12, 15),
                    LocalDateTime.now()),
            new TodoItem(2, "Homework", "Do homework",
                    LocalDateTime.of(2021, 07, 15, 13, 15),
                    LocalDateTime.now())
    ));

    @Override
    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    @Override
    public TodoItem getTodoItemById(int id) {
        return todoItems.stream().filter(todoItem -> todoItem.getId() == id).findFirst().get();
    }

    @Override
    public TodoItem createTodoItem(TodoItem todoItem) {
        todoItem.setId(todoItems.size() + 1);
        todoItems.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem deleteItem(int id) {
        final Optional<TodoItem> item = todoItems.stream().filter(todoItem -> todoItem.getId() == id).findFirst();
        if (item.isEmpty()) {
            return null;
        }
        todoItems.remove(item.get());
        return item.get();

    }
}
