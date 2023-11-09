package com.example.admin.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private Product product;
    private List<ItemDTO> selectedItems;
    private List<Long> categoryIDs;
}
