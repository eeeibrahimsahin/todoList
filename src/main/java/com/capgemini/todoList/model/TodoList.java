package com.capgemini.todoList.model;

import java.util.List;

public class TodoList {
    private int id;
    private String name;
    private List<TodoItem> todoItemList;

    //This constructor is created for creating dummy data.


    public TodoList(int id, String name, List<TodoItem> todoItemList) {
        this.id = id;
        this.name = name;
        this.todoItemList = todoItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoItem> getTodoItemList() {
        return todoItemList;
    }

    public void setTodoItemList(List<TodoItem> todoItemList) {
        this.todoItemList = todoItemList;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", todoItemList=" + todoItemList +
                '}';
    }
}
