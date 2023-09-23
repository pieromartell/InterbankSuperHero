package com.interbank.interbank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.interbank.interbank.DTO.SuperHeroDTO;
import com.interbank.interbank.entity.Hability;
import com.interbank.interbank.entity.SuperHero;
import com.interbank.interbank.repository.HabilityRepository;
import com.interbank.interbank.repository.SuperHeroRepository;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.transaction.Transactional;
@Service
public class SuperHeroServiceImpl implements SuperheroService {

	@Autowired
	private SuperHeroRepository superherorepository;
	
	@Autowired HabilityRepository habilityrepository;
	
	public void ValidarSuperHero(int superheroid) {
		if(!superherorepository.existsById(superheroid)) {
			throw new RuntimeException("Error" + superheroid + "No Found");
		}
	}
	
	
	@Override
	public List<SuperHero> getall() {
		return superherorepository.findAll();
	}
	
	@Override
	public Optional<SuperHero> getById(int id) {
		return superherorepository.findById(id);
	}
	
	
	@Override
	public List<SuperHero> findByName(String name) throws Exception{
		List<SuperHero> listSuperHero = superherorepository.findByName(name);
		if (listSuperHero.isEmpty()) {
			throw new Exception("Hero is not found");
		}
		return listSuperHero;
	}

	@Override
	public List<SuperHero> findByPowerLevel(String powerLevel) throws Exception {
		List<SuperHero> listSuperHero = superherorepository.findByPowerLevel(powerLevel);
		if (listSuperHero.isEmpty()) {
			throw new Exception("There is no hero with that level of power.");
		}
		return listSuperHero;
	}


	@Override
	public SuperHero createHero(SuperHero s) {
		
		if(s.getName().equals("")||s.getName() == null ) {
			throw new RuntimeException("Name is required");
		}
		if(s.getPowerLevel().equals("") || s.getPowerLevel().equals(null)) {
			throw new RuntimeException("Power level required");
		}
		if(s.getDescription().equals("") || s.getDescription().equals(null)) {
			throw new RuntimeException("Description required");
		}
		
		s.setState(true);
		return superherorepository.save(s);
	}
	
	
	@Override
	public SuperHero updateHero(SuperHeroDTO st) {
		System.out.println("Superhero dto"+st.getName()+ st.getDescription()+ st.getPowerLevel());
		ValidarSuperHero(st.getGetSuperheroid());
		if(st.getName().equals("")||st.getName() == null ) {
			throw new RuntimeException("Name is required");
		}
		if(st.getPowerLevel().equals("") || st.getPowerLevel() == null) {
			throw new RuntimeException("Power level required");
		}
		if(st.getDescription().equals("") ||st.getDescription() == null) {
			throw new RuntimeException("Description required");
		}
		System.out.println("Superhero dto"+ st);
		SuperHero superhero = superherorepository.findById(st.getGetSuperheroid()).orElseThrow(()->
				new RuntimeException("Superhero not found")
			);
		superhero.setName(st.getName());
		superhero.setDescription(st.getDescription());
		superhero.setPowerLevel(st.getPowerLevel());
		superhero.setState(superhero.getState());
		return superherorepository.save(superhero);
	}
	
	@Override
	public SuperHero putHabilityToSuperhero (Integer superheroid, HashMap<String, ArrayList<Integer>> hability) {
		
		this.ValidarSuperHero(superheroid);
		
		ArrayList<Integer> HabilityIds = hability.get("hability");	
		
		System.out.println("Habilidades: "+HabilityIds);
		
		SuperHero superhero = superherorepository.findById(superheroid).orElseThrow( ()->
			new RuntimeException("Superhero not found")
		);
		
		System.out.println("SuperHeroe 1 "+superhero+HabilityIds);
		for(int habilityid : HabilityIds) {
			
			if(!habilityrepository.existsById(habilityid)) {				
				throw new RuntimeException("Hability not found" +habilityid );
			}
			
			System.out.println("Superhero Agregando Habilidad "+superhero+habilityid);
			Hability habilityIF = habilityrepository.findById(habilityid).orElseThrow(()->
				new RuntimeException("Hability not found")
					);
			superhero.addHability(habilityIF);

			System.out.println("Superhero"+superhero+habilityid);
		}
		return superherorepository.save(superhero);
	}
	
	
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SuperHero obj = superherorepository.getById(id);
		obj.setState(false);
		superherorepository.save(obj);
	}


	@Override
	public SuperHero removeHabilityToSuperHero(Integer superheroid, HashMap<String, ArrayList<Integer>> hability) {
		this.ValidarSuperHero(superheroid);
		
		ArrayList<Integer> HabilityIds = hability.get("hability");	
		
		System.out.println("Habilidades: "+HabilityIds);
		
		SuperHero superhero = superherorepository.findById(superheroid).orElseThrow( ()->
			new RuntimeException("Superhero not found")
		);
		
		System.out.println("SuperHeroe 1 "+superhero+HabilityIds);
		for(int habilityid : HabilityIds) {
			
			if(!habilityrepository.existsById(habilityid)) {				
				throw new RuntimeException("Hability not found" +habilityid );
			}
			
			System.out.println("Superhero Agregando Habilidad "+superhero+habilityid);
			Hability habilityIF = habilityrepository.findById(habilityid).orElseThrow(()->
				new RuntimeException("Hability not found")
					);
			superhero.deleteHability(habilityIF);

			System.out.println("Superhero"+superhero+habilityid);
		}
		return superherorepository.save(superhero);
	}


	
	




}
