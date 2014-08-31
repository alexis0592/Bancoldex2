package com.reyesmagos.bancoldex.bancoldexapp.modelo;

import java.util.ArrayList;
import java.util.List;

import com.parse.ParseUser;
import com.reyesmagos.bancoldex.bancoldexapp.controlador.FacadeController;

public class FactoryUsers {

	public static FactoryUsers instance;

	private FactoryUsers() {

	}

	public static FactoryUsers getInstance() {
		if (instance == null)
			instance = new FactoryUsers();
		return instance;
	}

	public void createUserFromParseUser(ParseUser parseUser) {
		int type = parseUser.getInt("type");
		if (type == 1) {
			createNationalBussinessManUser(parseUser);
		} else if (type == 2) {
			createInternationalBusinessManUser(parseUser);
		} else if (type == 3) {
			createIntermediaryAgent(parseUser);
		}
	}

	public void createInternationalBusinessManUser(ParseUser parseUser) {
		InternationalBussinessManUser internationalBussinessManUser = InternationalBussinessManUser
				.getInstance();
		internationalBussinessManUser.setUsername(parseUser.getUsername());
		internationalBussinessManUser.setEnterpriseType(parseUser
				.getString("enterpriseType"));
		internationalBussinessManUser.setPartners(getListFromToken(
				parseUser.getString("partners"), ","));
		internationalBussinessManUser.setNit(parseUser.getString("nit"));
		internationalBussinessManUser.setSector(parseUser.getString("sector"));
		internationalBussinessManUser.setSubSectro(parseUser
				.getString("subSector"));
		Location location = new Location();
		location.setAdress(parseUser.getString("adress"));
		location.setDepartament(parseUser.getString("department"));
		location.setMunicipio(parseUser.getString("municipio"));
		location.setLat(Double.parseDouble(parseUser.getString("lat")));
		location.setLng(Double.parseDouble(parseUser.getString("lng")));
		internationalBussinessManUser.setLocation(location);
		internationalBussinessManUser.setOperatingCountries(getListFromToken(
				parseUser.getString("operatingCountries"), ","));
		internationalBussinessManUser.setGremio(parseUser.getString("gremio"));
		FacadeController.getInstance().setBusinessManUser(
				internationalBussinessManUser);

	}

	public void createNationalBussinessManUser(ParseUser parseUser) {
		NationalBusinessManUser nationalBusinessManUser = NationalBusinessManUser
				.getInstance();
		nationalBusinessManUser.setUsername(parseUser.getUsername());
		nationalBusinessManUser.setEnterpriseType(parseUser
				.getString("enterpriseType"));
		nationalBusinessManUser.setPartners(getListFromToken(
				parseUser.getString("partners"), ","));
		nationalBusinessManUser.setNit(parseUser.getString("nit"));
		nationalBusinessManUser.setSector(parseUser.getString("sector"));
		nationalBusinessManUser.setSubSectro(parseUser.getString("subSector"));
		Location location = new Location();
		location.setAdress(parseUser.getString("adress"));
		location.setDepartament(parseUser.getString("department"));
		location.setMunicipio(parseUser.getString("municipio"));
		location.setLat(Double.parseDouble(parseUser.getString("lat")));
		location.setLng(Double.parseDouble(parseUser.getString("lng")));
		nationalBusinessManUser.setLocation(location);
		nationalBusinessManUser.setKeyActivities(parseUser
				.getString("keyActivities"));
		nationalBusinessManUser.setGremio(parseUser.getString("gremio"));
		if (FacadeController.getInstance().getIntermediaryAgent() == null)
			FacadeController.getInstance().setBusinessManUser(
					nationalBusinessManUser);
	}

	public void createIntermediaryAgent(ParseUser parseUser) {
		IntermediaryAgent intermediaryAgent = IntermediaryAgent.getInstance();
		intermediaryAgent.setUsername(parseUser.getUsername());
		intermediaryAgent.setEntity(parseUser.getString("entity"));
		intermediaryAgent.setNit(parseUser.getString("nit"));
		intermediaryAgent.setAgentName(parseUser.getString("agentName"));
		intermediaryAgent.setContacto(parseUser.getString("contacto"));
		Location location = new Location();
		location.setAdress(parseUser.getString("adress"));
		location.setDepartament(parseUser.getString("department"));
		location.setMunicipio(parseUser.getString("municipio"));
		location.setLat(Double.parseDouble(parseUser.getString("lat")));
		location.setLng(Double.parseDouble(parseUser.getString("lng")));
		intermediaryAgent.setLocation(location);
		FacadeController.getInstance().setIntermediaryAgent(intermediaryAgent);
	}

	public List<String> getListFromToken(String s, String token) {
		List<String> partnersList = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			if (Character.toString(s.charAt(i)).equals(token)) {
				String x = s.substring(0, i);
				s.replaceFirst(x + ",", "");
				partnersList.add(x);
			}
		}

		return partnersList;
	}

}
