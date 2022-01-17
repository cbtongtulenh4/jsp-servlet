package com.minhphuc.dao.impl;

import com.minhphuc.dao.iNewDAO;
import com.minhphuc.mapper.NewMapper;
import com.minhphuc.model.NewModel;
import com.minhphuc.paging.Pageble;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.StringUtils;


import java.util.List;

@Repository
public class NewDAO extends AbstractDAO<NewModel> implements iNewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(),categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), 
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCategoryId(),
				newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifiedate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), 
				updateNew.getCreatedBy(), updateNew.getModifiedDate(), 
				updateNew.getModifiedBy(), updateNew.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> list = query(sql, new NewMapper(),id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news ");
		if(StringUtils.isNotBlank(pageble.getSortBy()) && StringUtils.isNotBlank(pageble.getSortName())) {
			sql.append("ORDER BY "+pageble.getSortBy()+" "+pageble.getSortName()+" ");
		}
		if(pageble.getOffset() != null && pageble.getMaxPageItem() != null) {
			sql.append("LIMIT "+pageble.getOffset()+", "+pageble.getMaxPageItem()+" ");
		}
		return query(sql.toString(), new NewMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM news";
		return count(sql);
	}

}
