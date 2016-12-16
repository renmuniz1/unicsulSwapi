package com.uncisul.testes.unitarios;

import javax.ws.rs.core.HttpHeaders;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.ClientFilter;

/*
 * @author Renato Muniz
 * Classe para suporte aos testes
 * Essa classe realiza as chamadas http GET para a API swapi.co utilizando a blblioteca Jersey
 */

public class SuporteTeste {
	
	public int statusRespostaPessoas(){
		
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
		
		return response.getStatus();
		
	}
	
	public int statusRespostaNaves(){
		
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
		
		return response.getStatus();
		
	}
	
	public int statusRespostaPlanetas(){
		
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
		
		return response.getStatus();
		
	}
}
