package com.example.customer.controller.RESTfulAPI;


import com.example.customer.domain.Cart;
import com.example.customer.domain.CartItem;
import com.example.customer.responseBody.BodyResponse;
import com.example.customer.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/cart")
public class CartAPIController {

    @Autowired
    private CartService cartService;

    @GetMapping()
    public ResponseEntity<List<CartItem>> viewCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()){
            Cart carts = cartService.getCartByUsernameCustomer(authentication.getName());
            return ResponseEntity.ok(carts.getCartItems());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("add/{id}")
    public ResponseEntity<BodyResponse> addItem(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        BodyResponse response = new BodyResponse();
        if (authentication.isAuthenticated()) {
            cartService.addItem(authentication.getName() ,id);
            response.setSuccess(true);
            response.setMessage("success");
        } else {
            response.setSuccess(false);
            response.setMessage("Unauthorized");
        }
        return ResponseEntity.ok(response);
    }
}
