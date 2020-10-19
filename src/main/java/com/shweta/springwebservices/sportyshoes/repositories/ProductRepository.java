package com.shweta.springwebservices.sportyshoes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.shweta.springwebservices.sportyshoes.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
}
