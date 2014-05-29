package id.fai.jsf.blog.dao;

import id.fai.jsf.blog.model.User;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final UserDao INSTANCE = new UserDao();
	
	private Set<User> listUser =new HashSet<User>(Arrays.asList(new User("faitz","password","Faisal Abdillah")));
	
	public static UserDao getInstance(){
		return INSTANCE;
	}
	
	public Set<User> getListUser() {
		return listUser;
	}
	
	public User get(String username){
		for(User user:getListUser()){
			if(user.getUsername().equals(user)){
				return user;
			}
		}
		
		return null;
	}
	
	public User verifyUser(String username,String password) throws InvalidUserException{
		User user = get(username);
		if(user  != null && user.getPassword().equals(password)){
			return user;
		}
		throw new InvalidUserException();
		
	}
	
	public class InvalidUserException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public InvalidUserException() {
			super("Invalid Combination Username and Password!");
		}
	}

}
