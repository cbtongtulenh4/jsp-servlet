package com.minhphuc.service;

import com.minhphuc.model.UserModel;

public interface iUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
