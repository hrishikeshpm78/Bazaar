package com.example.merchant.service;

import com.example.merchant.dto.MerchantDTO;
import com.example.merchant.dto.MerchantSellsProductDTO;
import com.example.merchant.entity.Merchant;
import com.example.merchant.entity.MerchantSellsProduct;

import java.util.ArrayList;


public interface MerchantSevice {

    MerchantDTO addMerchant(MerchantDTO merchantDTO);

    ArrayList<MerchantSellsProductDTO> getProducts(Integer mId);

    double getRating(Integer mId);

    String addProduct(Integer mId, Integer pId, Integer stock);

    MerchantDTO getMerchant(Integer mId);
}
