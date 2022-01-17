package com.minhphuc.paging;

import com.minhphuc.sort.Sorter;

public class PageRequest implements Pageble{
	private Integer page;
	private Integer MaxPageItem;
	private Sorter varieties;
	
	public PageRequest(Integer page, Integer MaxPageItem, Sorter sorter){
		this.page = page;
		this.MaxPageItem = MaxPageItem;
		varieties = sorter;
	}

	@Override
	public Integer getOffset() {
		return (page - 1) * MaxPageItem;
	}

	@Override
	public Integer getMaxPageItem() {
		return MaxPageItem;
	}

	@Override
	public String getSortName() {
		return varieties.getSortName();
	}

	@Override
	public String getSortBy() {
		return varieties.getSortBy();
	}
	
}
