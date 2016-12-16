package com.unicsul.client.rest.repository;

import java.util.ArrayList;


import java.util.List;

import javax.ws.rs.core.HttpHeaders;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.unicsul.repository.UnicsulStarWarsRepository;
import com.unicsul.teste.entidades.Nave;
import com.unicsul.teste.entidades.Pessoa;
import com.unicsul.teste.entidades.Planeta;

/**
 * @author Renato Muniz
 * 
 * 
 * Classe responsavel pela chamadas http GET para api https://swapi.co/
 */

public class RestRepositoryUnicsul implements UnicsulStarWarsRepository{

	/**
	 * @return List<Pessoa>
	 * 
	 * Cria uma listas com todos os personagens desponiveis pela API
	 */
	@Override
	public List<Pessoa> getPersons() {
		
		Client client = Client.create();
		
		client.addFilter(new ClientFilter() {
			
			@Override
			public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
				// TODO Auto-generated method stub
				request.getHeaders().add(HttpHeaders.USER_AGENT, "swapi-Java-SWAPI-JAVA");
				
				
				return getNext().handle(request);
			}
		});
		
		WebResource resource =  client.resource("http://swapi.co/api/people/?format=json&page=1");
		
		ClientResponse response = resource.get(ClientResponse.class);
		
		String saida = response.getEntity(String.class);
		
		JSONObject json = new JSONObject(saida);
		
		int totais = json.getInt("count");
		
		JSONArray array = json.getJSONArray("results");
		
		int registrosPorArquivo = array.length();
		
		int interacoes = 0;
		
		if(totais % registrosPorArquivo > 0){
			interacoes = (totais / registrosPorArquivo) + 1;
		}
		
		int aux = 0;
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		for(int j = 2; j <= interacoes + 1; j ++){
			
			
			for(int i = 0 ; i < array.length() ; i++){
				Pessoa p = new Pessoa();
				p.setId(i + aux);
				p.setName(array.getJSONObject(i).getString("name"));
				p.setGender(array.getJSONObject(i).getString("gender"));
				pessoas.add(p);
		    }
			
			if(j <interacoes){
				resource = client.resource("http://swapi.co/api/people/?format=json&page="+ j);
				response = resource.get(ClientResponse.class);
				saida = response.getEntity(String.class);
				json = new JSONObject(saida);
				
				aux += array.length();
				array = json.getJSONArray("results");
			} else {
				aux += array.length();
			}	
		}
		return pessoas;
	}
	
	/**
	 * @return List<Nave>
	 * 
	 * Cria uma listas com todas as naves desponiveis pela API
	 */
	@Override
	public List<Nave> getNaves() {
		
		Client client = Client.create();
		
		client.addFilter(new ClientFilter() {
			
			@Override
			public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
				// TODO Auto-generated method stub
				request.getHeaders().add(HttpHeaders.USER_AGENT, "swapi-Java-SWAPI-JAVA");
				
				
				return getNext().handle(request);
			}
		});
		
		WebResource resource =  client.resource("http://swapi.co/api/starships/?format=json&page=1");
		
		ClientResponse response = resource.get(ClientResponse.class);
		
		String saida = response.getEntity(String.class);
		
		JSONObject json = new JSONObject(saida);
		
		int totais = json.getInt("count");
		
		JSONArray array = json.getJSONArray("results");
		
		int registrosPorArquivo = array.length();
		
		int interacoes = 0;
		
		if(totais % registrosPorArquivo > 0){
			interacoes = (totais / registrosPorArquivo) + 1;
		}
		
		int aux = 0;
		
		List<Nave> naves = new ArrayList<Nave>();
		
		for(int j = 2; j <= interacoes + 1; j ++){
			
			
			for(int i = 0 ; i < array.length() ; i++){
				Nave n = new Nave();
				n.setId(i + aux);
				n.setName(array.getJSONObject(i).getString("name"));
				n.setModel(array.getJSONObject(i).getString("model"));
				n.setPassengers(array.getJSONObject(i).getString("passengers"));
				
				naves.add(n);
		    }
			
			if(j <interacoes){
				resource = client.resource("http://swapi.co/api/starships/?format=json&page="+ j);
				response = resource.get(ClientResponse.class);
				saida = response.getEntity(String.class);
				json = new JSONObject(saida);
				
				aux += array.length();
				array = json.getJSONArray("results");
			} else {
				aux += array.length();
			}	
		}
		return naves;
	}

	/**
	 * @return List<Planeta>
	 * 
	 * Cria uma listas com todos os planetas desponiveis pela API
	 */
	@Override
	public List<Planeta> getPlanetas() {
		
		Client client = Client.create();
		
		client.addFilter(new ClientFilter() {
			
			@Override
			public ClientResponse handle(ClientRequest request) throws ClientHandlerException {
				// TODO Auto-generated method stub
				request.getHeaders().add(HttpHeaders.USER_AGENT, "swapi-Java-SWAPI-JAVA");
				
				
				return getNext().handle(request);
			}
		});
		
		WebResource resource =  client.resource("http://swapi.co/api/planets/?page=1&format=json");
		
		ClientResponse response = resource.get(ClientResponse.class);
		
		String saida = response.getEntity(String.class);
		
		JSONObject json = new JSONObject(saida);
		
		int totais = json.getInt("count");
		
		JSONArray array = json.getJSONArray("results");
		
		int registrosPorArquivo = array.length();
		
		int interacoes = 0;
		
		if(totais % registrosPorArquivo > 0){
			interacoes = (totais / registrosPorArquivo) + 1;
		}
		
		int aux = 0;
		
		List<Planeta> planetas = new ArrayList<Planeta>();
		
		for(int j = 2; j <= interacoes + 1; j ++){
			
			
			for(int i = 0 ; i < array.length() ; i++){
				Planeta p = new Planeta();
				p.setId(i + aux);
				p.setName(array.getJSONObject(i).getString("name"));
				p.setDiameter(array.getJSONObject(i).getString("diameter"));
				p.setClimate(array.getJSONObject(i).getString("climate"));
				p.setTerrain(array.getJSONObject(i).getString("terrain"));
				p.setPopulation(array.getJSONObject(i).getString("population"));
				
				planetas.add(p);
		    }
			
			if(j <interacoes){
				resource = client.resource("http://swapi.co/api/planets/?page=" + j + "&format=json");
				response = resource.get(ClientResponse.class);
				saida = response.getEntity(String.class);
				json = new JSONObject(saida);
				
				aux += array.length();
				array = json.getJSONArray("results");
			} else {
				aux += array.length();
			}	
		}
		System.out.println("Funcionando");
		
		return planetas;
	}

}
