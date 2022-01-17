package com.minhphuc.dao;

import java.util.List;

import com.minhphuc.mapper.RowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	
	void update(String sql, Object...parameters);
	Long insert(String sql, Object... parameters);
	int count(String sql, Object... parameters);
	
}
