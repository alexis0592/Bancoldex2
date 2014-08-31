package com.reyesmagos.bancoldex.bancoldexapp.modelo;

import java.util.List;

public class NationalBusinessManUser extends BusinessManUser {

	private String keyActivities;

	public static NationalBusinessManUser instance;

	private NationalBusinessManUser() {
		super();
	}

	public String getKeyActivities() {
		return keyActivities;
	}

	public void setKeyActivities(String keyActivities) {
		this.keyActivities = keyActivities;
	}



	public static void setInstance(NationalBusinessManUser instance) {
		NationalBusinessManUser.instance = instance;
	}

	public static NationalBusinessManUser getInstance() {
		if (instance == null)
			instance = new NationalBusinessManUser();
		return instance;
	}

}
