package com.reyesmagos.bancoldex.bancoldexapp.activities.register;

import java.util.List;

import com.reyesmagos.bancoldex.bancoldexapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class SectorSelectorActivity extends Activity {

	private Spinner spinnerSector;
	private Spinner spinnerSubSector;
	private String sector;
	private String subSector;

	public SectorSelectorActivity() {
		super();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sector_selector_activity);
		createComponents();
	}

	private void createComponents() {

		spinnerSector = (Spinner) findViewById(R.id.spinner1);
		spinnerSubSector = (Spinner) super.findViewById(R.id.spinner_subsector);

		ArrayAdapter<CharSequence> arraySector;
		arraySector = ArrayAdapter.createFromResource(
				this.getApplicationContext(), R.array.sector_array,
				R.layout.spinner_textview);
		ArrayAdapter<CharSequence> arrayAdapterSubSector = ArrayAdapter
				.createFromResource(this.getApplicationContext(),
						R.array.subsector_array, R.layout.spinner_textview);

		spinnerSector.setAdapter(arraySector);
		spinnerSubSector.setAdapter(arrayAdapterSubSector);
		spinnerSector
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {
						sector = parent.getItemAtPosition(pos).toString();

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		spinnerSubSector
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int pos, long id) {
						subSector = parent.getItemAtPosition(pos).toString();

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

	}

	public void onSetSectorSelectorClick(View view) {
		RegisterActivity.sector = sector;
		RegisterActivity.subSector = subSector;
	}

}
