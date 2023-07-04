package com.Practical.SpringBoot_Practical.Dto;

import com.Practical.SpringBoot_Practical.Entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Double price;



    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
