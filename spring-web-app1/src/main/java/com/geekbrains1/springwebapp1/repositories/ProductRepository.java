package com.geekbrains1.springwebapp1.repositories;


import com.geekbrains1.springwebapp1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product  findOneByTitle(String title);
    //List<Product> findAllByPriceBetweenAndTitle(int min, int max);
}
