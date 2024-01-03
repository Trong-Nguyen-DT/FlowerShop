package com.example.admin.Service.Impl;

import com.example.admin.Converter.ItemConverter;
import com.example.admin.Converter.VoucherConverter;
import com.example.admin.Domain.Voucher;
import com.example.admin.Entity.FlashSaleEntity;
import com.example.admin.Entity.ItemEntity;
import com.example.admin.Entity.VoucherEntity;
import com.example.admin.Repository.VoucherRepository;
import com.example.admin.Service.VoucherService;
import com.example.admin.enums.VoucherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;
    @Override
    public List<Voucher>  getAllVoucher() {
        updateExpiredVoucherByDate();
        return voucherRepository.findAll().stream().map(VoucherConverter::toModel).toList();
    }
    @Override
    public boolean addVoucher(Voucher voucher) {
        Optional<VoucherEntity> optionalVoucher = voucherRepository.findAll().stream()
                .filter(entity -> entity.getCode().equals(voucher.getCode()))
                .findFirst();
        if (optionalVoucher.isPresent()) {
            return false;
        } else {
            updateExpiredVoucherByDate();
            voucher.setConditionsPaymentOnline(true);
            voucherRepository.save(VoucherConverter.toEntity(voucher));
            return true;
        }
    }
    @Override
    public Voucher getVoucherById(Long voucherId) {
        return VoucherConverter.toModel(voucherRepository.findById(voucherId).orElseThrow());
    }
    @Override
    public void updateVoucher(Voucher voucher) {
//        System.out.println("Voucher ID: " + voucher.getId());
        VoucherEntity voucherEntity = voucherRepository.findById(voucher.getId()).orElseThrow();
        voucherEntity.setCode(voucher.getCode());
        voucherEntity.setPercentage(voucher.getPercentage());
        voucherEntity.setUsageLimit(voucher.getUsageLimit());
        voucherEntity.setEndDate(voucher.getEndDate());
        voucherEntity.setStartDate(voucher.getStartDate());
        voucherEntity.setConditionPrice(voucher.getConditionPrice());
        voucherEntity.setType(voucher.getType());
        voucherEntity.setType(voucher.getType());
        voucherRepository.save(voucherEntity);
    }

    private void updateExpiredVoucherByDate() {
        List<VoucherEntity> voucherEntities = voucherRepository.findAllByExpiredFalse();
        List<VoucherEntity> voucherEntityList = voucherRepository.findAllByExpiredTrue();

        for (VoucherEntity voucherEntity: voucherEntities) {
            if (voucherEntity.getEndDate().isBefore(LocalDate.now()) || voucherEntity.getUsageLimit() == 0) {
                voucherEntity.setExpired(true);
                voucherRepository.save(voucherEntity);
            }
        }
        for (VoucherEntity voucher: voucherEntityList) {
            if (voucher.getEndDate().isAfter(LocalDate.now()) & voucher.getUsageLimit() != 0) {
                voucher.setExpired(false);
                voucherRepository.save(voucher);
            }
        }
    }
}
