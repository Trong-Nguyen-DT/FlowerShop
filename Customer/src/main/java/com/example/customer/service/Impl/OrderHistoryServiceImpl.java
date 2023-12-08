package com.example.customer.service.Impl;

import com.example.customer.converter.OrderConverter;
import com.example.customer.domain.Order;
import com.example.customer.domain.OrderHistory;
import com.example.customer.entity.*;
import com.example.customer.repository.*;
import com.example.customer.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<OrderHistory> getOrderByCustomer(String name) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElseThrow();
        return orderHistoryRepository.findAllByCustomerId(customerEntity.getId()).stream().map(OrderConverter::toModelOrderHistory).toList();
    }

    @Override
    public OrderHistory getOrderByOrderId(Long orderId, String name) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElseThrow();
        return OrderConverter.toModelOrderHistory(orderHistoryRepository.findByIdAndCustomerId(orderId, customerEntity.getId()));
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
            orderDetailHistoryEntity.setImage(entity.getProductEntity().getImage1());
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
        orderHistoryEntity.setOrderStatus(orderEntity.getOrderStatus());
        orderHistoryEntity.setPaymentOnline(orderEntity.isPaymentOnline());
        orderHistoryEntity.setShipPrice(orderEntity.getShipPrice());
        return orderHistoryRepository.save(orderHistoryEntity);
    }
}
