package com.minhphuc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.minhphuc.model.RoleModel;
import com.minhphuc.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		UserModel user = new UserModel();
		try {
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setStatus(rs.getInt("status"));
			user.setRoleId(rs.getInt("roleid"));
			if(rs.getString("fullname") != null) {
				user.setFullName(rs.getString("fullname"));
			}
			if(rs.getString("createdby") != null) {
				user.setCreatedBy(rs.getString("createdby"));
			}
			if(rs.getTimestamp("createddate") != null) {
				user.setCreatedDate(rs.getTimestamp("createddate"));
			}
			if(rs.getString("modifiedby") != null) {
				user.setModifiedBy(rs.getString("modifiedby"));
			}
			if(rs.getTimestamp("modifiedate") != null) {
				user.setModifiedDate(rs.getTimestamp("modifiedate"));
			}
			try {
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				user.setRole(role);
			}catch(Exception e) {
				System.out.print(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

}
