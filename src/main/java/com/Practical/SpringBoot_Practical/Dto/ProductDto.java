package com.Practical.SpringBoot_Practical.Dto;

import com.Practical.SpringBoot_Practical.Entity.Product;

public class ProductDto {

    private String name;

    private String description;

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
