package au.usyd.onlineshopping.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Users")
public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@NotEmpty
	@Column(name="name")
	private String name;
	
	@NotEmpty
	@Column(name="password")
	private String password;
	
	@Email
	@Column(name="email")
	private String email;
	
	@NotEmpty
	@Column(name="role")
	private String role;
	
	@OneToMany(targetEntity=Order.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Order> orders;
	
	@OneToMany(targetEntity=Delivery.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Delivery> deliveries;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
}
