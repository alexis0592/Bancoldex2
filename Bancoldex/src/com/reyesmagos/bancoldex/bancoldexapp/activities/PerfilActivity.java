package com.reyesmagos.bancoldex.bancoldexapp.activities;

import com.reyesmagos.bancoldex.bancoldexapp.Mapa;
import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.R.id;
import com.reyesmagos.bancoldex.bancoldexapp.R.layout;
import com.reyesmagos.bancoldex.bancoldexapp.R.menu;
import com.reyesmagos.bancoldex.bancoldexapp.controlador.FacadeController;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.BusinessManUser;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.IntermediaryAgent;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.NationalBusinessManUser;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class PerfilActivity extends Activity {

	private FacadeController facadeController;
	private ActionBar action;
	private TextView txtUsername;
	private TextView txtEnterpriseType;
	private TextView txtGremio;
	private TextView txtKeyActivies;
	private TextView txtUbicacion;
	private TextView txtSector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		facadeController = FacadeController.getInstance();
		facadeController.registerActivityToController(this);
		action = getActionBar();
		action.setTitle("Noticias");
		NationalBusinessManUser nationalBusinessManUser = NationalBusinessManUser
				.getInstance();
		init();
		showUserInfo(nationalBusinessManUser);

	}

	public void init() {
		txtUsername = (TextView) findViewById(R.id.txtusername);
		txtEnterpriseType = (TextView) findViewById(R.id.txtenterprisetype);
		txtGremio = (TextView) findViewById(R.id.txtgremio);
		txtKeyActivies = (TextView) findViewById(R.id.txtkeyactivities);
		txtUbicacion = (TextView) findViewById(R.id.txtubicacion);
		txtSector = (TextView) findViewById(R.id.txtsector);
	}

	public void showMap(View v) {
		Intent i = new Intent(this, Mapa.class);
		startActivity(i);
	}

	public void showUserInfo(NationalBusinessManUser nationalBusinessManUser) {
		txtEnterpriseType.setText(nationalBusinessManUser.getEnterpriseType());
		txtGremio.setText(nationalBusinessManUser.getGremio());
		txtKeyActivies.setText(nationalBusinessManUser.getKeyActivities());
		txtSector.setText(nationalBusinessManUser.getSector());
		txtUbicacion.setText("Departamento: "
				+ nationalBusinessManUser.getLocation().getDepartament()
				+ ", Municipio: "
				+ nationalBusinessManUser.getLocation().getMunicipio()
				+ ", Direccion: "
				+ nationalBusinessManUser.getLocation().getAdress());
		txtUsername.setText(nationalBusinessManUser.getUsername());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perfil, menu);
		return true;
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
