package com.example.demo.service;

import com.example.demo.model.TblUser;

public interface UserService {
	void saveUser(TblUser user);
	TblUser findUser(TblUser user);

}
