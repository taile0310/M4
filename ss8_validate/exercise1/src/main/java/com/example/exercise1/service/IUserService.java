package com.example.exercise1.service;

import com.example.exercise1.model.User;

import java.util.List;

public interface IUserService {
    List<User> list();
    void save(User user);
}
