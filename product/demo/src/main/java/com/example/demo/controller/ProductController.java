package com.example.demo.controller;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getproduct")
    public Product getProduct(@RequestParam String id)
    {
        Product product = productService.getProduct(id);
        return  product;
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product)
    {
        try {
            return productService.createProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/gettoprated")
    public List<Product> getTopRated()
    {
        return productService.getTopRated();
    }
    @PostMapping("/priceupdate")
    public Product priceUpdate(@RequestParam String id,@RequestParam long price)
    {   Product product = productService.getProduct(id);
        product.setPrice(price);

        try {
            return productService.updateProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @PostMapping("/ratingupdate")
    public Product ratingUpdate(@RequestParam String id,@RequestParam int rating)
    {
        Product product = productService.getProduct(id);
        product.setRating(rating);
        try {

            Product response= productService.updateProduct(product);
           // productService.updateTopSuggestion(id,rating);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    @PostMapping("/availabilityupdate")
    public Product availabilityUpdate(@RequestParam String id,@RequestParam boolean availability)
    {
        Product product = productService.getProduct(id);
        product.setAvailability(availability);
        try {
            return productService.updateProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {

        try {
            return productService.updateProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
