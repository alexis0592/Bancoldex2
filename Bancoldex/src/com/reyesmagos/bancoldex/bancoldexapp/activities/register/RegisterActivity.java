package com.reyesmagos.bancoldex.bancoldexapp.activities.register;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.controlador.RegisterController;
import com.reyesmagos.bancoldex.bancoldexapp.util.mocks.NeedMock;
import com.reyesmagos.bancoldex.bancoldexapp.util.mocks.SectorMock;
import com.reyesmagos.bancoldex.bancoldexapp.util.mocks.UserMocks;

public class RegisterActivity extends Activity {

	private Spinner spinnerRol;
	private EditText passwordEdittext;
	private EditText nitEdittext;
	private EditText userNameEditText;
	public static TextView selectedNeed;
	private ImageView acceptImageView;
	public static ImageView imageViewNecessity;

	private String userName;
	private String nitNumber;
	public static String sector;
	public static String subSector;
	private String password;
	public static String needSelected;
	int option;
	String aux;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);
		createComponents();
	}

	private void createComponents() {

		ArrayAdapter<CharSequence> rolAdapter = ArrayAdapter
				.createFromResource(this, R.array.rol_array,
						android.R.layout.simple_spinner_item);
		rolAdapter
				.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		this.spinnerRol = (Spinner) super.findViewById(R.id.spinner_rol);
		this.spinnerRol.setAdapter(rolAdapter);
		this.spinnerRol
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						aux = arg0.getItemAtPosition(arg2).toString();
						if (aux.equals("Empresario Nacional")) {
							option = 1;
						} else if (aux.equals("Empresario Extranjero")) {
							option = 2;
						} else {
							option = 3;
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {

					}
				});

		this.passwordEdittext = (EditText) super.findViewById(R.id.editText1);
		this.nitEdittext = (EditText) super
				.findViewById(R.id.editText_nit_number);
		this.userNameEditText = (EditText) super
				.findViewById(R.id.editText_user_name1);
		this.acceptImageView = (ImageView) super
				.findViewById(R.id.imageView_accept);
		RegisterActivity.imageViewNecessity = (ImageView) super
				.findViewById(R.id.imageView_neccesity);
	}

	public void onSectorClick(View view) {
		Intent sectorIntent = new Intent(this, SectorSelectorActivity.class);
		startActivity(sectorIntent);
	}

	public void onNeedClick(View view) {
		NeedMock needMock = new NeedMock();
		AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
		builderSingle.setIcon(R.drawable.ic_launcher);
		builderSingle.setTitle("Seleccione Un Filtro");
		final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
				this, android.R.layout.select_dialog_singlechoice,needMock.getNeedList());

		builderSingle.setAdapter(arrayAdapter, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int pos) {
				needSelected = arrayAdapter.getItem(pos);
				Log.i("Selected", needSelected);
			}
		});
		builderSingle.show();

		// startActivity(new Intent(this, NeedSelectorActivity.class));

	}

	public void onRegisterUser(View view) {
		RegisterController registerController = new RegisterController(this);

		this.password = this.passwordEdittext.getText().toString();
		this.nitNumber = this.nitEdittext.getText().toString();
		this.userName = this.userNameEditText.getText().toString();

		registerController.register(nitNumber, userName, password, option);
		finish();
	}
}
