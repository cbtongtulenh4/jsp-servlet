package com.minhphuc.service.impl;

import com.minhphuc.dao.iUserDAO;
import com.minhphuc.model.UserModel;
import com.minhphuc.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements iUserService {

	@Autowired
	private iUserDAO user;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return user.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
