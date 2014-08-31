package com.reyesmagos.bancoldex.bancoldexapp.activities;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.controlador.FacadeController;
import com.reyesmagos.bancoldex.bancoldexapp.opentok.UIActivity;

import android.app.Activity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class LoginActivityMain extends Activity {

	private ActionBar action;
	private FacadeController facadeController;
	private EditText editTextUsername;
	private EditText editTextPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_activity_main);
		Parse.initialize(this, "CSOvHOL2LAGOOeE8qYerrNjH3NI2cVZ5UBOcHlKe",
				"r4XmfDGswmwsZcSjen84pVrwtNgI7nLjxeqjweZH");
		facadeController = FacadeController.getInstance();
		facadeController.registerActivityToController(this);
		init();

	}

	public void init() {
		editTextUsername = (EditText) findViewById(R.id.edittext_username1);

		editTextPassword = (EditText) findViewById(R.id.edittext_password1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_activity_main, menu);
		return true;
	}

	public void btnLogin_Click(View v) {
//		facadeController.login(editTextUsername.getText().toString(),
//				editTextPassword.getText().toString());
//			Intent i = new Intent(this,GenerateQRCodeActivity.class);
//			startActivity(i);

        Intent intent = new Intent(LoginActivityMain.this, UIActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

	}

	public void SingUp(View v) {
		ParseUser user = new ParseUser();
		user.setUsername("reyesmagos");
		user.setPassword("reyesmagos");
		user.setEmail("reyesmagossoft1@gmail.com");
		user.put("type", 2);
		user.put("nit", "890936694");
		user.put("sector", "Informatica");
		user.put("subSector", "subsector");
		user.put("enterpriseType", "microempresa");
		user.put("partners", "alexis calderon, oscar gallon,");
		user.put("municipio", "Medellin");
		user.put("department", "Antioquia");
		user.put("adress", "Call 67 #50-50");
		user.put("lat", "6.454353");
		user.put("lng", "-75.3434");
		user.put("operatingCountries", "guatemala, salvador,");
		user.put("gremio", "Softwariii");
		user.signUpInBackground(new SignUpCallback() {

			@Override
			public void done(ParseException arg0) {
				// TODO Auto-generated method stub
				if (arg0 == null) {
					Log.i("error", "sing");
				}

			}
		});
	}

	public void SingUp2(View v) {
//		ParseUser user = new ParseUser();
//		user.setUsername("ana_giraldo_Bancolombia");
//		user.setPassword("bancolombia");
//		user.setEmail("anagiraldo@Bancolombia.com");
//		user.put("type", 2);
//		user.put("nit", "890936694");
//		user.put("municipio", "Medellin");
//		user.put("department", "Antioquia");
//		user.put("adress", "Call 67 #50-50");
//		user.put("lat", "6.454353");
//		user.put("lng", "-75.3434");
//		user.put("entity", "Bancolombia");
//		user.put("agentName", "Ana Maria Giraldo Perez");
//		user.put("contact0", "andresescobar@bancoldex.com");
//		user.signUpInBackground(new SignUpCallback() {
//
//			@Override
//			public void done(ParseException arg0) {
//				// TODO Auto-generated method stub
//				if (arg0 == null) {
//					Log.i("error", "sing");
//				}
//
//			}
//		});
		Intent i = new Intent(this,ReadQrCodeActivity.class);
		startActivity(i);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
