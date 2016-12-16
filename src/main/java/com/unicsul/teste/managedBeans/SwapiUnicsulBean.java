package com.unicsul.teste.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.unicsul.client.rest.repository.RestRepositoryUnicsul;
import com.unicsul.repository.UnicsulStarWarsRepository;

import com.unicsul.teste.entidades.Nave;
import com.unicsul.teste.entidades.Pessoa;
import com.unicsul.teste.entidades.Planeta;
import com.unicsul.teste.utils.Utilidades;

@ViewScoped
@ManagedBean
public class SwapiUnicsulBean {
	
	private String destinoAnterior = null;
	private List<Pessoa> personagens;
	private List<Nave> naves;
	private List<Planeta>planetas;
	private List<Pessoa>selecionadosUtilizados = new ArrayList<Pessoa>();
	private List<Pessoa>selecionados = new ArrayList<Pessoa>();
	private List<Nave>navesSelecionadas = new ArrayList<Nave>();
	private List<Planeta>planetasSelecionados = new ArrayList<Planeta>();
	private Nave nave;
	private Planeta planeta;
	private UnicsulStarWarsRepository repository = new RestRepositoryUnicsul();
	
	@PostConstruct
	public void iniciar(){
		
		HttpSession sessao = Utilidades.getUtilidade().getSession();
		
		personagens = (List<Pessoa>) sessao.getAttribute("personagens");
		
		if(personagens == null){
			personagens = repository.getPersons();
			naves = repository.getNaves();
			planetas = repository.getPlanetas();
			sessao.setAttribute("personagens", personagens);
			sessao.setAttribute("naves", naves);
			sessao.setAttribute("planetas", planetas);
			
		} else {
			naves = (List<Nave>) sessao.getAttribute("naves");
			planetas = (List<Planeta>) sessao.getAttribute("planetas");
		}
		
		
		personagens = repository.getPersons();
		naves = repository.getNaves();
		planetas = repository.getPlanetas();
	}
	
	public void acao(ActionEvent actionEvent){
		selecionadosUtilizados.clear();
		selecionadosUtilizados = new ArrayList<>(selecionados);
		selecionados.clear(); 
		navesSelecionadas.clear();
		planetasSelecionados.clear();
		
		if(selecionadosUtilizados.size() > 0 && nave != null && planeta != null){
		
		int quantidadePassageiros = Integer.parseInt(nave.getPassengers());
		
		if(quantidadePassageiros < selecionadosUtilizados.size()){
			selecionadosUtilizados.clear();
			navesSelecionadas.clear();
			planetasSelecionados.clear();
			nave = null;
			planeta = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"", "A nave não comporta todos esses passageiros"));
		} else if(destinoAnterior == null){
			navesSelecionadas.clear();
			planetasSelecionados.clear();
			navesSelecionadas.add(nave);
			planetasSelecionados.add(planeta);
			destinoAnterior = planeta.getName();
			nave = null;
			planeta = null;
		} else if(destinoAnterior.equals(planeta.getName())){
			selecionadosUtilizados.clear();
			navesSelecionadas.clear();
			planetasSelecionados.clear();
			nave = null;
			planeta = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"", "Planeta destino atual igual o destino anterior realizado"));
		} else {
			navesSelecionadas.clear();
			planetasSelecionados.clear();
			navesSelecionadas.add(nave);
			planetasSelecionados.add(planeta);
			destinoAnterior = planeta.getName();
			nave = null;
			planeta = null;
		}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"", "Preencha todos os campos"));
		}
	}

	public List<Pessoa> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<Pessoa> personagens) {
		this.personagens = personagens;
	}

	public List<Nave> getNaves() {
		return naves;
	}

	public void setNaves(List<Nave> naves) {
		this.naves = naves;
	}

	public List<Planeta> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<Planeta> planetas) {
		this.planetas = planetas;
	}

	public List<Pessoa> getSelecionados() {
		return selecionados;
	}

	public void setSelecionados(List<Pessoa> selecionados) {
		this.selecionados = selecionados;
	}

	public Nave getNave() {
		return nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public List<Nave> getNavesSelecionadas() {
		return navesSelecionadas;
	}

	public void setNavesSelecionadas(List<Nave> navesSelecionadas) {
		this.navesSelecionadas = navesSelecionadas;
	}

	public List<Planeta> getPlanetasSelecionados() {
		return planetasSelecionados;
	}

	public void setPlanetasSelecionados(List<Planeta> planetasSelecionados) {
		this.planetasSelecionados = planetasSelecionados;
	}

	public List<Pessoa> getSelecionadosUtilizados() {
		return selecionadosUtilizados;
	}

	public void setSelecionadosUtilizados(List<Pessoa> selecionadosUtilizados) {
		this.selecionadosUtilizados = selecionadosUtilizados;
	}
}
