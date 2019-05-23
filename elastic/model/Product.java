package com.techprimers.elastic.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

@Document(indexName = "users", type = "users", shards = 1)
public class Product {

    private String name;
    private int id;
    private Long Price;
    private Long MRP;
    private String subCategory;
    private String company;
    private HashMap<String,String> imageUrl;
    private double rating;
    private boolean avilable;
    HashMap<String,String> productAttribute=new HashMap<>();

    public Product(String name, int id, Long price, Long MRP, String subCategory, String company, HashMap<String, String> imageUrl, double rating, boolean avilable, HashMap<String, String> productAttribute) {
        this.name = name;
        this.id = id;
        Price = price;
        this.MRP = MRP;
        this.subCategory = subCategory;
        this.company = company;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.avilable = avilable;
        this.productAttribute = productAttribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public Long getMRP() {
        return MRP;
    }

    public void setMRP(Long MRP) {
        this.MRP = MRP;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public HashMap<String, String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(HashMap<String, String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvilable() {
        return avilable;
    }

    public void setAvilable(boolean avilable) {
        this.avilable = avilable;
    }

    public HashMap<String, String> getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(HashMap<String, String> productAttribute) {
        this.productAttribute = productAttribute;
    }

    public Product() {

    }
}
