package au.usyd.onlineshopping.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Deliveries")
public class Delivery implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="purchase_code")
	private String purchaseCode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_id")
	private OrderItem item;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public OrderItem getItem() {
		return item;
	}

	public void setItem(OrderItem item) {
		this.item = item;
	}
}
