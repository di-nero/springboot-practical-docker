package com.Practical.SpringBoot_Practical.Service;

import com.Practical.SpringBoot_Practical.Dto.ProductDto;
import com.Practical.SpringBoot_Practical.Mapper.ProductMapper;
import com.Practical.SpringBoot_Practical.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductDto createProductService(ProductDto productDto){

        var product = productMapper.toProductEntity(productDto);

        return productMapper.toProductDto(productRepository.save(product));
    }

    public List<ProductDto> getAllProductService(){
        return productRepository
                .findAll()
                .stream()
                .map(student -> productMapper.toProductDto(student))
                .toList();
    }

    public ProductDto GetProductByIdService(Long  id){
        var result = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
        return productMapper.toProductDto(result);
    }

    public void deleteProductService(Long id){
        var product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
        productRepository.delete(product);
    }
}
