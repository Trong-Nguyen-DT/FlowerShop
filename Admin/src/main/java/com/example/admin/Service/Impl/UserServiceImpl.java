package com.example.admin.Service.Impl;

import com.example.admin.Converter.UserConverter;
import com.example.admin.Domain.User;
import com.example.admin.Entity.UserEntity;
import com.example.admin.Repository.UserRepository;
import com.example.admin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllStaff() {
        return userRepository.findAll().stream().map(UserConverter::toModel).toList();
    }
}
