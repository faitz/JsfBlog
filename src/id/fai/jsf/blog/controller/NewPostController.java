package id.fai.jsf.blog.controller;

import id.fai.jsf.blog.dao.PostDao;
import id.fai.jsf.blog.model.Post;
import id.fai.jsf.blog.model.Post.Category;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class NewPostController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PostDao postDao=PostDao.getInstance();
	
	private Category[] selectedCategories;
	
	
	private String postId;
	
	private boolean newz=false;
	
	private Post post;
	
	public Post getPost() {

		if(post !=null){
			return post;
		}
		
		if(postId == null){
			post = new Post();
			newz = true;
			return post;
		}
		
		post = postDao.getPost(Long.valueOf(postId));
		
		if(post ==null){
			post = new Post();
			newz = true;
		}
		return post;
	}
	
	public void setPost(Post post) {
		this.post = post;
	}
	
	public List<Category> getCategories(){
		return Arrays.asList(Category.values());
	}
	
	public String save(){
		post.setCategories(Arrays.asList(selectedCategories));
		if(isNew()){
			postDao.addPost(post, "faitz");
		}
		
		return "post.xhtml?faces-redirect=true&id="+post.getId();
	}
	
	public boolean isNew() {
		return newz;
	}
	
	public void setNew(boolean newz) {
		this.newz = newz;
	}
	
	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	public String getPostId() {
		return postId;
	}
	
	public Category[] getSelectedCategories() {
		return selectedCategories;
	}
	
	public void setSelectedCategories(Category[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
}
