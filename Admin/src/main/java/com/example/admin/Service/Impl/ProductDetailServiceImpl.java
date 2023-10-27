package com.example.admin.Service.Impl;

import com.example.admin.Entity.ItemEntity;
import com.example.admin.Entity.ProductDetailEntity;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Repository.ItemRepository;
import com.example.admin.Repository.ProductDetailRepository;
import com.example.admin.Repository.ProductRepository;
import com.example.admin.Service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;


    @Override
    public void addProductDetail(ProductEntity productEntity, List<Long> idList, int quantityFlower) {
        int totalItems = idList.size();
        int maxQuantityPerItem = quantityFlower / totalItems;

        List<Integer> quantities = new ArrayList<>();

        for (int i = 0; i < totalItems - 1; i++) {
            int randomQuantity = (int) (Math.random() * maxQuantityPerItem) + 1;
            quantities.add(randomQuantity);
        }

        int lastQuantity = quantityFlower - quantities.stream().mapToInt(Integer::intValue).sum();
        quantities.add(lastQuantity);

        for (int i = 0; i < totalItems; i++) {
            ProductDetailEntity productDetailEntity = new ProductDetailEntity();
            ItemEntity item = itemRepository.findById(idList.get(i)).orElseThrow();
            productDetailEntity.setQuantity(quantities.get(i));
            productDetailEntity.setItemsEntity(item);
            productDetailEntity.setProductEntity(productEntity);
            productDetailRepository.save(productDetailEntity);
        }
    }
}
