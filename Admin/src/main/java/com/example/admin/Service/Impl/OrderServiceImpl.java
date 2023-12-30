package com.example.admin.Service.Impl;


import com.example.admin.Converter.OrderHistoryConverter;
import com.example.admin.Domain.AmountData;
import com.example.admin.Domain.OrderHistory;
import com.example.admin.Domain.OrderNote;
import com.example.admin.Entity.OrderEntity;
import com.example.admin.Entity.OrderHistoryEntity;
import com.example.admin.Repository.OrderHistoryRepository;
import com.example.admin.Repository.OrderRepository;
import com.example.admin.Service.OrderService;
import com.example.admin.config.MailService;
import com.example.admin.enums.OrderStatus;
import com.example.admin.exception.MessageException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MailService mailService;
    @Override
    public List<OrderHistory> getAllOrderHistory() {
        return orderHistoryRepository.findAll().stream().map(OrderHistoryConverter::toModel).toList();
    }
    @Override
    public List<OrderHistory> getOrderByTime(LocalDateTime startTime, LocalDateTime endTime) {
        return orderHistoryRepository.findOrderHistoryEntitiesByOrderDateTimeBetween(startTime, endTime).stream().map(OrderHistoryConverter::toModel).toList();
    }
    @Override
    public double getAllTotalByTime(LocalDateTime start, LocalDateTime end) {
        List<OrderHistory> orderHistories = orderHistoryRepository.findOrderHistoryEntitiesByOrderDateTimeBetween(start, end).stream().map(OrderHistoryConverter::toModel).toList();
        double totalAmount = 0L;
        for (OrderHistory orderHistory : orderHistories){
            totalAmount += orderHistory.getAmount();
        }
        return totalAmount;
    }
    @Override
    public List<OrderEntity> findAllList(Date from, Date to) {
        List<OrderEntity> list = null;
        if(from == null || to == null){
            list = orderRepository.findAll();
        }
        else{
            LocalDateTime datef = LocalDateTime.of(from.toLocalDate(), LocalTime.now());
            LocalDateTime datet = LocalDateTime.of(to.toLocalDate(), LocalTime.now());
            list = orderRepository.findByDate(datef, datet);
        }
        return list;
    }
    @Override
    public OrderEntity addNote(OrderNote orderNote) {
        Optional<OrderEntity> order = orderRepository.findById(orderNote.getOrderId());
        if (order.isEmpty()){
            throw new MessageException("order not found");
        }
        order.get().setNote(orderNote.getNote());
        order.get().setInformationRelated(orderNote.getInforRelated());
        OrderEntity result = orderRepository.save(order.get());
        return result;
    }

    @Override
    public OrderEntity findById(Long id) {
        Optional<OrderEntity> order = orderRepository.findById(id);
        if (order.isEmpty()){
            throw new MessageException("order not found");
        }
        return order.get();
    }

    @Override
    public void updateStatusOrder(OrderStatus orderStatus, Long orderId) {
        String sttname = orderStatus.name();
        Optional<OrderEntity> order = orderRepository.findById(orderId);
        if (order.isEmpty()){
            throw new MessageException("order not found");
        }
        order.get().setOrderStatus(orderStatus);
        orderRepository.save(order.get());
        String mail = order.get().getCustomerEntity().getEmail();
        try {
            mailService.sendEmail(mail,"Update status order flower web","Your order"+order.get().getId()+" has been updated to "+order.get().getOrderStatus().name()+" status",
                    false, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<AmountData> getAmountByMonth() {
        List<AmountData> amountDataList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            AmountData amountData = new AmountData();
            List<OrderHistoryEntity> orderHistoryEntities = orderHistoryRepository.findOrdersByMonthAndYear(i, LocalDateTime.now().getYear());
            double amountMonth = 0L;
            for (OrderHistoryEntity orderHistoryEntity : orderHistoryEntities) {
                amountMonth += orderHistoryEntity.getAmount();
            }
            amountData.setAmount(amountMonth);
            amountData.setMonth(String.valueOf(i));
            amountDataList.add(amountData);
        }
        return amountDataList;
    }
    @Override
    public List<OrderHistory> getOrderByMonth(int month, int year) {
        return orderHistoryRepository.findOrdersByMonthAndYear(month, year).stream().map(OrderHistoryConverter::toModel).toList();
    }
    @Override
    public double getPercentCompare(double totalThisMonth, double totalLastMonth) {
        double percentage = (double) totalThisMonth / totalLastMonth * 100;
        percentage -= 100;
        String formattedPercentage = String.format("%.2f", percentage); // Định dạng số với tối đa 2 chữ số sau dấu phẩy
        return Double.parseDouble(formattedPercentage);
    }
    @Override
    public double getTotalAmountByOrder(List<OrderHistory> orderHistories) {
        double totalAmount = 0L;
        for (OrderHistory orderHistory : orderHistories){
            totalAmount += orderHistory.getAmount();
        }
        return totalAmount;
    }
    public double getTotalRevenueByTime(LocalDateTime startTime, LocalDateTime endTime) {
        return orderHistoryRepository.getTotalRevenueByTime(startTime, endTime);
    }
}
