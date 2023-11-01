package com.example.customer.responseBody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private boolean success;

    private String message;
}
