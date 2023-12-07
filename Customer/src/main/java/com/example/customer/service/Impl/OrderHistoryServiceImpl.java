package com.example.customer.service.Impl;

import com.example.customer.entity.*;
import com.example.customer.repository.*;
import com.example.customer.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Autowired
    private OrderDetailHistoryRepository orderDetailHistoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemRepository cartItemRepository;


    @Override
    public void addOrder(String name, Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow();
        OrderHistoryEntity orderHistoryEntity = saveOrderHistory(orderEntity);
        saveOrderDetailHistory(orderEntity ,orderHistoryEntity);
        deleteCartItem(name);
    }

    private void deleteCartItem(String name) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElseThrow();
        cartItemRepository.deleteAllByCartEntity(customerEntity.getCartEntity());
    }

    private void saveOrderDetailHistory(OrderEntity orderEntity, OrderHistoryEntity orderHistoryEntity) {
        for (OrderDetailEntity entity: orderEntity.getOrderDetails()) {
            OrderDetailHistoryEntity orderDetailHistoryEntity = new OrderDetailHistoryEntity();
            orderDetailHistoryEntity.setOrderHistoryEntity(orderHistoryEntity);
            orderDetailHistoryEntity.setId(entity.getId());
            orderDetailHistoryEntity.setProductId(entity.getProductEntity().getId());
            orderDetailHistoryEntity.setNameProduct(entity.getProductEntity().getName());
            orderDetailHistoryEntity.setPriceProduct(entity.getProductEntity().getPrice());
            orderDetailHistoryEntity.setQuantity(entity.getQuantity());
            orderDetailHistoryRepository.save(orderDetailHistoryEntity);
        }
    }

    private OrderHistoryEntity saveOrderHistory(OrderEntity orderEntity) {
        OrderHistoryEntity orderHistoryEntity = new OrderHistoryEntity();
        orderHistoryEntity.setId(orderEntity.getId());
        orderHistoryEntity.setOrderDateTime(orderEntity.getOrderDateTime());
        orderHistoryEntity.setTotalPrice(orderEntity.getTotalPrice());
        orderHistoryEntity.setDiscount(orderEntity.getDiscount());
        orderHistoryEntity.setAmount(orderEntity.getAmount());
        orderHistoryEntity.setCustomerId(orderEntity.getCustomerEntity().getId());
        orderHistoryEntity.setFullNameCustomer(orderEntity.getCustomerEntity().getFullName());
        orderHistoryEntity.setPhoneCustomer(orderEntity.getCustomerEntity().getPhone());
        orderHistoryEntity.setEmailCustomer(orderEntity.getCustomerEntity().getEmail());
        orderHistoryEntity.setAddressId(orderEntity.getAddressEntity().getId());
        orderHistoryEntity.setAddress(orderEntity.getAddressEntity().getStreet() + ", " + orderEntity.getAddressEntity().getNameWard() + ", " + orderEntity.getAddressEntity().getNameDistrict() + ", " + orderEntity.getAddressEntity().getNameCity());
        orderHistoryEntity.setNameCustomerReceive(orderEntity.getAddressEntity().getNameCustomer());
        orderHistoryEntity.setPhoneCustomerReceive(orderEntity.getAddressEntity().getPhoneNumber());
        return orderHistoryRepository.save(orderHistoryEntity);
    }
}
