package com.rdcecomm.rdcecommerce.services;

import com.rdcecomm.rdcecommerce.entity.Cart;
import com.rdcecomm.rdcecommerce.entity.Item;
import com.rdcecomm.rdcecommerce.entity.Product;
import com.rdcecomm.rdcecommerce.payload.AddToCartRequest;
import com.rdcecomm.rdcecommerce.repository.CartRepository;
import com.rdcecomm.rdcecommerce.repository.ItemRepository;
import com.rdcecomm.rdcecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ItemRepository itemRepository;

    public Cart addToCart(AddToCartRequest addToCartRequest){
        Cart cart = new Cart();
        Optional<Cart> foundCart = cartRepository.findById(addToCartRequest.getCartId());

        if (foundCart.isPresent()){
            cart = foundCart.get();
        }

        Item item = new Item();

        Product product =  productRepository.findById(addToCartRequest.getProductId()).get();
        item.setProduct(product);
        item.setQuantity(addToCartRequest.getQuantity());

        double itemTotalPrice = 0;
        itemTotalPrice += product.getPrice() * item.getQuantity();
        item.setTotalPrice(itemTotalPrice);

        cart.getItems().add(item);
        item.setCart(cart);

        double totalPrice = 0;

        for(Item cartItem: cart.getItems()){
            totalPrice += cartItem.getTotalPrice();
        }
        cart.setTotalPrice(totalPrice);
        Cart saveCart = cartRepository.save(cart);

        return saveCart;
    }

    public Cart getCart(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        return cart.orElse(null);
    }



    public void deleteCart(Long cartId) {
        if (cartRepository.existsById(cartId)) {
            cartRepository.deleteById(cartId);
        } else {
            throw new RuntimeException("Cart not found with ID: " + cartId);
        }
    }


    public Cart updateCart(Cart cart) {
        Optional<Cart> foundCart = cartRepository.findById(cart.getCartId());
        if (foundCart.isEmpty()){
            throw new RuntimeException("Cart ID not found!");
        }
        Cart cartToUpdate = foundCart.get();
        cartToUpdate.setItems(cart.getItems());

        double totalPrice = 0;

        for(Item cartItem: cart.getItems()){
            double itemTotalPrice = 0;
            itemTotalPrice += cartItem.getProduct().getPrice() * cartItem.getQuantity();
            cartItem.setTotalPrice(itemTotalPrice);
            totalPrice += cartItem.getTotalPrice();
            cartItem.setCart(cartToUpdate);
        }
        cartToUpdate.setTotalPrice(totalPrice);
        return cartRepository.save(cartToUpdate);
    }
}

