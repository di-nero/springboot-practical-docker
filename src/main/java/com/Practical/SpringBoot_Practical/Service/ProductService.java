package com.Practical.SpringBoot_Practical.Service;



import com.Practical.SpringBoot_Practical.Dto.ProductDto;

import com.Practical.SpringBoot_Practical.Entity.Product;

import com.Practical.SpringBoot_Practical.Mapper.ProductMapper;

import com.Practical.SpringBoot_Practical.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheEvict;

import org.springframework.cache.annotation.CachePut;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @CachePut(value = "product", key = "#result.id")
    @CacheEvict(value = "allProducts", allEntries = true)
    public ProductDto createProductService(ProductDto productDto) {

        Product product = productMapper.toProductEntity(productDto);
        Product savedProduct = productRepository.save(product);

        return productMapper.toProductDto(savedProduct);
    }

    @Cacheable(value = "allProducts")
    public List<ProductDto> getAllProductService() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDto)
                .toList();
    }

    @Cacheable(value = "product", key = "#id")
    public ProductDto getProductByIdService(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));

        return productMapper.toProductDto(product);
    }

    @CachePut(value = "product", key = "#id")
    @CacheEvict(value = "allProducts", allEntries = true)
    public ProductDto updateProductService(ProductDto productDto, Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        Product updated = productRepository.save(product);

        return productMapper.toProductDto(updated);
    }

    @Caching(evict = {
            @CacheEvict(value = "product", key = "#id"),
            @CacheEvict(value = "allProducts", allEntries = true)
    })
    public void deleteProductService(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));

        productRepository.delete(product);
    }
}