package au.usyd.onlineshopping.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PageBean<T> {
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	

	private int pageNum;  //当前页数
	private int pageSize;  //每页显示的数目
	private int totalRecord; //查数据库记录到的总的条数
	
	private int totalPage;
    //开始索引，也就是我们在数据库中要从第几行数据开始拿，有了startIndex和pageSize，
    //就知道了limit语句的两个数据，就能获得每页需要显示的数据了
	
	private int startIndex;
	
	//每页要显示的条数放在list里面
	private int start;
	private int end;
	//将每页要显示的数据放在list集合中
	@OneToMany(targetEntity=Book.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<T> list;

	
	//通过pageNum，pageSize，totalRecord计算得来tatalPage和startIndex
    //构造方法中将pageNum，pageSize，totalRecord获得
	public PageBean(int pageNum, int pageSize, int totalRecord) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		if(totalRecord % pageSize == 0) {
			this.totalPage = totalRecord / pageSize;
		}else {
			this.totalPage = totalRecord / pageSize + 1;
		}
		
		this.startIndex = (pageNum - 1) * pageSize;
		this.start = 1;
		this.end = 3;
		
		if(totalPage <= 3) {
			this.end = this.totalPage;
		}else {
			this.start = pageNum -1;
			this.end = pageNum + 1;
			if(start < 0) {
				this.start = 1;
				this.end = 3;
			}
			if(end > this.totalPage) {
				this.end = totalPage;
				this.start = end - 3;
			}
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	

}
