package com.reyesmagos.bancoldex.bancoldexapp.modelo;

import java.util.List;

public abstract class BusinessManUser {

	private String username;

	private String nit;
	private String sector;
	private String subSector;
	private List<String> partners;
	private Location location;
	private String enterpriseType;
	private String gremio;
	
	

	public String getSubSector() {
		return subSector;
	}

	public void setSubSector(String subSector) {
		this.subSector = subSector;
	}

	public String getGremio() {
		return gremio;
	}

	public void setGremio(String gremio) {
		this.gremio = gremio;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getSubSectro() {
		return subSector;
	}

	public void setSubSectro(String subSectro) {
		this.subSector = subSectro;
	}

	public List<String> getPartners() {
		return partners;
	}

	public void setPartners(List<String> partners) {
		this.partners = partners;
	} 

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
