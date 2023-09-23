package com.interbank.interbank.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Hability")
public class Hability {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column
    private String name;
	
	@Column
	private String powerlevel;
	@Column
	@Nullable
	private boolean state;
	
	@ManyToMany( mappedBy = "Hability" ,cascade= {
			CascadeType.PERSIST, CascadeType.MERGE
	})
	@JsonIgnore
	Set<SuperHero> superheroes;

	
	public void addSuperhero(SuperHero superhero) {
		this.getSuperheroes().add(superhero);
		superhero.getHability().add(this);
	}
	
	public void deleteMovies(SuperHero superhero) {
		this.getSuperheroes().remove(superhero);
		superhero.getHability().remove(this);
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPowerlevel() {
		return powerlevel;
	}
	
	public void setPowerlevel(String powerlevel) {
		this.powerlevel = powerlevel;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Set<SuperHero> getSuperheroes() {
		return superheroes;
	}

	public void setSuperheroes(Set<SuperHero> superheroes) {
		this.superheroes = superheroes;
	}



    
}
