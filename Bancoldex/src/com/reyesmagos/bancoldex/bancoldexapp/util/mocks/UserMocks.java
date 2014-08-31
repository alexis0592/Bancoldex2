package com.reyesmagos.bancoldex.bancoldexapp.util.mocks;

import java.util.ArrayList;
import java.util.List;

import com.reyesmagos.bancoldex.bancoldexapp.modelo.NationalBusinessManUser;

public class UserMocks {

	private String name;
	private List<String> partners;
	private List<NationalBusinessManUser> nationalBusinessManUser;

	public UserMocks() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPartners() {
		return partners;
	}

	public void setPartners(List<String> partners) {
		this.partners = partners;
	}

	public String[] getObjects(int option) {
		String[] obj1 = { "reyesmagosSoft2@reyesmagos.co", "Tecnología",
				"Desarrollo", "Pequeña empresa", "Felipe Correa, Laura Osorio",
				"1", "Envigado", "Antioquia", "Cll 69 # 54 B34", "6.161798",
				"-75.570244", "Software" };
		String[] obj2 = { "agricultura@agricutura.co", "Agricultura", "café",
				"Grande empresa", "Jose Florez, Fredy Duitama", "2",
				"Cundinamarca", "Bogotá", "Cll 26 # 45-98", "4.742060",
				"-74.218547", "Panamá", "Agricultura" };
		String[] obj3 = { "banco1@banco.com", "Crediticio", "MiPymes",
				"Grande Empresa", "Bancolombia, Davivienda","3", "Medellín",
				"Antioquia", "Calle 56 # 75 - 67","4.842060","-75.318547", "Banco1", "Jose Carvajal",
				"Economía" };

		switch (option) {
		case 0:
			return obj1;
		case 1:
			return obj2;
		case 3:
			return obj3;
		default:
			break;
		}
		
		return null;
	}

}
