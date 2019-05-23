package com.example.demo.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = Product.COLLECTION_NAME)
public class Product {
    public static final String COLLECTION_NAME="COLLECTION";

    @Id
    private String productId;
    private  String name;
    private long price;
    private  long mrp;
    private String subCategory;
    private boolean availability;
    private String company;
    private double rating;
    private String imageUrl;
    private Map<String,String > productAttribute=new HashMap<>();

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getProductAttribute() {
        return productAttribute;
    }

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getMrp() {
        return mrp;
    }

    public void setMrp(long mrp) {
        this.mrp = mrp;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setProductAttribute(Map<String, String> productAttribute) {
        this.productAttribute = productAttribute;

    }
}
