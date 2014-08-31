package com.reyesmagos.bancoldex.bancoldexapp.activities;

import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.controlador.FacadeController;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class GenerateQRCodeActivity extends Activity {

	private Bitmap bitmap;
	private ImageView imageviewQR;
	private FacadeController facadeController;
	private ActionBar action;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_generate_qrcode);
		facadeController = FacadeController.getInstance();
		init();
		facadeController.registerActivityToController(this);
		facadeController.generateQrCode();
		action = getActionBar();
		action.setTitle("Generar Codigo QR");

	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public ImageView getImageviewQR() {
		return imageviewQR;
	}

	public void setImageviewQR(ImageView imageviewQR) {
		this.imageviewQR = imageviewQR;
	}

	public void init() {
		imageviewQR = (ImageView) findViewById(R.id.imageViewQR);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.generate_qrcode, menu);
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
