package com.uncisul.testes.unitarios;

import org.junit.Test;

/*
 * @author Renato Muniz
 * 
 * Classe utilizada para os testes unitarios
 * 
 * A classe faz testes refrentes ao acesso da API https://swapi.co/
 * 
*/
import static org.junit.Assert.*;

public class UnidadeTest {
	
	@Test
	public void pessoasTest(){
		
		SuporteTeste suporte = new SuporteTeste();
		
		int resposta = suporte.statusRespostaPessoas();
		
		assertEquals(200, resposta);
		
		resposta = suporte.statusRespostaNaves();
		
		assertEquals(200, resposta);
		
		resposta = suporte.statusRespostaPlanetas();
		
		assertEquals(200, resposta);
		
	}

}
