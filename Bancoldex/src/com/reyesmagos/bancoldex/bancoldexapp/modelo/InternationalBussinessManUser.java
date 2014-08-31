package com.reyesmagos.bancoldex.bancoldexapp.modelo;

import java.util.List;

public class InternationalBussinessManUser extends BusinessManUser {

	private List<String> operatingCountries;
	private static InternationalBussinessManUser instance;

	private InternationalBussinessManUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void setInstance(InternationalBussinessManUser instance) {
		InternationalBussinessManUser.instance = instance;
	}

	public List<String> getOperatingCountries() {
		return operatingCountries;
	}

	public void setOperatingCountries(List<String> operatingCountries) {
		this.operatingCountries = operatingCountries;
	}

	

	public static InternationalBussinessManUser getInstance() {
		// TODO Auto-generated method stub
		if (instance == null)
			instance = new InternationalBussinessManUser();
		return instance;
	}

}
