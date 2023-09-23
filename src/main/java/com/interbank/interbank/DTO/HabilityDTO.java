package com.interbank.interbank.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class HabilityDTO {

	
	private int id;
	private String name;
	private String powerlevel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	
}
