package au.usyd.onlineshopping.Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="Posts")
public class Post implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	private String content;
	
	//private String title;
	
	@Column(name="time")
	private Date postTime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	private Integer userId;
	
	@Transient
	private String userName;
	
	@OneToMany(targetEntity=CommentPost.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<CommentPost> comments;
	
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
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Date getPostTime() {
		return postTime;
	}
	
	public void setPostTime(Date postTime)	{
		this.postTime = postTime;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<CommentPost> getComments(){
		return comments;
	}
	
	public void setComments(List<CommentPost> comments) {
		this.comments = comments;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
}