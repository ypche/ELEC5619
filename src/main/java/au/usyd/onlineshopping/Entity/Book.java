package au.usyd.onlineshopping.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

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
	
	private String image;
	
	@Transient
	private String status;

	@OneToMany(targetEntity=OrderItem.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<OrderItem> orderItems;
	
	@OneToMany(targetEntity=Delivery.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Delivery> deliveries;
	
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
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Set<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", price=" + price
				+ ", bookpath=" + bookpath + ", image=" + image + ", description=" + description + "]";
	}


}
