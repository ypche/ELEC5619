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
@Table(name="OrderItems")
public class OrderItem implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrderID() {
		return order;
	}

	public void setOrderID(Order orderID) {
		this.order = orderID;
	}

	public Book getBookID() {
		return book;
	}

	public void setBookID(Book bookID) {
		this.book = bookID;
	}
}
