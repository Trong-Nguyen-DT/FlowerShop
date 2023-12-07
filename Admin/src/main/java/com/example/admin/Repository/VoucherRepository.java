package com.example.admin.Repository;

import com.example.admin.Entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {
    List<VoucherEntity> findAllByExpiredFalse();

    List<VoucherEntity> findAllByExpiredFalseAndConditionsPaymentOnlineFalseAndConditionPriceLessThanEqual(double totalPrice);

    List<VoucherEntity> findAllByExpiredFalseAndConditionPriceLessThanEqual(double totalPrice);
    VoucherEntity findByCode(String code);
}
