package com.shweta.springwebservices.sportyshoes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.shweta.springwebservices.sportyshoes.entities.Order;
import com.shweta.springwebservices.sportyshoes.entities.OrderItem;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {

	List<OrderItem> findByOrderId(Long orderId);
	Optional<Order> findByIdAndOrderId(Long id, Long orderId);
	}

