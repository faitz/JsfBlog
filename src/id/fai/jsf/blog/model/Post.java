package id.fai.jsf.blog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class Post implements Serializable,Comparable<Post>{
	public enum Category{ISENG,IT,KODING,KOMPUTER,HOBI}
	private static final long serialVersionUID = 1L;
	private final static Random random = new Random();
	
	private Long id=random.nextLong()+4;
	private String title;
	private String post;
	private Date creationDate=new Date();
	private String username;
	private SortedSet<Comment> commentList=new TreeSet<Comment>();
	private List<Category> categories = new ArrayList<Post.Category>();
	
	public Post(String title,String post,String username) {
		this(title,post,username,new Date());
	}
	
	public Post(String title,String post,String username,Date date) {
		this.title = title;
		this.post =post;
		this.username = username;
		this.creationDate = date;
	}
	public Post() {
	}
	
	public SortedSet<Comment> getCommentList() {
		return commentList;
	}
	
	public void addComment(Comment comment){
		commentList.add(comment);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int compareTo(Post o) {
		return o.creationDate.compareTo(creationDate);
	}
	
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
}
