package com.minhphuc.paging;

public interface Pageble {
	public Integer getOffset();
	public Integer getMaxPageItem();
	public String getSortName();
	public String getSortBy();
}
