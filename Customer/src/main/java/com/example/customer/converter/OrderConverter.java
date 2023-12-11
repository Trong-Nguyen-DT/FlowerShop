package com.example.customer.converter;

import com.example.customer.domain.CartItem;
import com.example.customer.domain.Order;
import com.example.customer.domain.OrderDetail;
import com.example.customer.domain.OrderHistory;
import com.example.customer.entity.CartItemEntity;
import com.example.customer.entity.OrderDetailEntity;
import com.example.customer.entity.OrderEntity;
import com.example.customer.entity.OrderHistoryEntity;

public class OrderConverter {
    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setOrderDateTime(orderEntity.getOrderDateTime());
        order.setTotalPrice(orderEntity.getTotalPrice());
        order.setDiscount(orderEntity.getDiscount());
        order.setAmount(orderEntity.getAmount());
        order.setNote(orderEntity.getNote());
        order.setShipPrice(orderEntity.getShipPrice());
        order.setPaymentOnline(orderEntity.isPaymentOnline());
        order.setAddressId(orderEntity.getAddressEntity().getId());
        order.setVoucherId(orderEntity.getVoucherEntity().getId());
        order.setOrderStatus(orderEntity.getOrderStatus());
        order.setStatus(orderEntity.getStatus());
        order.setConfirmed(orderEntity.getConfirmed());
        return order;
    }

    public static OrderHistory toModelOrderHistory(OrderHistoryEntity entity) {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setId(entity.getId());
        orderHistory.setOrderDateTime(entity.getOrderDateTime());
        orderHistory.setTotalPrice(entity.getTotalPrice());
        orderHistory.setDiscount(entity.getDiscount());
        orderHistory.setAmount(entity.getAmount());
        orderHistory.setCustomerId(entity.getCustomerId());
        orderHistory.setFullNameCustomer(entity.getFullNameCustomer());
        orderHistory.setPhoneCustomer(entity.getPhoneCustomer());
        orderHistory.setEmailCustomer(entity.getEmailCustomer());
        orderHistory.setOrderStatus(entity.getOrderStatus());
        orderHistory.setNameCustomerReceive(entity.getNameCustomerReceive());
        orderHistory.setPhoneCustomerReceive(entity.getPhoneCustomerReceive());
        orderHistory.setAddress(entity.getAddress());
        orderHistory.setPaymentOnline(entity.isPaymentOnline());
        orderHistory.setShipPrice(entity.getShipPrice());
        orderHistory.setReviewed(entity.isReviewed());
        orderHistory.setOrderDetailHistories(entity.getOrderDetailHistoryEntities().stream().map(OrderDetailConverter::toOrderDetailHistory).toList());
        return orderHistory;
    }

    public static CartItem orderDetailToCartItem(OrderDetailEntity entity) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(ProductConverter.toModel(entity.getProductEntity()));
        cartItem.setQuantity(entity.getQuantity());
        return cartItem;
    }
}
