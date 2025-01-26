package com.rdcecomm.rdcecommerce.controller;

import com.rdcecomm.rdcecommerce.entity.Product;
import com.rdcecomm.rdcecommerce.repository.ProductRepository;
import com.rdcecomm.rdcecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/get-all-products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    /*@GetMapping("/{product_Id}")
    public Cart getProduct(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }*/

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {

        Product product = productRepository.getReferenceById(productId);
        productRepository.delete(product);
        return ResponseEntity.ok("Product with ID " + productId + " has been deleted.");
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        return ResponseEntity.of(productService.getProductById(productId));
    }

    /*@PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }*/
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productService.getProductById(productId);
        existingProduct.get().setProduct(updatedProduct.getProduct());
        existingProduct.get().setModel(updatedProduct.getModel());
        existingProduct.get().setCategory(updatedProduct.getCategory());
        existingProduct.get().setDescription(updatedProduct.getDescription());
        existingProduct.get().setQuantity(updatedProduct.getQuantity());
        existingProduct.get().setPrice(updatedProduct.getPrice());
        return ResponseEntity.ok(productService.updateProduct(existingProduct.orElse(null)));
    }
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @PostMapping("/product")
    public Product addNewProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    /*@PostMapping
    public Product createProduct(@RequestBody Product product) {
        return ProductRepository.save(product);
    }*/


}