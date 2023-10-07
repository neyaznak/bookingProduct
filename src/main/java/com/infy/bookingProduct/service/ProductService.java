package com.infy.bookingProduct.service;

import com.infy.bookingProduct.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product save(Product product);
    Product get(int code);
    void delete(int code);
    void deleteProduct(Product product);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByMrp(float mrp);

}
