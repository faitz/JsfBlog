package id.fai.jsf.blog.controller;

import id.fai.jsf.blog.dao.PostDao;
import id.fai.jsf.blog.model.Post;

import java.io.Serializable;
import java.util.List;

public class IndexController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PostDao postDao = PostDao.getInstance();
	
	private String firstIndex;
	
	private String postId;
	
	
	public List<Post> getPosts(){
		if(firstIndex == null){
			firstIndex = "0";
		}
		return postDao.listPosts(Integer.valueOf(getFirstIndex()), 5);
	}

	public List<Post> getAllPosts(){
		return postDao.listPosts();
	}

	public String getFirstIndex() {
		return firstIndex;
	}


	public void setFirstIndex(String firstIndex) {
		this.firstIndex = firstIndex;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String goToPost(){
		return "post.xhtml?faces-redirect=true&id="+postId;
	}
	
	public String goToPrev(){
		int prevIndex = Integer.valueOf(firstIndex)-5<0?0:Integer.valueOf(firstIndex)-5;
		return "index.xhtml?faces-redirect=true&firstIndex="+prevIndex;
	}
	
	public String goToNext(){
		int nextIndex = Integer.valueOf(firstIndex)+5>getPosts().size()?0:Integer.valueOf(firstIndex)+5;
		return "index.xhtml?faces-redirect=true&firstIndex="+nextIndex;
	}
	
	
}
