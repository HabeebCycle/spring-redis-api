package com.habeebcycle.springredisapi.service;

import com.habeebcycle.springredisapi.model.User;
import com.habeebcycle.springredisapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(String id){
        return userRepository.findById(id);
    }

    public User addUser(User user){
        user.setId(generateUUID());
        userRepository.save(user);
        return userRepository.findById(user.getId());
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        if(user.getId().isEmpty()){
            user.setId(generateUUID());
            return addUser(user);
        }else{
            userRepository.update(user);
            return findUserById(user.getId());
        }
    }

    public List<User> deleteUser(String id){
        userRepository.delete(id);
        return findAllUser();
    }

    public List<User> deleteUser(User user){
        deleteUser(user.getId());
        return findAllUser();
    }

    public List<User> deleteAllUsers(){
        userRepository.deleteAll();
        return findAllUser();
    }

    private String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
