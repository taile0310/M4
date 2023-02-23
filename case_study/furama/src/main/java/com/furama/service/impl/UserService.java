package com.furama.service.impl;

import com.furama.model.login.User;
import com.furama.repository.IUserRepository;
import com.furama.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }
}
