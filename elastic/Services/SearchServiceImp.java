package com.techprimers.elastic.Services;
import com.techprimers.elastic.model.Product;

import java.util.HashMap;
import java.util.List;

public interface SearchServiceImp {

    public Product createProduct(Product product);
    public List<Product> searchProduct(String name);
    public boolean deleteAllProduct();
    public List<Product> getAllProduct();
    public boolean updatePrice(int id,Long price);
    public boolean updateRating(int id,double rating);
    public boolean updateAvilabe(int id,boolean avialable);
    public boolean updateImageUrl(int id, HashMap<String,String> Imageurl);
    public boolean updateProductAtrribute(int id,HashMap<String ,String > ProductAtrribute);

}
