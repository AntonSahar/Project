package com.geekbrains1.springwebapp1.controllers;

import com.geekbrains1.springwebapp1.entities.Order;
import com.geekbrains1.springwebapp1.services.OrderService;
import com.geekbrains1.springwebapp1.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/cart")
public class CartController {
    private ShoppingCart cart;
    private OrderService orderService;
    @Autowired
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
    @GetMapping("")
    public String showCart(Model model){
        model.addAttribute("items",cart.getItems());
        return "cart";
    }
    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id){
        cart.addProductById(id);
        return "redirect:/shop";
    }

    @GetMapping("/create_order")
    public String createOrder(Principal principal)//инжектиться информация о пользователе
    {
        Order order=new Order();
        order.setItems(new ArrayList<>());
        order.setUsername(principal.getName());
        cart.getItems().stream().forEach(
                i->{
                    order.getItems().add(i);
                    i.setOrder(order);
                }
        );
        cart.getItems().clear();
        orderService.saveOrder(order);
        return "redirect:/shop";
    }
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
