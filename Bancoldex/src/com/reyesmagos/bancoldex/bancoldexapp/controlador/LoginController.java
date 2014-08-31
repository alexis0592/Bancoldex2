package com.reyesmagos.bancoldex.bancoldexapp.controlador;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.reyesmagos.bancoldex.bancoldexapp.activities.NoticesTimeLineActivity;
import com.reyesmagos.bancoldex.bancoldexapp.activities.register.RegisterActivity;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.FactoryUsers;

import android.app.Activity;

public class LoginController extends AbstractController {

	private final String tagFieldOK = "OK";
	private final String tagFielWrong = "WRONG";

	public LoginController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void showAlertMessage(String title, String message) {
		// TODO Auto-generated method stub
		super.showAlertMessage(title, message);
	}

	public String getTagFieldOK() {
		return tagFieldOK;
	}

	public String getTagFielWrong() {
		return tagFielWrong;
	}

	public void login(String username, String password) {
		ParseUser.logInInBackground(username, password, new LogInCallback() {

			@Override
			public void done(ParseUser user, ParseException exe) {
				// TODO Auto-generated method stub
				if (user != null) {
					FactoryUsers.getInstance().createUserFromParseUser(user);
					changeActivity(NoticesTimeLineActivity.class);
					dissmissProgressDialog();
				} else {
					dissmissProgressDialog();
					showAlertMessage("Error",
							"Los Datos Ingresados Son Incorrectos. ");
				}

			}
		});
	}

	@Override
	public void changeActivity(Class<?> destinyClass) {
		// TODO Auto-generated method stub
		super.changeActivity(destinyClass);
	}

}
