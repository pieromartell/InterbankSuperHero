package com.interbank.interbank.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interbank.interbank.DTO.HabilityDTO;
import com.interbank.interbank.entity.Hability;
import com.interbank.interbank.repository.HabilityRepository;
@Service
public class HabilityServiceImpl implements HabilityService {

	@Autowired
	private HabilityRepository habilityrepository;
	
	@Override
	public List<Hability> getAll() {
		// TODO Auto-generated method stub
		return habilityrepository.findAll();
	}

	@Override
	public Hability save(Hability hability) {
		if(hability.getName() == null) {
			throw new RuntimeException("Name is required");
		}
		if(hability.getPowerlevel() == null) {
			throw new RuntimeException("Power Level is required");
		}
		hability.setState(true);
		
		return habilityrepository.save(hability);
	}

	@Override
	public Hability update(HabilityDTO habilitydto) {
		System.out.println("HabilityDTO "+habilitydto.getId()+habilitydto.getName()+habilitydto.getPowerlevel());
		
		if(habilitydto.getId() == 0) {
			throw new RuntimeException("ID is required");
		}
		if(habilitydto.getName() == null) {
			throw new RuntimeException("Name is required");
		}
		if(habilitydto.getPowerlevel() == null) {
			throw new RuntimeException("Power Level is required");
		}
		
		Hability hability = habilityrepository.findById(habilitydto.getId()).orElseThrow(()->
			new RuntimeException("Hability Not Found")
				);
		
		hability.setName(habilitydto.getName());
		hability.setPowerlevel(habilitydto.getPowerlevel());
		hability.setState(hability.isState());
		return habilityrepository.save(hability);
	}
	

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Hability obj = habilityrepository.getById(id);
		obj.setState(false);
		habilityrepository.save(obj);
		
	}


}
