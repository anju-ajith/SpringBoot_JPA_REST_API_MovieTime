package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.TblUser;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceIml implements UserService {

	private final UserRepository userRepo;

	public UserServiceIml(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public void saveUser(TblUser user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public TblUser findUser(TblUser user) {
		// TODO Auto-generated method stub
		return userRepo.findUser(user.getEmail(), user.getPassword());
	}
	

}
