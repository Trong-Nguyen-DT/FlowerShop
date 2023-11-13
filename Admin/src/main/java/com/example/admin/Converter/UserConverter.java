package com.example.admin.Converter;

import com.example.admin.Domain.User;
import com.example.admin.Entity.UserEntity;

public class UserConverter {
    public static User toModel(UserEntity userEntity) {
        User user = new User();



        return user;
    }
}
