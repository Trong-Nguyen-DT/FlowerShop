package com.example.admin.Converter;

import com.example.admin.Domain.Order;
import com.example.admin.Domain.OrderHistory;
import com.example.admin.Domain.Review;
import com.example.admin.Entity.OrderEntity;
import com.example.admin.Entity.OrderHistoryEntity;
import com.example.admin.Entity.ReviewEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OrderConverter {
    public static OrderHistory toModelHistory(OrderHistoryEntity orderHistoryEntity) {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setId(orderHistoryEntity.getId());
        orderHistory.setAmount(orderHistoryEntity.getAmount());
        orderHistory.setOrderDateTime(orderHistoryEntity.getOrderDateTime());
        orderHistory.setFullNameStaff(orderHistoryEntity.getFullNameStaff());
        orderHistory.setEmailCustomer(orderHistoryEntity.getEmailCustomer());
        orderHistory.setPhoneCustomer(orderHistoryEntity.getPhoneCustomer());
        orderHistory.setDiscount(orderHistoryEntity.getDiscount());
        orderHistory.setTotalPrice(orderHistoryEntity.getTotalPrice());
        orderHistory.setUserId(orderHistoryEntity.getUserId());
        orderHistory.setCustomerId(orderHistoryEntity.getCustomerId());
        orderHistory.setFullNameCustomer(orderHistoryEntity.getFullNameCustomer());
        orderHistory.setOrderDetailHistories(orderHistoryEntity.getOrderDetailHistoryEntities().stream().map(OrderDetailHistoryConverter::toModel).toList());

//        orderHistory.setUser(UserConverter.toModel(orderHistoryEntity.getUserEntity()));
//        orderHistory.setCustomer(CustomerConverter.toModel(orderHistoryEntity.getCustomerEntity()));

        return orderHistory;
    }

    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setAmount(orderEntity.getAmount());
        order.setDiscount(orderEntity.getDiscount());
        order.setTotalPrice(orderEntity.getTotalPrice());
        order.setStatus(orderEntity.getStatus());
        order.setConfirmed(orderEntity.getConfirmed());
        order.setNote(orderEntity.getNote());
        order.setOrderDateTime(orderEntity.getOrderDateTime());
        order.setPaymentOnline(orderEntity.isPaymentOnline());
        order.setShipPrice(orderEntity.getShipPrice());
        order.setShipping(orderEntity.isShipping());
        order.setInformationRelated(orderEntity.getInformationRelated());
        order.setOrderStatus(orderEntity.getOrderStatus());

//        order.setAddress(AddressConverter.toModel(orderEntity.getAddressEntity()));
//        order.setUser(UserConverter.toModel(orderEntity.getUserEntity()));
//        order.setCustomer(CustomerConverter.toModel(orderEntity.getCustomerEntity()));
//        order.setVoucher(VoucherConverter.toModel(orderEntity.getVoucherEntity()));

        return order;
    }
    public static OrderEntity toEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setAmount(order.getAmount());
        orderEntity.setDiscount(order.getDiscount());
        orderEntity.setTotalPrice(order.getTotalPrice());
        orderEntity.setStatus(order.getStatus());
        orderEntity.setConfirmed(order.getConfirmed());
        orderEntity.setNote(order.getNote());
        orderEntity.setOrderDateTime(order.getOrderDateTime());
        orderEntity.setPaymentOnline(order.isPaymentOnline());
        orderEntity.setShipPrice(order.getShipPrice());
        orderEntity.setShipping(order.isShipping());
        orderEntity.setInformationRelated(order.getInformationRelated());
        orderEntity.setOrderStatus(order.getOrderStatus());

//        orderEntity.setAddressEntity(AddressConverter.toEntity(order.getAddress()));
//        orderEntity.setUserEntity(UserConverter.toEntity(order.getUser()));
//        orderEntity.setCustomerEntity(CustomerConverter.toEntity(order.getCustomer()));
//        orderEntity.setVoucherEntity(VoucherConverter.toEntity(order.getVoucher()));

        return orderEntity;
    }
    public static OrderHistory OrderEntitytoOrderHistory(OrderEntity orderEntity){
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setId(orderEntity.getId());
        orderHistory.setOrderDateTime(orderEntity.getOrderDateTime());
        orderHistory.setTotalPrice(orderEntity.getTotalPrice());
        orderHistory.setDiscount(orderEntity.getDiscount());
        orderHistory.setAmount(orderEntity.getAmount());
        orderHistory.setUserId(orderEntity.getUserEntity().getId());
        orderHistory.setFullNameStaff(orderEntity.getUserEntity().getFullName());
        orderHistory.setCustomerId(orderEntity.getCustomerEntity().getId());
        orderHistory.setFullNameCustomer(orderEntity.getCustomerEntity().getFullName());
        orderHistory.setPhoneCustomer(orderEntity.getCustomerEntity().getPhone());
        orderHistory.setEmailCustomer(orderEntity.getCustomerEntity().getEmail());
        orderHistory.setOrderDetailHistories(orderEntity.getOrderDetails().stream().map(OrderDetailConverter::OrderDetailEntitytoOrderDetailHistory).toList());

        return orderHistory;
    }
    public static List<OrderEntity> toEntityList(List<Order> orders) {
        return orders.stream()
                .map(OrderConverter::toEntity)
                .collect(Collectors.toList());
    }

}
