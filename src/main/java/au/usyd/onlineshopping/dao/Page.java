package au.usyd.onlineshopping.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable {
	
	private static int DEFAULT_PAGE_SIZE = 20;
	
	private int pageSize = DEFAULT_PAGE_SIZE;
	
	private long start;// the start of the page
	
	private List data;
	
	private long totalCount;//total count of record
	
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
	}

	public Page(long start, long totalSize, int pageSize, List data) {
		// TODO Auto-generated constructor stub
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalSize;
		this.data = data;
	}
	
	public long getTotalCount() { // get the whole number of record
		return this.totalCount;
	}
	
	public long getTotalPageCount() {//get the whole number of page
		if (totalCount % pageSize == 0)
			return totalCount / pageSize;
		else
			return totalCount / pageSize +1;
	}
	
	public int getPageSize() {//get the volume of each page 
		return pageSize;
	}
	
	public List getResult() {// get the record of page
		return data;
	}
	
	public long getCurrentPageNo() {//get the page number of current page
		return start / pageSize + 1;
	}
	
	public boolean isHasNextPage() {//judge whether exist the next page
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}
	
	public boolean isHasPreviousPage() {//judge whether exist the previous page
		return this.getCurrentPageNo() > 1;
	}
	
	protected static int getStartOfPage( int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}
	
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}
}