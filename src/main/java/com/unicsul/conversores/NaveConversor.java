package com.unicsul.conversores;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;

import com.unicsul.teste.entidades.Nave;
import com.unicsul.teste.utils.Utilidades;

@FacesConverter("naveConverter")
public class NaveConversor implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent ui, String value) {
		if(value != null){
			HttpSession sessao = Utilidades.getUtilidade().getSession();
			List<Nave> naves = (List<Nave>) sessao.getAttribute("naves");
			return naves.get(Integer.parseInt(value));
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent ui, Object object) {
		if(object != null) {
            Nave nave = (Nave) object;
            return nave.getId().toString();
        }
        else {
            return null;
        }
	}

}
