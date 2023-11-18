package com.blogbreeze.app.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogbreeze.app.api.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	

}
