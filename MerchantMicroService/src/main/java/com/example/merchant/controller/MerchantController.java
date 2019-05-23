package com.example.merchant.controller;

import com.example.merchant.dto.MerchantDTO;
import com.example.merchant.dto.MerchantSellsProductDTO;
import com.example.merchant.entity.Merchant;
import com.example.merchant.entity.MerchantSellsProduct;
import com.example.merchant.service.MerchantSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MerchantController {
    @Autowired
    private MerchantSevice merchantSevice;

    @PostMapping("/merchant/addmerchant")
    public MerchantDTO addMerchant(@RequestBody MerchantDTO merchantDTO){
        MerchantDTO merchantDTO1=merchantSevice.addMerchant(merchantDTO);
        return merchantDTO1;
    }
    @GetMapping("/merchant/getproducts")
    public ArrayList<MerchantSellsProductDTO> getProducts(@RequestParam Integer mId){
        ArrayList<MerchantSellsProductDTO> merchant1=merchantSevice.getProducts(mId);
        return merchant1;
    }
    @GetMapping("/merchant/getrating")
    public double getRating(@RequestParam Integer mId){
        double rating=merchantSevice.getRating(mId);
        return rating;
    }
    @PostMapping("/merchant/addproduct")
    public String addProduct(@RequestParam Integer mId,@RequestParam Integer pId,@RequestParam Integer stock){
        String result=merchantSevice.addProduct(mId,pId,stock);
        return result;
    }
    @GetMapping("/merchant/getmerchant")
    public MerchantDTO getmerchant(@RequestParam Integer mId){
        MerchantDTO merchantDTO=merchantSevice.getMerchant(mId);
        return merchantDTO;
    }
}
