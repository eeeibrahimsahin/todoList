package com.capgemini.todoList.controller;

import com.capgemini.todoList.model.TodoItem;
import com.capgemini.todoList.model.TodoList;
import com.capgemini.todoList.model.User;
import com.capgemini.todoList.service.ITodoItemService;
import com.capgemini.todoList.service.ITodoListService;
import com.capgemini.todoList.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class WebController {
    private User loginUser;
    @Autowired
    private IUserService userService;
    @Autowired
    private ITodoItemService todoItemService;
    @Autowired
    private ITodoListService todoListService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/login")
    public ResponseEntity<User> getLoginUser() {
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<Boolean> checkUserLogin(@RequestBody User user) {
        return new ResponseEntity<>(userService.checkUserPassword(loginUser, user.getPassword()), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserPage(User user) {
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }

    @PostMapping(value = "/getUserById")
    public ResponseEntity<User> getUserById(@RequestBody User user) {
        loginUser = userService.getUserById(user.getId());
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }

    @GetMapping("/todoLists")
    public ResponseEntity<List<TodoList>> getTodoLists() {
        return new ResponseEntity<>(todoListService.getTodoList(), HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<TodoItem>> getTodoItems() {
        return new ResponseEntity<>(todoItemService.getTodoItems(), HttpStatus.OK);
    }

    @PostMapping("/createNewItem")
    public ResponseEntity<TodoItem> createNewItem(@RequestBody TodoItem todoItem) {
        System.out.println(todoItem.getDescription());
        todoItem.setCreatedTime(LocalDateTime.now());
        return new ResponseEntity<>(todoItemService.createTodoItem(todoItem), HttpStatus.OK);
    }
    @DeleteMapping("/item/delete/{id}")
    public ResponseEntity<TodoItem> deleteItem(@PathVariable int id) {
        return new ResponseEntity<>(todoItemService.deleteItem(id), HttpStatus.OK);
    }
}
