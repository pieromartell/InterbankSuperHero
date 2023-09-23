package com.interbank.interbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.interbank.interbank.entity.SuperHero;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Integer> {

	@Query("Select s from SuperHero s where s.name LIKE %:name%")
	List<SuperHero>findByName(@Param("name") String name);
	
	@Query("Select s from SuperHero s where s.powerLevel = :powerLevel")
	List<SuperHero> findByPowerLevel(@Param("powerLevel") String powerLevel);
	
	SuperHero findBySuperheroid(Integer superheroid);
}
