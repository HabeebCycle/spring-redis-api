package com.habeebcycle.springredisapi.controller;

import com.habeebcycle.springredisapi.model.User;
import com.habeebcycle.springredisapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User add(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("user/all")
    public List<User> findAll(){
        return userService.findAllUser();
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable final String id){
        return userService.findUserById(id);
    }

    @DeleteMapping("user/delete/{id}")
    public List<User> delete(@PathVariable final String id){
        return userService.deleteUser(id);
    }

    @DeleteMapping("user/delete")
    public List<User> delete(@RequestBody User user){
        return userService.deleteUser(user);
    }

    @DeleteMapping("user/delete/all")
    public List<User> deleteAll(){
        return userService.deleteAllUsers();
    }


}
