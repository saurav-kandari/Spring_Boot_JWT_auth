package com.securitydemo.jwtAuth.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securitydemo.jwtAuth.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	User findByEmail(String email);
}