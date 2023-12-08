package com.example.admin.Service;

import com.example.admin.Domain.Voucher;
import com.example.admin.enums.VoucherType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoucherService {
    List<Voucher> getAllVoucherByConditions();
    void addVoucher(Voucher voucher);

    Voucher getVoucherById(Long voucherId);

    void updateVoucher(Voucher voucher);

//    VoucherType[] getAllVoucherType();
}