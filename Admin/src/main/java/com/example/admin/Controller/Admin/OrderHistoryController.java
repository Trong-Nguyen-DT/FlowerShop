package com.example.admin.Controller.Admin;

import com.example.admin.Service.OrderHistoryService;
import com.example.admin.Service.CustomerService;
import com.example.admin.Domain.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("admin/orderHistory")
public class OrderHistoryController {
    @Autowired
    private OrderHistoryService orderHistoryService;

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String listOrderHistory(Model model) {
        model.addAttribute("orderHistories", orderHistoryService.getAllOrderHistory());
        model.addAttribute("customers",customerService.getAllCustomer());
        return "Admin/OrderHistoryAdmin";
    }
    @GetMapping("/orderHistory/search")
    public String searchOrderHistory (@RequestParam("startTime") LocalDateTime startTime,
                                      @RequestParam("endTime") LocalDateTime endTime,Model model){
        List<OrderHistory> orderHistories = orderService.getOrderByTime(startTime,endTime);
        model.addAttribute("orders", orderHistories );
        model.addAttribute("customers",customerService.getAllCustomer());
        return "Admin/OrderHistorySearchAdmin";
    }
}
