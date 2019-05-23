package com.techprimers.elastic.Controller;

import com.techprimers.elastic.Services.SearchServiceClass;
import com.techprimers.elastic.model.Product;
import com.techprimers.elastic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class SearchController {

    @Autowired
    SearchServiceClass serviceClass;


    @PostMapping(value = "create")
    public Product create(@RequestBody Product user)
    {
        System.out.println(user.getImageUrl());

        return serviceClass.createProduct(user);
    }

    @DeleteMapping(value = "delete")
    public boolean deleteall()
    {
         return serviceClass.deleteAllProduct();
    }

    @GetMapping(value = "/search/{text}")
    public List<Product> searchName(@PathVariable final String text)
    {
        return  serviceClass.searchProduct(text);
    }

    @GetMapping(value = "/all")
    public List<Product> searchAll() {
        return serviceClass.getAllProduct();
          }
    @PostMapping(value = "updatePrice")
    public boolean updatePrice(@RequestParam int id,@RequestParam Long price)
    {
        return serviceClass.updatePrice(id,price);
    }
    @PostMapping(value = "updateRating")
    public boolean updateRating(@RequestParam int id,@RequestParam double rating)
    {
        return serviceClass.updateRating(id,rating);
    }
    @PostMapping(value = "updateAvilabe")
    public boolean updateAvilabe(@RequestParam int id,@RequestParam boolean avialable)
    {
        return serviceClass.updateAvilabe(id,avialable);
    }
    @PostMapping(value = "updateImageUrl")
    public boolean updateImageUrl(@RequestParam int id,@RequestParam HashMap<String,String> Imageurl)
    {
        return serviceClass.updateImageUrl(id,Imageurl);
    }
    @PostMapping(value = "updateProAttri")
    public boolean updateProductAtrribute(@RequestParam int id,@RequestParam HashMap<String ,String > ProductAtrribute)
    {
        return serviceClass.updateProductAtrribute(id,ProductAtrribute);
    }

}
