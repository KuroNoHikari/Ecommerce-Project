package com.rdcecomm.rdcecommerce.repository;

import com.rdcecomm.rdcecommerce.entity.Cart;
import com.rdcecomm.rdcecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
}
