package com.shweta.springwebservices.sportyshoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shweta.springwebservices.sportyshoes.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
