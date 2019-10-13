package com.geekbrains1.springwebapp1.services;

import com.geekbrains1.springwebapp1.entities.Product;
import com.geekbrains1.springwebapp1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductByTitle(String title) {
        return productRepository.findOneByTitle(title);
    }
    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }
    public void deleteProductById(Long id){
         productRepository.deleteById(id);
    }
}
