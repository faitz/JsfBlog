package id.fai.jsf.blog.controller;

import id.fai.jsf.blog.dao.PostDao;
import id.fai.jsf.blog.model.Post;
import id.fai.jsf.blog.model.Post.Category;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class NewPostController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Category> listCategory=Arrays.asList(Category.values());
	
	private Category[] selectedValues ;
	
	private PostDao postDao = PostDao.getInstance();
	
	private Post post = new Post();
	
	
	public void setSelectedValues(Category[] selectedValues) {
		this.selectedValues = selectedValues;
	}
	
	public Category[] getSelectedValues() {
		return selectedValues;
	}
	
	public void setPost(Post post) {
		this.post = post;
	}
	
	public List<Category> getListCategory() {
		return listCategory;
	}
	
	public Post getPost() {
		return post;
	}
	
	public String save(){
		post.setCategories(Arrays.asList(selectedValues));
		postDao.addPost(post, "faitz");
		return "index.xhtml?faces-redirect=true";
	}
	
	public String reset(){
		post = new Post();
		setSelectedValues(null);
		return null;
	}
	
}
