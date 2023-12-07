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

    public static OrderHistory toModelOrderHistory(OrderHistoryEntity orderHistoryEntity) {
        OrderHistory orderHistory = new OrderHistory();
        return orderHistory;
    }

    public static CartItem orderDetailToCartItem(OrderDetailEntity entity) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(ProductConverter.toModel(entity.getProductEntity()));
        cartItem.setQuantity(entity.getQuantity());
        return cartItem;
    }
}
