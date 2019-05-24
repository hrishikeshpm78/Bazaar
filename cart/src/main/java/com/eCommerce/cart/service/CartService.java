package com.eCommerce.cart.service;

import com.eCommerce.cart.dto.CartDTO;
import com.eCommerce.cart.entity.CartEntity;
import com.eCommerce.cart.entity.PrimaryKey;
import com.eCommerce.cart.repository.CartRepository;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public String addToCart(CartDTO cartDTO) {
        CartEntity cartEntity=new CartEntity();

        BeanUtils.copyProperties(cartDTO,cartEntity);
        //cartEntity.setQuantity(cartDTO.getQuantity());
        //cartEntity.setId(primaryKey);
        CartEntity result=cartRepository.save(cartEntity);
        if(result!=null)
            return "Successfully Added.";
        else
            return "Product not added in the cart.";
    }

    public String deleteFromCart(CartDTO cartDTO) {
        CartEntity cartEntity=new CartEntity();
        BeanUtils.copyProperties(cartDTO,cartEntity);
        cartRepository.delete(cartEntity);
        return "Deleted Successfully";

    }

//    public List<CartEntity> checkout(Integer userId) {
//        CartEntity result=null;
//        List<CartEntity> finalresult=null;
//      //  for(result : cartRepository.findByUserId(userId.toString())){
//        //    finalresult.add(result);
//
//       // }
//         List<CartEntity> a= (List<CartEntity>) cartRepository.findByUserId(userId.toString());
//        return a;
//    }

    public List<CartEntity> checkout(Integer userId){
        List<CartEntity> result=cartRepository.findByuserId(userId);
        return result;
    }

    public List<CartEntity> getAllProducts(Integer userId){
        List<CartEntity> result=cartRepository.findByuserId(userId);
        return result;
    }



    public String updateInCart(CartDTO cartDTO) {
        cartDTO.setQuantity((cartDTO.getQuantity()-1));
        CartEntity cartEntity=new CartEntity();
        BeanUtils.copyProperties(cartDTO,cartEntity);
        CartEntity result;
        result=cartRepository.save(cartEntity);
        if(result.getQuantity()>1){
            return "Quantity reduced by 1";
        }
        else{
            deleteFromCart(cartDTO);
            return "Product Removed";
        }
    }
}
