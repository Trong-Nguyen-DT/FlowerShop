package com.example.customer.responseBody;

import com.example.customer.Payment.DataResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePayment {
    private boolean success;
    private String message;
    private DataResponse data;
}
