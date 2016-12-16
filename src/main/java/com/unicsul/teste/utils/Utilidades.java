package com.unicsul.teste.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utilidades {
	
	private HttpSession session;
	private static Utilidades utilidade = new Utilidades();
	
	private Utilidades(){
		
	};
	
	public static Utilidades getUtilidade(){
		return utilidade;
	}
	
	public HttpSession getSession(){
		
		try{
		if(session == null){
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			session = request.getSession(true);
			return session;
		} else {
			return session;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
