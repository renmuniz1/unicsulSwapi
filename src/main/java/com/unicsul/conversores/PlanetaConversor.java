package com.unicsul.conversores;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;

import com.unicsul.teste.entidades.Planeta;
import com.unicsul.teste.utils.Utilidades;

@FacesConverter("planetaConverter")
public class PlanetaConversor implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent ui, String value) {
		if(value != null){
			HttpSession sessao = Utilidades.getUtilidade().getSession();
			List<Planeta> planetas = (List<Planeta>) sessao.getAttribute("planetas");
			return planetas.get(Integer.parseInt(value));
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent ui, Object object) {
		if(object != null) {
            Planeta planeta = (Planeta) object;
            return planeta.getId().toString();
        }
        else {
            return null;
        }
	}

}
