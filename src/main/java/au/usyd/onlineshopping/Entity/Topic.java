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

@Entity
public class Topic implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	private String title;
	
	private String publisher;
	
	private String topicPath;
	
	@OneToMany(targetEntity = Post.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Post> posts;
	
	
	public  void setTopicPath(String topicPath) {
		this.topicPath= topicPath;
	}
	
	public String getTopicPath() {
		return topicPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public List<Post> getPosts(){
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "Topic [id=" + id + ": title=" + title + ", publisher=" + publisher + "]";
	}
}