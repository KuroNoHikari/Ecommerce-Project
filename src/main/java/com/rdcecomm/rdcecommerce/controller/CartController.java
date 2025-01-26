package com.rdcecomm.rdcecommerce.controller;

import com.rdcecomm.rdcecommerce.entity.Cart;
import com.rdcecomm.rdcecommerce.payload.AddToCartRequest;
import com.rdcecomm.rdcecommerce.services.CartService;
import com.rdcecomm.rdcecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @PostMapping("/add-to-cart")
    public Cart addToCart(@RequestBody AddToCartRequest addToCartRequest) {
        return cartService.addToCart(addToCartRequest);
    }


    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable Long cartId) {
        return cartService.getCart(cartId);
    }

    @PutMapping("/cart")
    public Cart updateCart(@RequestBody Cart cart){
    return cartService.updateCart(cart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<String> deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.ok("Cart with ID " + cartId + " has been deleted.");
    }

}
