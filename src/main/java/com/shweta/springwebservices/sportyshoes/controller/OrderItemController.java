package com.shweta.springwebservices.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shweta.springwebservices.sportyshoes.entities.Order;
import com.shweta.springwebservices.sportyshoes.entities.OrderItem;
import com.shweta.springwebservices.sportyshoes.entities.Product;
import com.shweta.springwebservices.sportyshoes.exceptions.OrderNotFound;
import com.shweta.springwebservices.sportyshoes.exceptions.ProductNotFound;
import com.shweta.springwebservices.sportyshoes.repositories.OrderItemsRepository;
import com.shweta.springwebservices.sportyshoes.repositories.OrderRepository;
import com.shweta.springwebservices.sportyshoes.repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1")
public class OrderItemController {
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	            // GET all orders
				@GetMapping("/order-items")
				public List<OrderItem> getAllOrder() {
					return this.orderItemsRepository.findAll(); 
				}
				
				@PostMapping("/orders/{orderId}/order-items")
				public OrderItem addItem(@PathVariable(value = "orderId") Long orderId, 
						
					@RequestBody OrderItem orderItem) {
					return orderRepository.findById(orderId).map(order -> {
						orderItem.setOrder(order);
						return orderItemsRepository.save(orderItem);
					}).orElseThrow(()-> new OrderNotFound("order not found"));
					 
				}

				
}