package com.rdcecomm.rdcecommerce.repository;

import com.rdcecomm.rdcecommerce.entity.Item;
import com.rdcecomm.rdcecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
