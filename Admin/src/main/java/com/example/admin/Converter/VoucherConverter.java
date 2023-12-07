package com.example.admin.Converter;

import com.example.admin.Domain.Voucher;
import com.example.admin.Entity.VoucherEntity;

public class VoucherConverter {
    public static Voucher toModel(VoucherEntity voucherEntity) {
        Voucher voucher = new Voucher();
        voucher.setId(voucherEntity.getId());
        voucher.setTitle(voucherEntity.getTitle());
        voucher.setCode(voucherEntity.getCode());
        voucher.setIcon(voucherEntity.getIcon());
        voucher.setConditionsPaymentOnline(voucherEntity.isConditionsPaymentOnline());
        voucher.setPercentage(voucherEntity.getPercentage());
        voucher.setUsageLimit(voucherEntity.getUsageLimit());
        voucher.setStartDate(voucherEntity.getStartDate());
        voucher.setEndDate(voucherEntity.getEndDate());
        voucher.setConditionPrice(voucherEntity.getConditionPrice());
        voucher.setExpired(voucherEntity.isExpired());
        return voucher;
    }
    public static VoucherEntity toEntity(Voucher voucher){
        VoucherEntity voucherEntity = new VoucherEntity();
        voucherEntity.setId(voucher.getId());
        voucherEntity.setTitle(voucher.getTitle());
        voucherEntity.setCode(voucher.getCode());
        voucherEntity.setIcon(voucher.getIcon());
        voucherEntity.setConditionsPaymentOnline(voucher.isConditionsPaymentOnline());
        voucherEntity.setPercentage(voucher.getPercentage());
        voucherEntity.setUsageLimit(voucher.getUsageLimit());
        voucherEntity.setStartDate(voucher.getStartDate());
        voucherEntity.setEndDate(voucher.getEndDate());
        voucherEntity.setConditionPrice(voucher.getConditionPrice());
        voucherEntity.setExpired(voucher.isExpired());
        voucherEntity.setType(voucher.getType());
        return voucherEntity;

    }
}