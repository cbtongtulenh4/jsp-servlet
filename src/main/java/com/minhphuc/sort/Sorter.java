package com.minhphuc.sort;

public class Sorter {
	private String sortName;
	private String sortBy;
	
	public Sorter(String sortBy, String sortName) {
		this.sortBy = sortBy;
		this.sortName = sortName;
	}
	
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
}
