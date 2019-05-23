package com.techprimers.elastic.Services;

import com.techprimers.elastic.model.Product;
import com.techprimers.elastic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class SearchServiceClass implements SearchServiceImp {
    @Autowired
    ProductRepository usersRepository;



    @Override
    public Product createProduct(Product product) {
        return usersRepository.save(product);
    }

    @Override
    public List<Product> searchProduct(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public boolean deleteAllProduct() {
        usersRepository.deleteAll();
        return true;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> usersList = new ArrayList<>();
        Iterable<Product> userses = usersRepository.findAll();
        userses.forEach(usersList::add);
        return usersList;

    }

    @Override
    public boolean updatePrice(int id,Long Price) {
        System.out.println(usersRepository.findOne((long)id).getCompany());
        Product product=usersRepository.findOne((long)id);
        product.setPrice(Price);
        usersRepository.save(product);
        return true;
    }

    @Override
    public boolean updateRating(int id,double rating) {
        Product product=usersRepository.findOne((long)id);
         product.setRating(rating);
        usersRepository.save(product);
        return true;


    }

    @Override
    public boolean updateAvilabe(int id,boolean avilable) {
        Product product=usersRepository.findOne((long)id);
        product.setAvilable(avilable);
        usersRepository.save(product);
        return true;

    }

    @Override
    public boolean updateImageUrl(int id, HashMap<String,String> imageurl) {
        Product product=usersRepository.findOne((long)id);
        product.setImageUrl(imageurl);
        usersRepository.save(product);
        return true;

    }

    @Override
    public boolean updateProductAtrribute(int id,HashMap<String,String> ProductAtrribute) {
        Product product=usersRepository.findOne((long)id);
        product.setProductAttribute(ProductAtrribute);
        usersRepository.save(product);
        return true;

    }
}
