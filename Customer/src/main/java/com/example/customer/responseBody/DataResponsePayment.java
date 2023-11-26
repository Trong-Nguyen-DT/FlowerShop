package com.example.customer.responseBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponsePayment {
    private String bin;
    private String accountNumber;
    private String accountName;
    private Long amount;
    private String description;
    private Integer orderCode;
    private String paymentLinkId;
    private String status;
    private String checkoutUrl;
    private String qrCode;
}
