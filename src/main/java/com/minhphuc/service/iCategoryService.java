package com.minhphuc.service;

import java.util.List;

import com.minhphuc.model.CategoryModel;

public interface iCategoryService {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findOneByCode(String code);
}
