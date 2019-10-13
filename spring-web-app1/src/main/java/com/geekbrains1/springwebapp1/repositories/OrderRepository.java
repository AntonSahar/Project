package com.geekbrains1.springwebapp1.repositories;

import com.geekbrains1.springwebapp1.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
