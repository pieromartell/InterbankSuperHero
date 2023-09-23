package com.interbank.interbank.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.interbank.interbank.DTO.HabilityDTO;
import com.interbank.interbank.entity.Hability;

public interface HabilityService {

	List<Hability> getAll();

	Hability save(Hability h);
	
	Hability update(HabilityDTO habilitydto);
	
	void delete(int id);


}
