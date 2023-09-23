package com.interbank.interbank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.interbank.interbank.DTO.SuperHeroDTO;
import com.interbank.interbank.entity.Hability;
import com.interbank.interbank.entity.SuperHero;
import com.interbank.interbank.service.HabilityService;
import com.interbank.interbank.service.SuperheroService;
import com.interbank.interbank.*;

@RestController
@RequestMapping("/SuperHero")
public class SuperHeroController {

	@Autowired
	private SuperheroService superheroservice;
	
	@Autowired
	private HabilityService habilityservice;
	
	@GetMapping("")
	public  List<SuperHero> List(){
	    Map<String, Object> respObj = new HashMap<String, Object>();
	
		List<SuperHero> listsuperHero = superheroservice.getall();
	
		return listsuperHero;
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> createHero(@RequestBody SuperHero superHerodto){
		 superheroservice.createHero(superHerodto);
		 String Mensaje ="SuperHero Created";
		 return  ResponseEntity.status(HttpStatus.CREATED).body(Mensaje);
	}
	
	@PutMapping("/{Superheroid}")
	public ResponseEntity<?> updatehero(@PathVariable int Superheroid, @RequestBody SuperHeroDTO superherodto){
		superherodto.setGetSuperheroid(Superheroid);
		superheroservice.updateHero(superherodto);
		String Mensaje ="Superhero updated";
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(Mensaje);
	}
	
	
	@DeleteMapping("/{Superheroid}")
	public ResponseEntity<?> updatehero(@PathVariable int Superheroid){
		superheroservice.delete(Superheroid);
		String Mensaje ="Superhero delete";
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(Mensaje);
	}
	
	@GetMapping("/{name}")
	public List<SuperHero> getByName(@PathVariable("name") String name) throws Exception{
		return superheroservice.findByName(name);
	}
	
	@GetMapping("/{powerLevel}")
	public List<SuperHero> getPowerLevel(@PathVariable("powerLevel") String powerLevel) throws Exception{
		return superheroservice.findByPowerLevel(powerLevel);
	}
	
	@PutMapping("/{idsuperhero}/addhabilitys")
	public SuperHero putSuperheroHability(@PathVariable int idsuperhero, @RequestBody HashMap<String, ArrayList<Integer>> hability ) {
		
		SuperHero superhero =  superheroservice.putHabilityToSuperhero(idsuperhero, hability);
		return superhero;
	}
	
	@PutMapping("/{idsuperhero}/removehabilitys")
	public SuperHero removeSuperheroHability(@PathVariable int idsuperhero, @RequestBody HashMap<String, ArrayList<Integer>> hability ) {
		SuperHero superhero =  superheroservice.removeHabilityToSuperHero(idsuperhero, hability);
		return superhero;
	}
	
	
}
