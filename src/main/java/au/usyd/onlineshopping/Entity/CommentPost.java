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
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CommentPosts")
public class CommentPost implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	@Column
	@NotEmpty
	private String content;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id")
	private Post post;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Post getPost() {
		return post;
	}
	
	public void setPost(Post post) {
		this.post = post;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}