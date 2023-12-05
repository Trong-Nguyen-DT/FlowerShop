package com.example.admin.Converter;

import com.example.admin.Domain.User;
import com.example.admin.Entity.UserEntity;

public class UserConverter {
    public static User toModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setFullName(userEntity.getFullName());
        user.setImage(userEntity.getImage());
        user.setPhone(userEntity.getPhone());
        user.setAddress(userEntity.getAddress());
        user.setBirthday(userEntity.getBirthday());
        user.setSalary(userEntity.getSalary());
        user.setRole(userEntity.getRole());
        user.setDeleted(userEntity.getDeleted());
        user.setOrders(userEntity.getOrderEntities().stream().map(OrderConverter::toModel).toList());

        return user;
    }
    public static UserEntity toEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setFullName(user.getFullName());
        userEntity.setImage(user.getImage());
        userEntity.setPhone(user.getPhone());
        userEntity.setAddress(user.getAddress());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setSalary(user.getSalary());
        userEntity.setRole(user.getRole());
        userEntity.setDeleted(false);
        return  userEntity;
    }

}
