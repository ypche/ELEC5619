package au.usyd.onlineshopping.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Wishlist implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User userId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="book_id")
	private Book bookId;
	
	@Column(name = "wish_date")
	private Date wishDate;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public Book getBookId() {
		return bookId;
	}

	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	
	public Date getWishDate() {
		return wishDate;
	}

	public void setWishDate(Date wishDate) {
		this.wishDate = wishDate;
	}
}
