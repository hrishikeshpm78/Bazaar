package com.eCommerce.cart.repository;

import com.eCommerce.cart.entity.CartEntity;
import com.eCommerce.cart.entity.PrimaryKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<CartEntity,Integer> {


//    @Query("select * from Cart where userId=:userId")
//    public Iterable<CartEntity> findByUserId(@Param("userId") String userId);

    List<CartEntity> findByuserId(Integer userId);
}
