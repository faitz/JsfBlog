package id.fai.jsf.blog.dao;

import id.fai.jsf.blog.model.Post;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class PostDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final PostDao INSTANCE = new PostDao();
	
	private SortedSet<Post> listPost = new TreeSet<Post>(Arrays.asList(
			new Post("Tutorial JSF 1", "Ini Merupakan Tutorial JSF 1", "faitz",toDate("10-04-1989")),
			new Post("Tutorial JSF 2", "Ini Merupakan Tutorial JSF 2", "faitz",toDate("11-04-1989")),
			new Post("Tutorial JSF 3", "Ini Merupakan Tutorial JSF 3", "faitz",toDate("12-04-1989")),
			new Post("Tutorial JSF 4", "Ini Merupakan Tutorial JSF 4", "faitz",toDate("13-04-1989")),
			new Post("Tutorial JSF 5", "Ini Merupakan Tutorial JSF 5", "faitz",toDate("14-04-1989")),
			new Post("Tutorial JSF 6", "Ini Merupakan Tutorial JSF 6", "faitz",toDate("15-04-1989"))
			));
	
	public static PostDao getInstance(){
		return INSTANCE;
	}
	
	public List<Post> listPosts(int index,int maxresult){
		if(maxresult<=0){
			maxresult=5;
		}
		int endIndex = listPost.size() > (index+maxresult)?(index+maxresult):listPost.size();
		return new LinkedList<Post>(listPost).subList(index, endIndex);
	}
	
	public void addPost(Post post,String username){
		post.setUsername(username);
		listPost.add(post);
	}
	
	public Post getPost(Long id){
		for(Post post:listPost){
			if(post.getId() == id){
				return post;
			}
		}
		return null;
	}
	
	private static Date toDate(String date){
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
		try {
			return sf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
