package com.reyesmagos.bancoldex.bancoldexapp.activities;

import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.R.id;
import com.reyesmagos.bancoldex.bancoldexapp.R.layout;
import com.reyesmagos.bancoldex.bancoldexapp.R.menu;
import com.reyesmagos.bancoldex.bancoldexapp.activities.solution.SolutionActivity;
import com.reyesmagos.bancoldex.bancoldexapp.controlador.FacadeController;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.BusinessManUser;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.IntermediaryAgent;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Build;

public class NoticesTimeLineActivity extends Activity {
	private FacadeController facadeController;
	private ListView listviewNotices;
	private ActionBar action;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notices_time_line);
		facadeController = FacadeController.getInstance();
		facadeController.registerActivityToController(this);
		action = getActionBar();
		action.setTitle("Noticias");
		init();
		BusinessManUser businessManUser = facadeController.getBusinessManUser();
		if (businessManUser != null) {
			facadeController.getNoticesFromBusinessMan(facadeController
					.getBusinessManUser());
		} else {
			IntermediaryAgent intermediaryAgent = facadeController
					.getIntermediaryAgent();
			facadeController.getNoticesFromEntity(intermediaryAgent);
		}

	}

	public ActionBar getAction() {
		return action;
	}

	public void setActionBar(ActionBar actionBar) {
		this.action = actionBar;
	}

	public void init() {
		listviewNotices = (ListView) findViewById(R.id.listView_notices);

	}

	public ListView getListviewNotices() {
		return listviewNotices;
	}

	public void setListviewNotices(ListView listviewNotices) {
		this.listviewNotices = listviewNotices;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notices_time_line, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.filters) {
			BusinessManUser businessManUser = facadeController
					.getBusinessManUser();
			if (businessManUser != null) {
				facadeController.showFiltersForBusinessmanUser(facadeController
						.getBusinessManUser());
			} else {
				IntermediaryAgent intermediaryAgent = facadeController
						.getIntermediaryAgent();
				facadeController
						.showFiltersForIntermediaryAgent(intermediaryAgent);
			}
			return true;
		} else if (id == R.id.solutions) {
			startActivity(new Intent(this, SolutionActivity.class));

		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog
					.setMessage(
							"¿Esta seguro que desea salir de la aplicación?")
					.setTitle("Alerta").setCancelable(false);
			alertDialog.setPositiveButton("Salir", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					System.exit(1);

				}
			});
			alertDialog.setNegativeButton("Cancelar", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			});

			AlertDialog alertDialog2 = alertDialog.create();

			alertDialog2.show();
		}

		return super.onKeyDown(keyCode, event);
	}

}
