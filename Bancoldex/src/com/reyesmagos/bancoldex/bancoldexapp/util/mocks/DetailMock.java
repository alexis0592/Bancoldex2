package com.reyesmagos.bancoldex.bancoldexapp.util.mocks;

import java.util.ArrayList;
import java.util.List;

public class DetailMock {
	
	public DetailMock(){
		
	}
	
	public List<String> setDetails(){
		List<String> results = new ArrayList<String>();
		
		results.add("48 meses");
		results.add("N/A");
		results.add("12 meses");
		results.add("10.000.000.000 pesos");
		results.add("DTF (E.A.) + 8.00% (E.A.)");
		results.add("0 hasta 48 meses DTF (E.A) + 1.25% (E.A");
		
		return results;
	}

}
