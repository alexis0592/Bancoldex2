package com.reyesmagos.bancoldex.bancoldexapp.controlador;

import java.util.List;

import com.reyesmagos.bancoldex.bancoldexapp.activities.GenerateQRCodeActivity;
import com.reyesmagos.bancoldex.bancoldexapp.activities.LoginActivityMain;
import com.reyesmagos.bancoldex.bancoldexapp.activities.NoticesTimeLineActivity;
import com.reyesmagos.bancoldex.bancoldexapp.activities.ReadQrCodeActivity;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.BusinessManUser;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.IntermediaryAgent;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.Notice;

import android.app.Activity;

public class FacadeController {

	private static FacadeController instance;
	private LoginController loginController;
	private BusinessManUser businessManUser;
	private IntermediaryAgent intermediaryAgent;
	private NoticeTimeLineController noticeTimeLineController;
	private GenerateQRCodeController generateQRCodeController;
	private ReadQRCodeController readQRCodeController;

	private FacadeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessManUser getBusinessManUser() {
		return businessManUser;
	}

	public void showFiltersForIntermediaryAgent(
			IntermediaryAgent intermediaryAgent) {
		this.noticeTimeLineController
				.showFiltersForIntermediant(intermediaryAgent);
	}

	public void showFiltersForBusinessmanUser(BusinessManUser businessManUser) {
		this.noticeTimeLineController
				.showFiltersForNationalBusinessmanUser(businessManUser);
	}

	public void generateQrCode() {
		this.generateQRCodeController.generateQrCode();
	}

	public void setBusinessManUser(BusinessManUser businessManUser) {
		this.businessManUser = businessManUser;
	}

	public IntermediaryAgent getIntermediaryAgent() {
		return intermediaryAgent;
	}

	public void setIntermediaryAgent(IntermediaryAgent intermediaryAgent) {
		this.intermediaryAgent = intermediaryAgent;
	}

	public void registerActivityToController(Activity activity) {
		if (activity instanceof LoginActivityMain)
			this.loginController = new LoginController(activity);
		if (activity instanceof NoticesTimeLineActivity)
			this.noticeTimeLineController = new NoticeTimeLineController(
					activity);
		if (activity instanceof GenerateQRCodeActivity)
			this.generateQRCodeController = new GenerateQRCodeController(
					activity);
		if (activity instanceof ReadQrCodeActivity)
			this.readQRCodeController = new ReadQRCodeController(activity);

	}

	public void getNoticesFromBusinessMan(BusinessManUser businessManUser) {
		this.noticeTimeLineController.showProgressDialog("Alerta",
				"Buscando Noticias Por Favor Espere");
		this.noticeTimeLineController
				.getNoticesFromBusinessMan(businessManUser);

	}

	public void login(String username, String password) {
		this.loginController.showProgressDialog("alert", "Espere Por Favor");
		this.loginController.login(username, password);

	}

	public void showNotices(List<Notice> listNotice) {
		this.noticeTimeLineController.showNotices(listNotice);
	}

	public static FacadeController getInstance() {
		if (instance == null)
			instance = new FacadeController();
		return instance;
	}

	public void getNoticesFromSector(BusinessManUser businessManUser) {
		this.noticeTimeLineController.showProgressDialog("Alerta",
				"Buscando Noticias Por Favor Espere");
		this.noticeTimeLineController.getNoticesFromSector(businessManUser);
	}

	public void getNoticesFromGremio(BusinessManUser businessManUser) {
		this.noticeTimeLineController.showProgressDialog("Alerta",
				"Buscando Noticias Por Favor Espere");
		this.noticeTimeLineController.getNoticesFromGremio(businessManUser);
	}

	public static void setInstance(FacadeController instance) {

		FacadeController.instance = instance;
	}

	public void getNoticesFromEntity(IntermediaryAgent intermediaryAgent) {
		this.noticeTimeLineController.showProgressDialog("Alerta",
				"Buscando Noticias Por Favor Espere");
		this.noticeTimeLineController.getNoticesFromEntity(intermediaryAgent);
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

}
