package com.interbank.interbank.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class SuperHeroDTO {

	private int getSuperheroid;
	private String name;
	private String description;
	private String powerLevel;
		
	public int getGetSuperheroid() {
		return getSuperheroid;
	}
	public void setGetSuperheroid(int getSuperheroid) {
		this.getSuperheroid = getSuperheroid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPowerLevel() {
		return powerLevel;
	}
	public void setPowerLevel(String powerLevel) {
		this.powerLevel = powerLevel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
