package com.eCommerce.cart.dto;

public class CartDTO {
    private int productId;
    private int merchantId;
    private int quantity;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public CartDTO(){

    }

    public CartDTO(int productId, int merchantId, int quantity) {
        this.productId=productId;
        this.merchantId=merchantId;
        this.quantity=quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
