package com.example.admin.Controller.Admin;

import com.example.admin.Service.OrderDetailService;
import com.example.admin.Domain.OrderHistory;
import com.example.admin.Service.OrderService;
import com.example.admin.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("admin/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping()
    public String listOrderHistory(Model model) {
        model.addAttribute("orderHistories", orderService.getAllOrderHistory());
        model.addAttribute("customers",customerService.getAllCustomer());
        return "Admin/OrderHistoryAdmin";
    }
//    @GetMapping("/search")
//    public String searchOrderHistory (@RequestParam("startTime") LocalDateTime startTime,
//                                      @RequestParam("endTime") LocalDateTime endTime,Model model){
//        List<OrderHistory> orderHistories = orderService.getOrderByTime(startTime,endTime);
//        model.addAttribute("orders", orderHistories );
//        model.addAttribute("customers",customerService.getAllCustomer());
//        return "Admin/OrderHistorySearchAdmin";
//    }
//
//    @GetMapping("/{id}")
//    public String showOrderDetail(@PathVariable String id, Model model){
//        Long orderID = Long.parseLong(id);
//        model.addAttribute("orderDetails", orderDetailService.getAllDetailByOrderId(orderID));
//        return "Admin/OrderHistoryDetail";
//    }
}
