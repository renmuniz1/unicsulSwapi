package com.unicsul.conversores;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;

import com.unicsul.teste.entidades.Pessoa;
import com.unicsul.teste.utils.Utilidades;


@FacesConverter("pessoaConverter")
public class PessoaConversor implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null){
			HttpSession sessao = Utilidades.getUtilidade().getSession();
			List<Pessoa> pessoas = (List<Pessoa>) sessao.getAttribute("personagens");
			return pessoas.get(Integer.parseInt(value));
		} else {
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if(object != null) {
            Pessoa pessoa = (Pessoa) object;
            return pessoa.getId().toString();
        }
        else {
            return null;
        }
	}

}
