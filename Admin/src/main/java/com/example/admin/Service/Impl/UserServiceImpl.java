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
    @Override
    public void addStaff(User user) {
        userRepository.save(UserConverter.toEntity(user));
    }
    @Override
    public User getStaffById(Long userId) {
        return UserConverter.toModel(userRepository.findById(userId).orElseThrow());
    }
    @Override
    public void detailStaff(User user) {
//        CustomerEntity customerEntity = customerRepository.findById(customer.getId()).orElseThrow();
        user.getImage();
        user.getId();
        user.getAddress();
        user.getRole();
        user.getUsername();
        user.getPassword();
        user.getBirthday();
        user.getPhone();
        user.getSalary();
    }
    @Override
    public void updateStaff(User user) {
        UserEntity userEntity = userRepository.findById(user.getId()).orElseThrow();
        userEntity.setFullName(user.getFullName());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setImage(user.getImage());
        userEntity.setPhone(user.getPhone());
        userEntity.setAddress(user.getAddress());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setSalary(user.getSalary());
        userEntity.setRole(user.getRole());
        userRepository.save(userEntity);
    }
    @Override
    public void deleteStaffById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        userEntity.setDeleted(true);
        userRepository.save(userEntity);
    }
    @Override
    public void restoreStaffById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        userEntity.setDeleted(false);
        userRepository.save(userEntity);
    }
}
