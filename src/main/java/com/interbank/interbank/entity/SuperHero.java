package com.interbank.interbank.entity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="SuperHero")
public class SuperHero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer superheroid;
	
	@Column
	private String name;
	@Column
	private String description;
	
	@Column
	private String powerLevel;
	
	@Column
	@Nullable
	private Boolean state;
	
	@ManyToMany(
	        cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	        })   
	@JoinTable(
        name = "Hability_superhero",
        joinColumns = { @JoinColumn(name = "superhero_id", referencedColumnName = "superheroid" ) },
        inverseJoinColumns = { @JoinColumn(name = "hability_id", referencedColumnName = "id") }
    )
	@JsonIgnore
    private Set<Hability> Hability;
	

	public Integer getSuperheroid() {
		return superheroid;
	}

	public void setSuperheroid(Integer superheroid) {
		this.superheroid = superheroid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(String powerLevel) {
		this.powerLevel = powerLevel;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Set<Hability> getHability() {
		return Hability;
	}

	public void setHability(Set<Hability> hability) {
		Hability = hability;
	}


	public void addHability(Hability hability) {
		this.getHability().add(hability);
		hability.getSuperheroes().add(this);
	}
	
	public void deleteHability(Hability hability) {
		this.getHability().remove(hability);
		hability.getSuperheroes().remove(this);
	}

	
}
