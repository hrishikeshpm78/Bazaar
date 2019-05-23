package com.example.merchant.service.impl;

import com.example.merchant.dto.MerchantDTO;
import com.example.merchant.dto.MerchantSellsProductDTO;
import com.example.merchant.entity.MSPIdClass;
import com.example.merchant.entity.Merchant;
import com.example.merchant.entity.MerchantSellsProduct;
import com.example.merchant.repository.MSPRepository;
import com.example.merchant.repository.MerchantRepository;
import com.example.merchant.service.MerchantSevice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantServiceImplementation implements MerchantSevice {

    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private MSPRepository mspRepository;
    @Override
    public MerchantDTO addMerchant(MerchantDTO merchantDTO) {
        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantDTO,merchant);
        Merchant merchant1=merchantRepository.save(merchant);

        MerchantDTO merchantDTO1=new MerchantDTO();
        BeanUtils.copyProperties(merchant,merchantDTO1);
        return merchantDTO1;
    }
    @Override
    public ArrayList<MerchantSellsProductDTO> getProducts(Integer mId) {
        ArrayList<MerchantSellsProduct> merchantSellsProduct=mspRepository.findBymId(mId);
        ArrayList<MerchantSellsProductDTO> merchantSellsProductDTOList=new ArrayList<MerchantSellsProductDTO>();
        BeanUtils.copyProperties(merchantSellsProduct,merchantSellsProductDTOList);
        return merchantSellsProductDTOList;
    }

    @Override
    public double getRating(Integer mId) {
        Merchant merchant1=merchantRepository.findRatingBymId(mId);
        return merchant1.getmRating();
    }

    @Override
    public String addProduct(Integer mId, Integer pId, Integer stock) {
        MerchantSellsProduct merchantSellsProductObject=new MerchantSellsProduct(mId,pId,stock,0);
        MerchantSellsProduct merchantSellsProduct=mspRepository.findOne(new MSPIdClass(mId,pId));
        if(merchantSellsProduct==null){
            mspRepository.save(merchantSellsProductObject);
            return "Product stock updated";
        }else{
            merchantSellsProductObject.setStock(stock+merchantSellsProduct.getStock());
            mspRepository.save(merchantSellsProductObject);
            return "New product added";
        }
    }

    @Override
    public MerchantDTO getMerchant(Integer mId) {
        Merchant merchant=merchantRepository.findOne(mId);
        MerchantDTO merchantDTO=new MerchantDTO();
        BeanUtils.copyProperties(merchant,merchantDTO);
        return merchantDTO;
    }
}
