package com.eCommerce.cart.controller;

import com.eCommerce.cart.dto.CartDTO;
import com.eCommerce.cart.entity.CartEntity;
import com.eCommerce.cart.entity.PrimaryKey;
import com.eCommerce.cart.service.CartService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PutMapping("/cart/add")
    public String addToCart(@RequestBody CartDTO cartDTO){
        //Get userId of active user
        //CartDTO cartDTO=new CartDTO(productId,merchantId,quantity);
        return cartService.addToCart(cartDTO);
    }

    @DeleteMapping("/cart/delete")
    public String deleteFromCart(@RequestBody CartDTO cartDTO){
        return cartService.deleteFromCart(cartDTO);
    }

    @PostMapping("/cart/update")
    public String reduceQuantity(@RequestBody CartDTO cartDTO){
        return cartService.updateInCart(cartDTO);
    }

    @GetMapping("/cart/checkout")
    public List<CartEntity> checkout(@RequestParam Integer userId){
        return cartService.checkout(userId);
    }

    @GetMapping("/cart/details")
    public List<CartEntity> getAllProducts(@RequestParam Integer userId){
        return cartService.getAllProducts(userId);
    }



}
