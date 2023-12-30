package com.example.admin.Controller.Admin;

import com.example.admin.Domain.*;
import com.example.admin.Domain.ResponseBody;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class ApiController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ImportGoodsService importGoodsService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @GetMapping("api/items")
    public List<Item> getAllItem() {
        return itemService.getAllItem();
    }

    @GetMapping("/category-data")
    public ResponseEntity<List<CategoryData>> getCategoryData() {
        List<CategoryData> data = categoryService.getAllCategoryData(); // Lấy dữ liệu từ cơ sở dữ liệu
        return ResponseEntity.ok(data);
    }

    @GetMapping("/amount-data")
    public ResponseEntity<List<AmountData>> getAmount() {
        List<AmountData> data = orderService.getAmountByMonth();

        return ResponseEntity.ok(data);
    }
//    @GetMapping("/importGoods")
//    public ResponseEntity<List<ImportGood>> getImportGoodsAmount(@RequestParam LocalDateTime startTime, @RequestParam LocalDateTime endTime) {
//        List<ImportGood> importGoods = importGoodsService.getAllImportGoodsByTime(startTime, endTime);
//        return ResponseEntity.ok(importGoods);
//    }

    @PostMapping("/purchase-history")
    public ResponseEntity<Response> postPurchaseHistory(@RequestBody TimeRange timeRange) {
        try {
            LocalDateTime startTime = timeRange.getStartTime();
            LocalDateTime endTime = timeRange.getEndTime();

            List<OrderHistory> orderHistories = orderService.getOrderByTime(startTime, endTime);
            Response response = new Response();
            response.setOrderHistories(orderHistories);

            // Sử dụng URLEncoder để mã hóa thời gian và xây dựng URL
            String encodedStartTime = URLEncoder.encode(startTime.toString(), StandardCharsets.UTF_8);
            String encodedEndTime = URLEncoder.encode(endTime.toString(), StandardCharsets.UTF_8);

            String url = "/admin/orders/search?startTime=" + encodedStartTime + "&endTime=" + encodedEndTime;
            System.out.println("url: " + url);
            response.setUrl(url);

            System.out.println("Thời điểm bắt đầu: " + startTime);
            System.out.println("Thời điểm kết thúc: " + endTime);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/purchase-import-goods")
    public ResponseEntity<Response> postPurchaseImportGoods(@RequestBody TimeRange timeRange) {
        try {
            LocalDateTime startTime = timeRange.getStartTime();
            LocalDateTime endTime = timeRange.getEndTime();

            List<OrderHistory> orderHistories = orderService.getOrderByTime(startTime, endTime);
            Response response = new Response();
            response.setOrderHistories(orderHistories);

            // Sử dụng URLEncoder để mã hóa thời gian và xây dựng URL
            String encodedStartTime = URLEncoder.encode(startTime.toString(), StandardCharsets.UTF_8);
            String encodedEndTime = URLEncoder.encode(endTime.toString(), StandardCharsets.UTF_8);

            String url = "/admin/importGood/search?startTime=" + encodedStartTime + "&endTime=" + encodedEndTime;
            System.out.println("url: " + url);
            response.setUrl(url);

            System.out.println("Thời điểm bắt đầu: " + startTime);
            System.out.println("Thời điểm kết thúc: " + endTime);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//    @Transactional
//    @PostMapping("/product-add")
//    public ResponseEntity<Map<String, String>> addProductAPI(@RequestBody ProductDTO productDto) {
//        try {
//            // Add your business logic to save the product and its associated categories
//            ProductEntity productEntity = productService.createProduct(productDto);
//            productService.setCategories(productEntity, productDto);
//
//            // Construct the URL based on your logic
//            String url = "/admin/product";  // Change this based on your requirements
//            System.out.printf("successPageUrl" + url);
//            System.out.println("successPageUrl" + ResponseEntity.EMPTY.getBody());
//            Map<String, String> responseMap = Collections.singletonMap("url", url);
//            // Return ResponseEntity with the URL as plain text in the body
//            return ResponseEntity.ok().body(responseMap);
//        } catch (Exception e) {
//            // Handle exceptions if needed
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(Collections.singletonMap("error", "Internal Server Error"));
//        }
//    }

    @Transactional
    @PostMapping("/product-add")
    public ResponseEntity<ResponseBody> addProduct(@ModelAttribute ProductDTO productDto) {
        try {
            ResponseBody response = new ResponseBody();
            if (productService.checkNameProduct(productDto.getName())) {
                System.out.println("vào đc");
                ProductEntity productEntity = productService.createProduct(productDto);
                productService.setCategories(productEntity, productDto);
                response.setSuccess(true);
                response.setMessage("success");
            } else {
                System.out.println("vào đây");
                response.setSuccess(false);
                response.setMessage("Products that already exist");
            }
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/reset-password/{id}")
    public ResponseEntity<String> resetPassword(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Thực hiện logic reset password tại đây
        // ...
        redirectAttributes.addAttribute("id", id);
        userService.resetPassword(id);
        System.out.println("Resetting password for user with id: " + id);
        // Sau khi reset password thành công, trả về đường dẫn mới (hoặc bất kỳ thông tin nào cần thiết)
        String redirectUrl = "/admin/staff/detail/"; // Thay đổi thành đường dẫn mong muốn
        return ResponseEntity.ok(redirectUrl);
    }
}
