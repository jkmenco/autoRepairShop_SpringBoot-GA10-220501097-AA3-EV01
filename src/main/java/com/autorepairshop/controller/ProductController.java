package com.autorepairshop.controller;


import com.autorepairshop.dao.ProductDAO;
import com.autorepairshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.PathVariable; 

@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productDAO.getAllProducts());
        return "products";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam String name, @RequestParam double price) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productDAO.addProduct(p);
        return "redirect:/products";
    }

    @PostMapping("/products/update")
    public String updateProduct(@RequestParam int id, @RequestParam String name, @RequestParam double price) {
        Product p = new Product(id, name, price);
        productDAO.updateProduct(p);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productDAO.deleteProduct(id);
        return "redirect:/products";
    }
}

