package com.capgemini.todoList.repository;

import com.capgemini.todoList.model.TodoList;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class TodoListRepositoryRepositoryImpl implements ITodoListRepository {
    private List<TodoList> todoLists = new ArrayList<>(Arrays.asList(
            new TodoList(1,"General",new TodoItemRepositoryRepositoryImpl().getTodoItems())
    ));
    @Override
    public List<TodoList> getTodoList() {
        return todoLists;
    }
}
