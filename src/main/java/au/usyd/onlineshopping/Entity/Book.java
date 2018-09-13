package au.usyd.onlineshopping.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book implements Serializable{


	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	
	private String title;
	
	private String author;
	
    //商品图片地址
//    private String picUrl;
	
	private String genre;
	
	private double price;
	
	private String bookpath;
	
	public String getBookpath() {
		return bookpath;
	}

	public void setBookpath(String bookpath) {
		this.bookpath = bookpath;
	}

	private String description;
	
	public Book() {
		super();
	}
	
//	public Book(String title, String author, String genre, double price, String bookpath, String description ) {
//		this.title = title;
//		this.author = author;
//		this.genre = genre;
//		this.price = price;
//		this.bookpath = bookpath;
//		this.description = description;
//	}
	

	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", price=" + price
				+ ", filepath=" + bookpath + "]";
	}

//	public String getPicUrl() {
//		return picUrl;
//	}
//
//	public void setPicUrl(String picUrl) {
//		this.picUrl = picUrl;
//	}
}
