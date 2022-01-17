package com.minhphuc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.minhphuc.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet rs) {
		try {
			NewModel news = new NewModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setShortDescription(rs.getString("shortDescription"));
			news.setCategoryId(rs.getLong("categoryid"));
			news.setContent(rs.getString("content"));
			news.setCreatedBy(rs.getString("createdby"));
			news.setCreatedDate(rs.getTimestamp("createddate"));
			if(rs.getString("modifiedby") != null) {
				news.setModifiedBy(rs.getString("modifiedby"));
			}
			if(rs.getTimestamp("modifiedate") != null) {
				news.setModifiedDate(rs.getTimestamp("modifiedate"));
			}
			return news;
		}catch(SQLException e) {
			return null;
		}
	}
}
