package com.shweta.springwebservices.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shweta.springwebservices.sportyshoes.entities.Order;

import com.shweta.springwebservices.sportyshoes.entities.Product;
import com.shweta.springwebservices.sportyshoes.exceptions.OrderNotFound;
import com.shweta.springwebservices.sportyshoes.exceptions.UserNotFound;
import com.shweta.springwebservices.sportyshoes.repositories.OrderRepository;
import com.shweta.springwebservices.sportyshoes.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	// GET all orders
			@GetMapping("/orders")
			public List<Order> getAllOrder() {
				return this.orderRepository.findAll();
			}

			// Add Order
			@PostMapping("/users/{userId}/orders")
			public Order addOrder(@PathVariable(value = "userId") Long userId, 
				@RequestBody Order order) {
				return userRepository.findById(userId).map(user -> {
					order.setUser(user);
					return orderRepository.save(order);
				}).orElseThrow(()-> new UserNotFound("User not found"));
			}				
	
	
}
