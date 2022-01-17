package com.minhphuc.dao.impl;

import java.util.List;

import com.minhphuc.dao.iUserDAO;
import com.minhphuc.mapper.UserMapper;
import com.minhphuc.model.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO
extends AbstractDAO<UserModel>
implements iUserDAO
{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user ");
		sql.append("INNER JOIN role ON user.roleid = role.id ");
		sql.append("WHERE user.username = ? AND user.password = ? AND user.status = ?");
		List<UserModel> list = query(sql.toString(), new UserMapper(), userName, password, status);
		return list.isEmpty() ? null : list.get(0);
	}
	
}
