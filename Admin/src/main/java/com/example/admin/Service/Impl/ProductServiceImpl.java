package com.example.admin.Service.Impl;

import com.example.admin.Converter.CategoryConverter;
import com.example.admin.Converter.ProductConverter;
import com.example.admin.Converter.ProductDetailConverter;
import com.example.admin.Converter.UserConverter;
import com.example.admin.Domain.Category;
import com.example.admin.Domain.Product;
import com.example.admin.Domain.ProductDTO;
import com.example.admin.Domain.User;
import com.example.admin.Entity.CategoryEntity;
import com.example.admin.Entity.ProductEntity;
import com.example.admin.Repository.CategoryRepository;
import com.example.admin.Repository.ProductRepository;
import com.example.admin.Service.CategoryService;
import com.example.admin.Service.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll().stream().map(ProductConverter::toModel).toList();
    }
    public void addProduct(Product product) {
        productRepository.save(ProductConverter.toEntity(product));
    }
    @Override
    public Product getProductById(Long productId) {
        return ProductConverter.toModel(productRepository.findById(productId).orElseThrow());
    }
    @Override
    public void updateProduct(Product product) {
        // Lấy ProductEntity từ cơ sở dữ liệu hoặc ném ngoại lệ nếu không tìm thấy
        ProductEntity productEntity = productRepository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + product.getId()));

        // Cập nhật tất cả các trường từ Product
        productEntity.setName(product.getName());
        productEntity.setOriginal_price(product.getOriginalPrice());
        productEntity.setPrice(product.getPrice());
        productEntity.setDescription(product.getDescription());
        productEntity.setDetails(product.getDetails());
        productEntity.setDelivery(product.getDelivery());
        productEntity.setSub_info(product.getSub_info());
        productEntity.setOverall_rating(product.getOverall_rating());
        productEntity.setDiscount(product.getDiscount());
        productEntity.setImage1(product.getImage1());
        productEntity.setImage2(product.getImage2());
        productEntity.setImage3(product.getImage3());
        productEntity.setImage4(product.getImage4());
        productEntity.setImage5(product.getImage5());
        productEntity.setDeleted(product.isDeleted());

        productEntity.setCategoryEntities(product.getCategories().stream().map(CategoryConverter::toEntity).collect(Collectors.toList()));
        productEntity.setProductDetailEntities(ProductDetailConverter.toEntityList(product.getProductDetails()));

        // Lưu ProductEntity đã cập nhật vào cơ sở dữ liệu
        productRepository.save(productEntity);
    }

    @Override
    public void deleteProductById(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
        productEntity.setDeleted(true);
        productRepository.save(productEntity);
    }
    @Override
    public void restoreProductById(Long productId){
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
        productEntity.setDeleted(false);
        productRepository.save(productEntity);
    }

    @Override
    public ProductEntity createProduct(ProductDTO productDto) {
        ProductEntity entity = new ProductEntity();
        entity.setName(productDto.getName());
        entity.setOriginal_price(productDto.getOriginalPrice());
        entity.setDiscount(productDto.getDiscount());
        entity.setPrice(newPrice(productDto.getOriginalPrice(), productDto.getDiscount()));
        return productRepository.save(entity);
//
    }

    private Long newPrice(Long originalPrice, Long discount) {
        return((100-discount)* originalPrice) / 100;
    }

    @Override
    public void setCategories(ProductEntity entity, ProductDTO productDto) {
        System.out.println("id" + entity.getId());
        entity.setCategoryEntities(categoryRepository.findAllByIdIn(productDto.getCategoryIds()));
        System.out.println("size 2: " + entity.getCategoryEntities().size());
//        productRepository.
    }
}
