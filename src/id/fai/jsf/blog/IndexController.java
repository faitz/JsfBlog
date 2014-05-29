package id.fai.jsf.blog;

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
	
	private String maxResult;
	
	private String postId;
	
	
	public List<Post> getPosts(){
		if(firstIndex == null){
			firstIndex = "0";
		}
		if (maxResult == null) {
			maxResult = "5";
		}
		return postDao.listPosts(Integer.valueOf(getFirstIndex()), Integer.valueOf(getMaxResult()));
	}


	public String getFirstIndex() {
		return firstIndex;
	}


	public void setFirstIndex(String firstIndex) {
		this.firstIndex = firstIndex;
	}


	public String getMaxResult() {
		return maxResult;
	}
	


	public void setMaxResult(String maxResult) {
		this.maxResult = maxResult;
	}
	
	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String goToPost(){
		return "post.xhtml?faces-redirect=true&id="+postId;
	}
	
	
}
