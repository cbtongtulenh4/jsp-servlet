package com.minhphuc.service.impl;

import com.minhphuc.dao.iCategoryDAO;
import com.minhphuc.dao.iNewDAO;
import com.minhphuc.model.CategoryModel;
import com.minhphuc.model.NewModel;
import com.minhphuc.paging.Pageble;
import com.minhphuc.service.iNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NewService implements iNewService{

	@Autowired
	private iNewDAO news;
	@Autowired
	private iCategoryDAO categoryDAO;

	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return news.findByCategoryId(1L);
	}

	@Override
	public Long save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(categoryModel.getId());
		return news.save(newModel);
	}

	@Override
	public NewModel update(NewModel newModel) {
		NewModel oldNew = news.findOne(newModel.getId());
		newModel.setCreatedDate(oldNew.getCreatedDate());
		newModel.setCreatedBy(oldNew.getCreatedBy());
		newModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(categoryModel.getId());
		news.update(newModel);
		return news.findOne(newModel.getId());
	}

	@Override
	public void delete(Long[] ids) {
		for(Long i : ids) {
			// delete comment first 
			news.delete(i);
		}
	}

	@Override
	public NewModel findOne(Long id) {
		NewModel newModel = news.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return news.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return news.getTotalItem();
	}


}
