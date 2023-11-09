package com.example.customer.service;

import com.example.customer.domain.Cart;

import java.util.List;

public interface CartService {
    Cart getCartByUsernameCustomer(String name);

    void addItem(String name, Long id);
}
