package com.shweta.springwebservices.sportyshoes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.shweta.springwebservices.sportyshoes.entities.Order;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long>{

	Optional<Order> findByIdAndUserId(Long id, Long userId);
}
