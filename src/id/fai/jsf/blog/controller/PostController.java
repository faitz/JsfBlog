package id.fai.jsf.blog.controller;

import id.fai.jsf.blog.dao.PostDao;
import id.fai.jsf.blog.model.Comment;
import id.fai.jsf.blog.model.Post;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class PostController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PostDao postDao = PostDao.getInstance();
	
	private Comment comment = new Comment();
	
	private String postId;
	
	private boolean authorized = true;
	
	
	private Post post;
	
	
	
	public List<Comment> getPostComments(){
		return new LinkedList<Comment>(post.getCommentList());
	}

	public boolean isAuthorized() {
		if(postId == null || postId.isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Post Not Found", "Post Not Found"));
			authorized = false;
			return authorized;
		}
		post = postDao.getPost(Long.valueOf(postId));
		
		if(post ==null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Post Not Found", "Post Not Found"));
			authorized = false;
		}
		return authorized;
	}
	
	public PostDao getPostDao() {
		return postDao;
	}
	
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	public String getPostId() {
		return postId;
	}
	public Post getPost() {
		
		return post;
	}
	
	public void addComment(ActionEvent event){
		post.addComment(comment);
		comment = new Comment();
	}
	
	public Comment getComment() {
		return comment;
	}
	
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
}
