package com.example.customer.converter;

import com.example.customer.domain.Cart;
import com.example.customer.entity.CartEntity;

public class CartConverter {
    public static Cart toModel(CartEntity cartEntity) {
        Cart cart = new Cart();
        cart.setId(cartEntity.getId());
        cart.setCustomer(CustomerConverter.toModel(cartEntity.getCustomerEntity()));
        cart.setCartItems(cartEntity.getCartItemEntities().stream().map(CartItemConverter::toModel).toList());
        return cart;
    }
}
