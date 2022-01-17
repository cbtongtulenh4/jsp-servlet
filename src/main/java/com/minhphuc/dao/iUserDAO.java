package com.minhphuc.dao;

import com.minhphuc.model.UserModel;

public interface iUserDAO extends GenericDAO<UserModel>{
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status); 
}
