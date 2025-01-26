package com.rdcecomm.rdcecommerce.services;

import com.rdcecomm.rdcecommerce.entity.Cart;
import com.rdcecomm.rdcecommerce.entity.Product;
import com.rdcecomm.rdcecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long product_id) {
        productRepository.deleteById(product_id);
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
}
