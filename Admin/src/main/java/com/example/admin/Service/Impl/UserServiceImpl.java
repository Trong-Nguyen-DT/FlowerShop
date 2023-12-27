package com.example.admin.Service.Impl;

import com.example.admin.Converter.CategoryConverter;
import com.example.admin.Converter.UserConverter;
import com.example.admin.Domain.User;
import com.example.admin.Entity.CategoryEntity;
import com.example.admin.Entity.UserEntity;
import com.example.admin.Repository.StaffRepository;
import com.example.admin.Repository.UserRepository;
import com.example.admin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StaffRepository staffRepository;
    @Override
    public List<User> getAllStaff() {
        return staffRepository.findAll().stream().map(UserConverter::toModel).toList();
    }
    @Override
    public boolean addStaff(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity();

        Optional<UserEntity> optionalUserName = staffRepository.findAll().stream()
                .filter(entity -> entity.getUsername().equals(user.getUsername()))
                .findFirst();
        Optional<UserEntity> optionalPhoneUser = staffRepository.findAll().stream()
                .filter(entity -> entity.getPhone().equals(user.getPhone()))
                .findFirst();
        if (optionalUserName.isPresent() || optionalPhoneUser.isPresent()){
            return false;
        }else {
            userEntity.setId(user.getId());
            userEntity.setUsername(user.getUsername());
            userEntity.setPassword(passwordEncoder.encode(user.getPassword())); // Mã hóa mật khẩu
            userEntity.setFullName(user.getFullName());
            userEntity.setImage(user.getImage());
            userEntity.setPhone(user.getPhone());
            userEntity.setAddress(user.getAddress());
            userEntity.setBirthday(user.getBirthday());
            userEntity.setSalary(user.getSalary());
            userEntity.setRole(user.getRole());
            userEntity.setDeleted(false);

            staffRepository.save(userEntity);

            return true;
        }
    }
    @Override
    public User getStaffById(Long userId) {
        return UserConverter.toModel(staffRepository.findById(userId).orElseThrow());
    }
    @Override
    public void detailStaff(User user) {
    }
    @Override
    public void updateStaff(User user) {
        UserEntity userEntity = staffRepository.findById(user.getId()).orElseThrow();

        userEntity.setFullName(user.getFullName());
        userEntity.setUsername(user.getUsername());
        userEntity.setImage(user.getImage());
        userEntity.setPhone(user.getPhone());
        userEntity.setAddress(user.getAddress());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setSalary(user.getSalary());
        userEntity.setRole(user.getRole());

        staffRepository.save(userEntity);
    }
    @Override
    public void deleteStaffById(Long userId) {
        UserEntity userEntity = staffRepository.findById(userId).orElseThrow();
        userEntity.setDeleted(true);
        staffRepository.save(userEntity);
    }
    @Override
    public void restoreStaffById(Long userId) {
        UserEntity userEntity = staffRepository.findById(userId).orElseThrow();
        userEntity.setDeleted(false);
        staffRepository.save(userEntity);
    }
    @Override
    public void resetPassword(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Khôi phục mật khẩu thành mật khẩu mặc định (ví dụ: chuỗi rỗng)
        String defaultPassword = "1";
        user.setPassword(passwordEncoder.encode(defaultPassword));

        // Lưu lại thông tin người dùng
        updateStaff(user);

        // Hủy bỏ phiên làm việc của người dùng sau khi reset mật khẩu
        SecurityContextHolder.clearContext();

        // Rest of your code...
        System.out.println("Reset password completed.");
    }
}
