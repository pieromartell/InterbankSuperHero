package com.interbank.interbank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.interbank.interbank.DTO.SuperHeroDTO;
import com.interbank.interbank.entity.SuperHero;

public interface SuperheroService {

	List<SuperHero> getall();
	
	Optional<SuperHero> getById(int id);
	
	List<SuperHero> findByName(String name) throws Exception; 
	
	List<SuperHero> findByPowerLevel(String powerLevel) throws Exception;
	
	SuperHero createHero(SuperHero s);
	
	SuperHero updateHero(SuperHeroDTO st);
	
	void delete(int id);
	
	SuperHero putHabilityToSuperhero(Integer superheroid, HashMap<String, ArrayList<Integer>> hability);

	SuperHero removeHabilityToSuperHero(Integer superheroid, HashMap<String, ArrayList<Integer>> hability);
}
