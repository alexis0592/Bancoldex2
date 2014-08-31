package com.reyesmagos.bancoldex.bancoldexapp.util.mocks;

import java.util.ArrayList;
import java.util.List;

public class NeedMock {
	
	private List<String> needList;
	
	public NeedMock(){
		
	}
	
	public void setListNeed(){
		this.needList = new ArrayList<String>();
		needList.add("Atender costos y gastos operativos");
		needList.add("Invertir en propiedad planta y equipo");
		needList.add("Modificar la estructura de endeudamiento");
		needList.add("Crear, capitalizar o adquirir una empresa");
	}
	
	public List<String> getNeedList() {
		setListNeed();
		return needList;
	}

}
