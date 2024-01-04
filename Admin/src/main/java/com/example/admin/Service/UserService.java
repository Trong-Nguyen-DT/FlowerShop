package com.example.admin.Service;

import com.example.admin.Domain.StaffDTO;
import com.example.admin.Domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllStaff();
    boolean addStaff(StaffDTO user);

    User getStaffById(Long userId);

    void detailStaff(User user);

    void updateStaff(StaffDTO user);

    void deleteStaffById(Long userId);

    void restoreStaffById(Long userId);

    void resetPassword(Long id);
}
