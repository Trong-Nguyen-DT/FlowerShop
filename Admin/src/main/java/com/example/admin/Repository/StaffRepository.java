package com.example.admin.Repository;

import com.example.admin.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<UserEntity, Long> {
}
