package com.example.admin.Service;

import com.example.admin.Domain.Voucher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoucherService {
    List<Voucher> getAllVoucher();
    void addVoucher(Voucher voucher);

    Voucher getVoucherById(Long voucherId);

    void updateVoucher(Voucher voucher);
}
