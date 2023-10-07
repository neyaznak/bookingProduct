package com.infy.bookingProduct.repo;

import com.infy.bookingProduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name = :value")
    List<Product> findByName(@Param("value")String value);

    @Query("SELECT p FROM Product p WHERE p.mrp = :value")
    List<Product> findByMrp(@Param("value")float value);

}
