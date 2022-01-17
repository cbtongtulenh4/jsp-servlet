package com.minhphuc.dao;

import java.util.List;

import com.minhphuc.model.NewModel;
import com.minhphuc.paging.Pageble;

public interface iNewDAO extends GenericDAO<NewModel>{
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(Long id);
	NewModel findOne(Long id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
