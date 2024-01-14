package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    public OrdersBusinessInterface service;

    @GetMapping("/")
    public String displayProducts(Model model) {

        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);
        return "orders";
    }
    @GetMapping("/addProduct")
    public String addProduct(Model model) {

        return "create_product";
    }

    @PostMapping("/doAddProduct")
    public String doAddProduct(@ModelAttribute("OrderModel") OrderModel orderModel) {

        service.addOrder(orderModel);

        return "redirect:/product/";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        OrderModel order = service.getOrderById(id);
        model.addAttribute("OrderModel", order);
        return "edit_product";
    }
    
    @PostMapping("/doEditProduct")
    public String doEditProduct(@ModelAttribute("OrderModel") OrderModel orderModel, Model model) {

        service.editOrder(orderModel);
        
        return "redirect:/product/";
    }

    @GetMapping("/delete/{id}")
    public String doDeleteProduct(@PathVariable Long id, Model model) {
        OrderModel order = service.getOrderById(id);
        service.removeOrder(order);
        return "redirect:/product/";
    }

}
