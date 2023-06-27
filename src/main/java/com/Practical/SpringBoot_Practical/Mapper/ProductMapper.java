package com.Practical.SpringBoot_Practical.Mapper;

import com.Practical.SpringBoot_Practical.Dto.ProductDto;
import com.Practical.SpringBoot_Practical.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toProductDto(Product product){
        return new ProductDto(product);
    }

    public Product toProductEntity(ProductDto productDto){
        return new Product(productDto);
    }
}
