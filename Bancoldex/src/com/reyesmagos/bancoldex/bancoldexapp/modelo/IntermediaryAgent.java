package com.reyesmagos.bancoldex.bancoldexapp.modelo;

import java.util.List;

import com.parse.ParseObject;

public class IntermediaryAgent {

	private String nit;
	private String username;
	private String sector;
	private Location location;
	private String entity;
	private static IntermediaryAgent instance;
	private String agentName;
	private String contacto;
	
	

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	private IntermediaryAgent() {

	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public static IntermediaryAgent getInstance() {
		if (instance == null)
			instance = new IntermediaryAgent();
		return instance;
	}

}
