package com.interbank.interbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interbank.interbank.DTO.HabilityDTO;
import com.interbank.interbank.DTO.SuperHeroDTO;
import com.interbank.interbank.entity.Hability;
import com.interbank.interbank.entity.SuperHero;
import com.interbank.interbank.service.HabilityService;
import com.interbank.interbank.service.SuperheroService;

@RestController
@RequestMapping("/hability")
public class HabilityController {

	@Autowired
	private HabilityService habilityservice;
	
	@GetMapping("")
	public List<Hability> Listar(){
		List<Hability> habilityList = habilityservice.getAll();
		return habilityList;
	}
	
	@PostMapping("")
	public ResponseEntity<?> createHability(@RequestBody Hability h){
		habilityservice.save(h);
		String Mensaje = "Hability creado";
		return ResponseEntity.status(HttpStatus.CREATED).body(Mensaje);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateHability(@PathVariable int id, @RequestBody HabilityDTO habilitydto){
		habilitydto.setId(id);
		habilityservice.update(habilitydto);
		String Mensaje = "Hability updated";
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(Mensaje);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteHability(@PathVariable int id){
		habilityservice.delete(id);
		String Mensaje = "Hability Delete";
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(Mensaje);
				
	}
	
	
}
