package id.fai.jsf.blog;

import id.fai.jsf.blog.dao.PostDao;
import id.fai.jsf.blog.model.Post;

import java.io.Serializable;

public class NewPostController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PostDao postDao=PostDao.getInstance();
	
	private String postId;
	
	private boolean newz=false;
	
	private Post post;
	
	public Post getPost() {
		if(postId == null){
			post = new Post();
			newz = true;
			return post;
		}
		
		if(post !=null){
			return post;
		}
		
		post = postDao.getPost(Long.valueOf(postId));
		
		if(post ==null){
			post = new Post();
			newz = true;
		}
		return post;
	}
	
	public String save(){
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
}
