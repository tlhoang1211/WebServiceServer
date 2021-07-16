package com.example.examws.service;

import com.example.examws.entity.Product;
import com.example.examws.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Component(value = "productService")
@WebService
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //save
    @WebMethod
    public boolean addProduct (Product product){
        productRepository.save(product);
        return true;
    }

    // find all
    @WebMethod
    public List<Product> getAllProducts (){
        return productRepository.findAll();
    }

    // find all
    @WebMethod
    public boolean sellProduct (int productId, int quantity){
        Product product = productRepository.findById(productId).orElse(null);
        product.setQuantity(quantity);
        productRepository.save(product);
        return true;
    }
}
