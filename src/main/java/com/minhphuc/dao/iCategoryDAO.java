package com.minhphuc.dao;

import java.util.List;

import com.minhphuc.model.CategoryModel;

public interface iCategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findOneByCode(String Code);
}
