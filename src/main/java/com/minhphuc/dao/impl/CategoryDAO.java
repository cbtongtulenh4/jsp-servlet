package com.minhphuc.dao.impl;

import com.minhphuc.dao.iCategoryDAO;
import com.minhphuc.mapper.CategoryMapper;
import com.minhphuc.model.CategoryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAO extends AbstractDAO<CategoryModel> implements iCategoryDAO {
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

    @Override
    public CategoryModel findOne(Long id) {
        String sql = "SELECT * FROM category WHERE id = " + id;
		List<CategoryModel> list = query(sql, new CategoryMapper());
		return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public CategoryModel findOneByCode(String code) {
        String sql = "SELECT * FROM category WHERE code = ?";
        List<CategoryModel> list = query(sql, new CategoryMapper(), code);
        return list.isEmpty() ? null : list.get(0);
    }
}
