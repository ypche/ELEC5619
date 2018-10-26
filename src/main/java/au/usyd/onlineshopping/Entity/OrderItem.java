package au.usyd.onlineshopping.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
<<<<<<< HEAD
=======

import org.hibernate.validator.constraints.NotEmpty;
>>>>>>> master

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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="book_id")
	private Book book;
	
<<<<<<< HEAD
=======
	@Column
	@NotEmpty
	private String status;
	
>>>>>>> master
	@Transient
	private String bookTitle;
	
	@Transient
	private double bookPrice;
<<<<<<< HEAD
=======
	
	@OneToOne(targetEntity=Delivery.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Delivery delivery;
>>>>>>> master

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

<<<<<<< HEAD
=======
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

>>>>>>> master
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
<<<<<<< HEAD
=======
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
>>>>>>> master
	}
}
