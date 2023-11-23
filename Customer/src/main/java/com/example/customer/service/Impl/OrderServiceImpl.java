package com.example.customer.service.Impl;

import com.example.customer.converter.CartConverter;
import com.example.customer.converter.SignatureGenerator;
import com.example.customer.converter.VoucherConverter;
import com.example.customer.domain.Order;
import com.example.customer.domain.OrderDetail;
import com.example.customer.domain.Voucher;
import com.example.customer.entity.*;
import com.example.customer.enums.OrderStatus;
import com.example.customer.remote.CurrencyConverterRemote;
import com.example.customer.remote.PaymentRemote;
import com.example.customer.repository.*;
import com.example.customer.responseBody.DataResponsePayment;
import com.example.customer.responseBody.BodyOrder;
import com.example.customer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CurrencyConverterRemote currencyConverterRemote;

    @Autowired
    private PaymentRemote paymentRemote;

    @Override
    public Long createOrder(BodyOrder order, String name) {
        OrderEntity orderEntity = saveOrder(order, name);
        saveOrderDetail(orderEntity);
        return orderEntity.getId();
    }

    @Override
    public DataResponsePayment createQrPayment(Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow();
        Order order = setOrder(orderEntity);
        return paymentRemote.getQrFromOtherClient(order);
    }

    @Override
    public BodyOrder returnCheckout(BodyOrder orderRequest, String name) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElseThrow();
        orderRequest.setCartItems(CartConverter.toModel(customerEntity.getCartEntity()).getCartItems());
        orderRequest.setShipPrice(1);
        double totalPrice = getTotalPrice(customerEntity);
        orderRequest.setTotalPrice(totalPrice);

        if (!orderRequest.isPaymentOnline()) {
            orderRequest.setVouchers(voucherRepository.findAllByExpiredFalseAndConditionsPaymentOnlineFalseAndConditionPriceLessThanEqual(totalPrice).stream().map(VoucherConverter::toModel).toList());
        } else {
            orderRequest.setVouchers(voucherRepository.findAllByExpiredFalseAndConditionPriceLessThanEqual(totalPrice).stream().map(VoucherConverter::toModel).toList());
        }
        double discount = 0;
        if (orderRequest.getVoucherId() != null) {
            discount = getMoneyByDiscount(totalPrice, voucherRepository.findById(orderRequest.getVoucherId()).orElseThrow());
        }
        orderRequest.setDiscount(discount);
        orderRequest.setAmount(totalPrice - discount);
        return orderRequest;
    }

    private OrderEntity saveOrder(BodyOrder order, String name) {
        CustomerEntity customerEntity = customerRepository.findByUsername(name).orElseThrow();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDateTime(LocalDateTime.now());
        double totalPrice = getTotalPrice(customerEntity);
        orderEntity.setTotalPrice(totalPrice);
        double discount = 0;
        if (order.getVoucherId() != null) {
            VoucherEntity voucherEntity = voucherRepository.findById(order.getVoucherId()).orElseThrow();
            orderEntity.setVoucherEntity(voucherEntity);
            discount = getMoneyByDiscount(totalPrice, voucherEntity);
        }
        orderEntity.setDiscount(discount);
        orderEntity.setAmount(totalPrice - discount);
        orderEntity.setConfirmed(false);
        orderEntity.setStatus(false);
        if (order.getNote() == null) {
            orderEntity.setNote("rỗng");
        } else {
            orderEntity.setNote(order.getNote());
        }
        orderEntity.setOrderStatus(OrderStatus.WAITTING);
        orderEntity.setAddressEntity(addressRepository.findById(order.getAddressId()).orElseThrow());
        orderEntity.setShipPrice(order.getShipPrice());
        orderEntity.setPaymentOnline(order.isPaymentOnline());
        orderEntity.setCustomerEntity(customerEntity);
        return orderRepository.save(orderEntity);
    }

    private void saveOrderDetail(OrderEntity orderEntity) {
        for (CartItemEntity entity: orderEntity.getCustomerEntity().getCartEntity().getCartItemEntities() ) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setOrderEntity(orderEntity);
            orderDetailEntity.setProductEntity(entity.getProductEntity());
            orderDetailEntity.setQuantity(entity.getQuantity());
            orderDetailRepository.save(orderDetailEntity);
        }
    }

    private Order setOrder(OrderEntity orderEntity) {
        Order order = new Order();
        order.setOrderCode(555 + orderEntity.getId());
        order.setAmount(usdToVND(orderEntity.getAmount()));
        order.setDescription("hoa hồng");
        order.setCustomer_id(orderEntity.getCustomerEntity().getId());
        order.setBuyerName(orderEntity.getCustomerEntity().getFullName());
        order.setBuyerPhone(orderEntity.getCustomerEntity().getPhone());
        order.setReturnUrl("thanh cong");
        order.setCancelUrl("that bai");
        order.setExpiredAt(getUnixTimestamp());
        order.setItems(setItems(orderEntity));
        Map<String, String> params = Map.of(
                "amount", String.valueOf(order.getAmount()),
                "cancelUrl", order.getCancelUrl(),
                "description", order.getDescription(),
                "orderCode", String.valueOf(order.getOrderCode()),
                "returnUrl", order.getReturnUrl()
        );

        String ChecksumKey = "22ee21ab306b80fac1782bb426e6140498bc4b5b9f483f30d4883f320731e29e";
        String signature = SignatureGenerator.generateSignature(params, ChecksumKey);
        order.setSignature(signature);
        return order;
    }

    private List<OrderDetail> setItems(OrderEntity orderEntity) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailEntity entity: orderDetailRepository.findAllByOrderEntity(orderEntity)) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setName(entity.getProductEntity().getName());
            orderDetail.setPrice(usdToVND(entity.getProductEntity().getPrice()));
            orderDetail.setQuantity(entity.getQuantity());
            orderDetails.add(orderDetail);
        }
        return orderDetails;
    }

    private Long usdToVND(double amountUSD) {
        double oneUSD = currencyConverterRemote.currencyConverter();
        amountUSD *= oneUSD;
        return (long) Math.ceil(amountUSD);
    }

    private long getUnixTimestamp() {
        // Lấy thời điểm hiện tại
        Instant now = Instant.now();
        // Thêm 1 giờ (3600 giây) vào thời điểm hiện tại
        Instant expiredAt = now.plusSeconds(900);
        // Lấy Unix Timestamp
        return expiredAt.getEpochSecond();
    }

    private double getTotalPrice(CustomerEntity customerEntity) {
        double totalPrice = 0;
        for (CartItemEntity entity: customerEntity.getCartEntity().getCartItemEntities()) {
            totalPrice += entity.getProductEntity().getPrice() * entity.getQuantity();
        }
        return totalPrice;
    }

    private double getMoneyByDiscount(double totalPrice, VoucherEntity voucherEntity) {
        return (voucherEntity.getPercentage() * totalPrice) / 100;
    }

}
