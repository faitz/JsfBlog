package id.fai.jsf.blog.model;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable,Comparable<Comment>{

	private static final long serialVersionUID = 1L;
	
	private Long postId;
	
	private String name;
	private String comment;
	
	private Date commentDate;
	
	public Date getCommentDate() {
		return commentDate;
	}
	
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	public Long getPostId() {
		return postId;
	}
	
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int compareTo(Comment o) {
		return commentDate.compareTo(o.commentDate);
	}
	
	

}
