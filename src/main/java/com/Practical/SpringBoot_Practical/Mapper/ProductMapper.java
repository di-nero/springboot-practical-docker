package com.Practical.SpringBoot_Practical.Mapper;

import com.Practical.SpringBoot_Practical.Dto.ProductDto;
import com.Practical.SpringBoot_Practical.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

    public Product toProductEntity(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        return product;
    }
}
