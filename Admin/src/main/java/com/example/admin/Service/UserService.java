package com.example.admin.Service;

import com.example.admin.Domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllStaff();
    void addStaff(User user);

    User getStaffById(Long userId);

    void detailStaff(User user);

    void updateStaff(User user);

    void deleteStaffById(Long userId);

    void restoreStaffById(Long userId);
}
