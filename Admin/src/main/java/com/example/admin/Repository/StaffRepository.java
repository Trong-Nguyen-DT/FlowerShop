package com.example.admin.Repository;

import com.example.admin.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<UserEntity, Long> {
}
