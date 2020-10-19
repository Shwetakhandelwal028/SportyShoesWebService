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

import com.shweta.springwebservices.sportyshoes.entities.Product;
import com.shweta.springwebservices.sportyshoes.entities.Users;
import com.shweta.springwebservices.sportyshoes.exceptions.ProductNotFound;
import com.shweta.springwebservices.sportyshoes.exceptions.UserNotFound;
import com.shweta.springwebservices.sportyshoes.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//Get All Usera
	@GetMapping("/users")
	public List<Users> getAllProduct() {
		return this.userRepository.findAll();
	}
	
	// GET User by id
			@GetMapping("/users/{id}")
			public Users getUserById(@PathVariable(value = "id") long userId) {
				return this.userRepository.findById(userId)
						.orElseThrow(() -> new UserNotFound("User Not found wit id " + userId));
			}
			
			// create a user
			@PostMapping("/users")
			public Users addUser(@RequestBody Users user) {
				return this.userRepository.save(user);
			}
			
			// update a user
			@PutMapping("/users/{id}")
			public Users updateUser(@RequestBody Users user, @PathVariable(value = "id") long userId) {
				// 1. find a user
				Users fetchedUser = this.userRepository.findById(userId)
						.orElseThrow(() -> new UserNotFound("User Not found with id " + userId));
				// 2 . set new values
				fetchedUser.setName(user.getName());
				fetchedUser.setCity(user.getCity());
				

				// 3.save a user
				return this.userRepository.save(fetchedUser);
			}
			
			// delete a product
			@DeleteMapping("/users/{id}")
			public void deleteProduct(@PathVariable(value = "id") long userId) {
				// 1. find a record / product
				Users fetchedUser = this.userRepository.findById(userId)
						.orElseThrow(() -> new UserNotFound("User Not found with id " + userId));
				this.userRepository.delete(fetchedUser);
			}


}
