package com.minhphuc.service;

import java.util.List;

import com.minhphuc.model.NewModel;
import com.minhphuc.paging.Pageble;

public interface iNewService {
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	NewModel update(NewModel newModel);
	void delete(Long[] ids);
	NewModel findOne(Long id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
