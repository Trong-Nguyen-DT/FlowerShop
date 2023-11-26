package com.example.customer.responseBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePayment {
    private boolean success;
    private String message;
    private DataResponsePayment data;
}
