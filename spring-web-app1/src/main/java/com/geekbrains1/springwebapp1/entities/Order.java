package com.geekbrains1.springwebapp1.entities;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)//в orderItem есть ссылка на меня
    private List<OrderItem> items; //можеи найти список айтемов через меня в orderItem,
    // установили обратную связь
    @Column(name = "username")
    private String username;
    public Order() {
    }

    public Long getId() {
        return  id;
    }
    public void setId(Long id) {
        this.id=id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
