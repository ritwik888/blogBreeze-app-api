package com.blogbreeze.app.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogbreeze.app.api.entities.User;
import com.blogbreeze.app.api.exceptions.ResourceNotFoundException;
import com.blogbreeze.app.api.payloads.UserDto;
import com.blogbreeze.app.api.repositories.UserRepo;
import com.blogbreeze.app.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		UserDto savedDto = this.userToDto(savedUser);
		return savedDto;
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		
		User foundUser = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId.toString()));
		foundUser.setName(user.getName());
		foundUser.setEmail(user.getEmail());
		foundUser.setAbout(user.getAbout());
		foundUser.setPassword(user.getPassword());
		foundUser = userRepo.save(foundUser);
		UserDto dto = userToDto(foundUser);
		return dto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User foundUser = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId.toString()));
		UserDto userDto = this.userToDto(foundUser);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> listOfUser = userRepo.findAll();
		List<UserDto> list = listOfUser.stream().map(user->userToDto(user)).collect(Collectors.toList()); 
		return list;
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);
	}
	
	private User dtoToUser(UserDto user) {
		User us = new User();
		us.setId(user.getId());
		us.setName(user.getName());
		us.setEmail(user.getEmail());
		us.setPassword(user.getPassword());
		us.setAbout(user.getAbout());
		return us;
	}
	
	private UserDto userToDto(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setAbout(user.getAbout());
		return dto;
	}

}
