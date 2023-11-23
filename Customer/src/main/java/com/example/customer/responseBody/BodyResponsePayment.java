package com.example.customer.responseBody;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BodyResponsePayment {
    private String code;
    private String desc;
    private DataResponsePayment data;
    private String signature;
}
