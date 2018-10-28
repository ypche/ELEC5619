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
@Table(name="Post")
public class Post implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	private String content;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Topic_id")
	private Topic topic;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Topic getTopic() {
		return topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}