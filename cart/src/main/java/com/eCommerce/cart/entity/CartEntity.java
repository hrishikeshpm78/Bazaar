package com.eCommerce.cart.entity;

import javax.persistence.*;


@Entity @IdClass(PrimaryKey.class)
@Table(name= "Cart")
public class CartEntity {
    @Id
    private int productId;
    @Id
    private int merchantId;
    @Id
    private int userId;

    private int quantity;
//    @EmbeddedId
//    PrimaryKey id;

    @Override
    public String toString() {
        return "CartEntity{" +
                "productId=" + productId +
                ", merchantId=" + merchantId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }
//
//    public int getMerchantId() {
//        return merchantId;
//    }
//
//    public void setMerchantId(int merchantId) {
//        this.merchantId = merchantId;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
}
