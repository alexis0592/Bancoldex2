package com.reyesmagos.bancoldex.bancoldexapp.controlador;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.reyesmagos.bancoldex.bancoldexapp.util.mocks.UserMocks;

public class RegisterController extends AbstractController {

	public RegisterController(Activity activity) {
		super(activity);
	}

	public void register(String nit, String username, String password,
			int option) {
		
		UserMocks userMocks = new UserMocks();
		String[] infoAux = userMocks.getObjects(option);
		ParseUser parseUser = new ParseUser();
		if (nit.equals("890936694")) {
			parseUser.setUsername(username);
			parseUser.setPassword(password);
			parseUser.setEmail(infoAux[0]);
			parseUser.put("type", infoAux[5]);
			parseUser.put("nit", "890936694");
			parseUser.put("sector", infoAux[1]);
			parseUser.put("subSector", infoAux[2]);
			parseUser.put("enterpriseType", infoAux[3]);
			parseUser.put("partners", infoAux[4]);
			parseUser.put("municipio", infoAux[6]);
			parseUser.put("department", infoAux[7]);
			parseUser.put("adress", infoAux[8]);
			parseUser.put("lat", infoAux[9]);
			parseUser.put("lng", infoAux[10]);
			parseUser.put("keyActivities", infoAux[11]);
			parseUser.put("gremio", infoAux[11]);
		} else if (nit.equals("894563452")) {
			parseUser.setUsername(username);
			parseUser.setPassword(password);
			parseUser.setEmail(infoAux[0]);
			parseUser.put("type", infoAux[5]);
			parseUser.put("nit", "894563452");
			parseUser.put("sector", infoAux[1]);
			parseUser.put("subSector", infoAux[2]);
			parseUser.put("enterpriseType", infoAux[3]);
			parseUser.put("partners", infoAux[4]);
			parseUser.put("municipio", infoAux[6]);
			parseUser.put("department", infoAux[7]);
			parseUser.put("adress", infoAux[8]);
			parseUser.put("lat", infoAux[9]);
			parseUser.put("lng", infoAux[10]);
			parseUser.put("operatingCountries", infoAux[11]);
			parseUser.put("gremio", infoAux[12]);
		} else if (nit.equals("9812345")) {
			parseUser.setUsername(username);
			parseUser.setPassword(password);
			parseUser.setEmail(infoAux[0]);
			parseUser.put("type", Integer.parseInt(infoAux[5]));
			parseUser.put("nit", "9812345");
			parseUser.put("sector", infoAux[1]);
			parseUser.put("subSector", infoAux[2]);
			parseUser.put("enterpriseType", infoAux[3]);
			parseUser.put("partners", infoAux[4]);
			parseUser.put("municipio", infoAux[6]);
			parseUser.put("department", infoAux[7]);
			parseUser.put("adress", infoAux[8]);
			parseUser.put("lat", infoAux[9]);
			parseUser.put("lng", infoAux[10]);
			parseUser.put("entity", infoAux[11]);
			parseUser.put("agentName", infoAux[12]);
			parseUser.put("gremio", infoAux[13]);
		}else{
			showAlertMessage("Error", "Hubo un error");
		}
		
		parseUser.signUpInBackground(new SignUpCallback() {
			
			@Override
			public void done(ParseException arg0) {
				if(arg0 == null){
					Log.i("error", "There was an error");
				}
			}
		});

	

		
	}

}
