package com.example.admin.Controller.Admin;

import com.example.admin.Domain.ItemDTO;
import com.example.admin.Domain.ProductDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/product")
public class ProductAPI {

    @PostMapping("add-product")
    public String addProduct(@RequestBody ProductDTO productDTO) {
        System.out.println(productDTO.getProduct().getName());
        System.out.println(productDTO.getProduct().getDescription());
        for (ItemDTO itemDTO: productDTO.getSelectedItems()) {
            System.out.println(itemDTO.getId());
            System.out.println(itemDTO.getQuantity());
        }
        for (Long id: productDTO.getCategoryIDs()) {
            System.out.println(id);
        }
        return "";
    }
}
