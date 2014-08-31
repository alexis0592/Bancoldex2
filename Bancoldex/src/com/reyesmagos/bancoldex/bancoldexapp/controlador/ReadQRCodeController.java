package com.reyesmagos.bancoldex.bancoldexapp.controlador;

import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.reyesmagos.bancoldex.bancoldexapp.activities.ReadQrCodeActivity;

import android.app.Activity;
import android.view.View;

public class ReadQRCodeController extends AbstractController {

	public ReadQRCodeController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	public void showProductInfo() {
		ReadQrCodeActivity readQrCodeActivity = new ReadQrCodeActivity();
		readQrCodeActivity.getTextviewProductDetail().setText("");
		readQrCodeActivity.getTextviewProductName().setText("");
	}

	

}
