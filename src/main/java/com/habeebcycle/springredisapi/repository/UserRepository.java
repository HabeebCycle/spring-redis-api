package com.habeebcycle.springredisapi.repository;

import com.habeebcycle.springredisapi.model.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    List<User> findAll();

    User findById(String id);

    void update(User user);

    void delete(String id);

    void deleteAll();
}
