package com.unicsul.repository;

import java.util.List;

import com.unicsul.teste.entidades.Nave;
import com.unicsul.teste.entidades.Pessoa;
import com.unicsul.teste.entidades.Planeta;

public interface UnicsulStarWarsRepository {
	
	List<Pessoa> getPersons();
	
	List<Nave> getNaves();
	
	List<Planeta> getPlanetas();
}
