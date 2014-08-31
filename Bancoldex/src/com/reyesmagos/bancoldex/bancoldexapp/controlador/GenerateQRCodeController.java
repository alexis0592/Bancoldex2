package com.reyesmagos.bancoldex.bancoldexapp.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.reyesmagos.bancoldex.bancoldexapp.activities.GenerateQRCodeActivity;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.Contents;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.QRCodeEncoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.view.View;

public class GenerateQRCodeController extends AbstractController {

	public GenerateQRCodeController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	public void generateQrCode() {
		// generate a 150x150 QR code
		QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(
				"Ola Felipe Eres Lindo", null, Contents.Type.TEXT,
				BarcodeFormat.QR_CODE.toString(), 500);

		try {
			Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();

			GenerateQRCodeActivity generateQRCodeActivity = (GenerateQRCodeActivity) getActivity();
			generateQRCodeActivity.getImageviewQR().setImageBitmap(bitmap);
			save(bitmap);

		} catch (WriterException e) {
			e.printStackTrace();
		}
	}

	public void save(Bitmap bitmap) {
		String file_path = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/QR";
		File dir = new File(file_path);
		if (!dir.exists())
			dir.mkdirs();
		Random r = new Random();
		int x = r.nextInt();
		File file = new File(dir, "QR" + x + ".png");
		FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(file);
			bitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut);
			showAlertMessage("Exito", "Archivo Generado Con Exito. Ruta: "
					+ file_path);
			fOut.flush();
			fOut.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
