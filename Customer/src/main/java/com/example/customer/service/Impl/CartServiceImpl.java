package com.example.customer.service.Impl;

import com.example.customer.converter.CartConverter;
import com.example.customer.domain.Cart;
import com.example.customer.entity.CartEntity;
import com.example.customer.entity.CartItemEntity;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.entity.ProductEntity;
import com.example.customer.repository.CartRepository;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.repository.ProductRepository;
import com.example.customer.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Cart getCartByUsernameCustomer(String name) {
        return CartConverter.toModel(cartRepository.findByCustomerEntity(customerRepository.findByUsername(name).orElseThrow()));
    }

    @Override
    public void addItem(String name, Long id) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElseThrow();
        CartEntity cartEntity = cartRepository.findByCustomerEntity(customerEntity);
//        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng hay chưa
        List<CartItemEntity> cartItems = cartEntity.getCartItemEntities();
        Optional<CartItemEntity> existingCartItem = cartItems.stream()
                .filter(item -> item.getProductEntity().getId().equals(id))
                .findFirst();
        if (existingCartItem.isPresent()) {
            // Tăng số lượng nếu sản phẩm đã tồn tại trong giỏ hàng
            CartItemEntity cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            // Tạo mới CartItemEntity và thêm vào giỏ hàng
            ProductEntity productEntity = productRepository.findById(id).orElseThrow();
            CartItemEntity newCartItem = new CartItemEntity();
            newCartItem.setProductEntity(productEntity);
            newCartItem.setQuantity(1);
            newCartItem.setCartEntity(cartEntity);
            cartItems.add(newCartItem);
        }

        // Cập nhật giỏ hàng
        cartEntity.setCartItemEntities(cartItems);
        cartRepository.save(cartEntity);
    }
}
