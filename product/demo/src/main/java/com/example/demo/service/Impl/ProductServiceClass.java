package com.example.demo.service.Impl;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Product;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@Service
public class ProductServiceClass implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private MongoTemplate mongotemplate;

    @Override
    public Product createProduct(Product product) throws Exception {
      if (getProduct(product.getProductId()) == null) {
        return productRepository.save(product);

    }
        throw new Exception();
    }

    @Override
    public List<Product> getTopRated()
    {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC,"rating" ));
        return mongotemplate.find(query.limit(20), Product.class);
    }
    @Override
    public Product getProduct(String id) {
    if (productRepository.findOne(id) != null) {
        System.out.printf("result returned");
           return productRepository.findOne(id);
}
       System.out.printf("null returned");
        return null;
    }
     @Override
    public Product updateProduct(Product product) {
         return productRepository.save(product);
    }



}
