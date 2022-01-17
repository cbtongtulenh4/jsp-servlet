package com.minhphuc.service.impl;

import com.minhphuc.dao.iCategoryDAO;
import com.minhphuc.model.CategoryModel;
import com.minhphuc.service.iCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements iCategoryService {
	@Autowired
	private iCategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

    @Override
    public CategoryModel findOne(Long id) {
		return categoryDAO.findOne(id);
    }

	@Override
	public CategoryModel findOneByCode(String code) {
		return categoryDAO.findOneByCode(code);
	}

}
