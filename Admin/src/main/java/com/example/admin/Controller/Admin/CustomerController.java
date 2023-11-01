package com.example.admin.Controller.Admin;

import com.example.admin.Domain.Customer;
import com.example.admin.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("admin/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String listCustomer(Model model) {
        model.addAttribute("customers", customerService.getAllCustomer());
        return "Admin/CustomerAdmin";
    }
    @GetMapping("detail/{id}")
    public String showEditCustomer(@PathVariable String id, Model model) {
        Long customerId = Long.parseLong(id);
        model.addAttribute("customer", customerService.getCustomerById(customerId));
        return "Admin/DetailCustomerAdmin";
    }
    @PostMapping("detail")
    public String detailCustomer(@ModelAttribute Customer customer) {
        customerService.detailCustomer(customer);
        return "redirect:/admin/customer";
    }

//        @GetMapping("restore")
//    public String listCustomerRestore(Model model) {
//        model.addAttribute("customers", customerService.getAllCustomer());
//        return "Admin/RestoreCustomerAdmin";
//    }
//
//    @GetMapping("restore/{id}")
//    public String restoreC(@PathVariable String id) {
//        Long customerId = Long.parseLong(id);
//        customerService.restoreCustomerById(customerId);
//        return "redirect:/admin/customer/restore";
//    }






//    @GetMapping("add")
//    public String showAddCustomer(Model model) {
//        model.addAttribute("customer", new Customer());
//        return "Admin/AddCustomerAdmin";
//    }

//    @PostMapping("add")
//    public String addCustomer(@ModelAttribute Customer customer) {
//        customerService.addCustomer(customer);
////        return "redirect:/admin/cate";
//        return "redirect:/admin/cus";
//    }

//    @GetMapping("edit/{id}")
//    public String showEditCustomer(@PathVariable String id, Model model) {
//        Long customerId = Long.parseLong(id);
//        model.addAttribute("customer", customerService.getCustomerById(customerId));
//        return "DetailCustomerAdmin";
//    }

//    @PostMapping("edit")
//    public String editCustomer(@ModelAttribute Customer customer) {
//        customerService.updateCustomer(customer);
//        return "redirect:/admin/customer";
//    }

//    @GetMapping("delete/{id}")
//    public String deleteCustomer(@PathVariable String id) {
//        Long customerId = Long.parseLong(id);
//        customerService.deleteCustomerById(customerId);
//        return "redirect:/admin/customer";
//    }

//    @GetMapping("restore")
//    public String listCustomerRestore(Model model) {
//        model.addAttribute("customers", customerService.getAllCustomer());
//        return "Admin/RestoreCustomerAdmin";
//    }

//    @GetMapping("restore/{id}")
//    public String restoreC(@PathVariable String id) {
//        Long customerId = Long.parseLong(id);
//        customerService.restoreCustomerById(customerId);
//        return "redirect:/admin/customer/restore";
//    }
}
