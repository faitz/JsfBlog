package id.fai.jsf.blog.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

public class SessionBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String locale = "en_US";
	
	private final static Map<String,Object> supportedLanguages = new HashMap<String, Object>();
	
	static{
		supportedLanguages.put("English", Locale.ENGLISH);
		supportedLanguages.put("Indonesia", new Locale("in", "ID"));
	}

	public String getLocale() {
		for(Map.Entry<String, Object> entry:getSupportedlanguages().entrySet()){
			if(entry.getValue().toString().equals(locale)){
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
			}
		}
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public Map<String, Object> getSupportedlanguages() {
		return supportedLanguages;
	}
	
	public void onLanguageChange(ValueChangeEvent event){
		String newLocale = event.getNewValue().toString();
		for(Map.Entry<String, Object> entry:getSupportedlanguages().entrySet()){
			if(entry.getValue().toString().equals(newLocale)){
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
			}
		}
		
	}
	
	
}