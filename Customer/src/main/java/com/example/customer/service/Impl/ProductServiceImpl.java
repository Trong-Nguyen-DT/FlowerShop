package com.example.customer.service.Impl;

import com.example.customer.converter.ProductConverter;
import com.example.customer.domain.Product;
import com.example.customer.entity.CategoryEntity;
import com.example.customer.entity.FlashSaleEntity;
import com.example.customer.entity.ProductEntity;
import com.example.customer.repository.CategoryRepository;
import com.example.customer.repository.FlashSaleRepository;
import com.example.customer.repository.OrderDetailHistoryRepository;
import com.example.customer.repository.ProductRepository;
import com.example.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FlashSaleRepository flashSaleRepository;

    @Autowired
    private OrderDetailHistoryRepository orderDetailHistoryRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll().stream().map(ProductConverter::toModel).toList();
    }

    @Override
    public List<Product> getAllProductByCategory(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId).stream().map(ProductConverter::toModel).toList();
    }

    @Override
    public Product getProductById(Long id) {
        return ProductConverter.toModel(productRepository.findById(id).orElseThrow());
    }

    @Override
    public List<Product> getAllProductSale() {
        return productRepository.findByFlashSaleEntityExpiredFalse().stream().map(ProductConverter::toModelSale).toList();
    }

    @Override
    public void updateExpiredFlashSale() {
        List<FlashSaleEntity> flashSaleEntities = flashSaleRepository.findAllByExpiredFalse();
        for (FlashSaleEntity flashSaleEntity: flashSaleEntities) {
            if (flashSaleEntity.getEndDate().isBefore(LocalDate.now())) {
                flashSaleEntity.setExpired(true);
                flashSaleRepository.save(flashSaleEntity);
            }
        }
    }

    @Override
    public List<Product> getProductBestSeller() {
        List<Object[]> products = orderDetailHistoryRepository.findTop10SellingProductsLimited();
        List<ProductEntity> productList = productRepository.findAll();
        List<Product> topProducts = new ArrayList<>();
        for (Object[] productData : products) {
            Long productId = (Long) productData[0];
            for (ProductEntity prod : productList) {
                if (prod.getId() == productId) {
                    topProducts.add(ProductConverter.toModel(prod));
                }
            }
        }
        return topProducts;
    }
}
