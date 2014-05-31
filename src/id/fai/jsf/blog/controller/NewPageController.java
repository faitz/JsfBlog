package id.fai.jsf.blog.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;

public class NewPageController implements Serializable {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMessage(){
		return "Hallo "+name;
		
	}

}
