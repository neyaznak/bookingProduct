package com.infy.bookingProduct.service;

import com.infy.bookingProduct.model.Product;
import com.infy.bookingProduct.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts(){return productRepo.findAll();}

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product get(int code) {
        Optional<Product> optional = productRepo.findById(code);
        if(optional.isEmpty()){
            return null;
        }
        return optional.get();
    }

    @Override
    public void delete(int code) {
        productRepo.deleteById(code);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<Product> getProductsByMrp(float mrp) {
        return productRepo.findByMrp(mrp);
    }


}
