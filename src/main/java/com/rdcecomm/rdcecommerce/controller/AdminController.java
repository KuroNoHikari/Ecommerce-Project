package com.rdcecomm.rdcecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    /*@Autowired
    private AdminService adminService;
    @GetMapping("/products/view-products")
    public List<Admin> viewProduct() {
        return adminService.viewProduct();
    }
    @PostMapping("/products/add-products")
    public List<Admin> addProduct() {
        return adminService.addProduct();
    }

    @PutMapping("/products/update-product")
    public List<Admin> updateProduct() {
        return adminService.updateProduct();
    }
    @DeleteMapping("/products/delete-product")
    public List<Admin> deleteProduct() {
        return adminService.deleteProduct();
    }

    @GetMapping("/products/view-all-transactions")
    public List<Admin> viewAllTransactions() {
        return adminService.viewAllTransactions();
    }

    @PostMapping("/products/update-transaction")
    public List<Admin> updateTransaction() {
        return adminService.updateTransaction();
    }*/
}
