package com.shweta.springwebservices.sportyshoes.controller;

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
import com.shweta.springwebservices.sportyshoes.entities.OrderItem;
import com.shweta.springwebservices.sportyshoes.entities.Product;
import com.shweta.springwebservices.sportyshoes.exceptions.ProductNotFound;
import com.shweta.springwebservices.sportyshoes.exceptions.UserNotFound;
import com.shweta.springwebservices.sportyshoes.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	// inject dependency
		@Autowired
		private ProductRepository productRepository;
	
	// GET all product
		@GetMapping("/products")
		public List<Product> getAllProduct() {
			return this.productRepository.findAll();
		}
		
		// create a product
				@PostMapping("/products")
				public Product addProduct(@RequestBody Product product) {
					return this.productRepository.save(product);
				}
				
				// update a product
				@PutMapping("/products/{id}")
				public Product updateProduct(@RequestBody Product product, @PathVariable(value = "id") long productId) {
					// 1. find a record / product
					Product fetchedProduct = this.productRepository.findById(productId)
							.orElseThrow(() -> new ProductNotFound("Product Not found wit id " + productId));
					// 2 . set new values
					fetchedProduct.setName(product.getName());
					fetchedProduct.setColor(product.getColor());
					fetchedProduct.setPrice(product.getPrice());
					fetchedProduct.setSize(product.getSize());
					
					// 3.save a product
					return this.productRepository.save(fetchedProduct);
				}
				
				
			   // delete a product
				@DeleteMapping("/products/{id}")
				public void deleteProduct(@PathVariable(value = "id") long productId) {
					// 1. find a record / product
					Product fetchedProduct = this.productRepository.findById(productId)
							.orElseThrow(() -> new ProductNotFound("Product Not found wit id " + productId));
					this.productRepository.delete(fetchedProduct);
				}


		
		// GET product by id
		@GetMapping("/products/{id}")
		public Product getProductById(@PathVariable(value = "id") long productId) {
			return this.productRepository.findById(productId)
					.orElseThrow(() -> new ProductNotFound("Product Not found wit id " + productId));
		}

				
}
