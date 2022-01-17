package com.minhphuc.model;

public class CommentModel extends AbstractModel<CommentModel>{
	 private String content;
	 private long newId;
	 private long userId;
	 
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getNewId() {
		return newId;
	}
	public void setNewId(long newId) {
		this.newId = newId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	 
	 
}
