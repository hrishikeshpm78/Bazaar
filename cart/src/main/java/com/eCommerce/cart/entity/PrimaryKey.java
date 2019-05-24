package com.eCommerce.cart.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

public class PrimaryKey implements Serializable {
    private int productId;
    private int merchantId;
    private int userId;

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


}
