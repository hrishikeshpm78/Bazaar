package com.example.merchant.repository;

import com.example.merchant.entity.MSPIdClass;
import com.example.merchant.entity.MerchantSellsProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MSPRepository extends CrudRepository<MerchantSellsProduct,MSPIdClass> {

    ArrayList<MerchantSellsProduct> findBymId(Integer mId);
}
