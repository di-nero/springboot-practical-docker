package com.Practical.SpringBoot_Practical.Controller;


import com.Practical.SpringBoot_Practical.Dto.ProductDto;
import com.Practical.SpringBoot_Practical.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProductService(productDto);
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
       return productService.getAllProductService();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
       return productService.GetProductByIdService(id);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto , @PathVariable Long id){
        return productService.updateProductService(productDto , id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductService(id);
    }
}
