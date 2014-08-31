package com.reyesmagos.bancoldex.bancoldexapp.controlador;

import java.util.List;

import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.activities.NoticesTimeLineActivity;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.BusinessManUser;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.CustomAdapter;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.IntermediaryAgent;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.InternationalBussinessManUser;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.NationalBusinessManUser;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.Notice;
import com.reyesmagos.bancoldex.bancoldexapp.persistencia.dao.NoticeDAO;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class NoticeTimeLineController extends AbstractController {

	public NoticeTimeLineController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	public void showFiltersForNationalBusinessmanUser(
			final BusinessManUser businessManUser) {
		AlertDialog.Builder builderSingle = new AlertDialog.Builder(
				getActivity());
		builderSingle.setIcon(R.drawable.ic_launcher);
		builderSingle.setTitle("Seleccione Un Filtro");
		final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.select_dialog_singlechoice);
		if (businessManUser instanceof NationalBusinessManUser)
			arrayAdapter.add("Region");
		else
			arrayAdapter.add("Countrie");
		arrayAdapter.add("Gremio");
		arrayAdapter.add("Sector");

		builderSingle.setAdapter(arrayAdapter, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				if (arg1 == 0) {

					getNoticesFromBusinessMan(businessManUser);

				} else if (arg1 == 1) {
					NoticesTimeLineActivity noticesTimeLineActivity = (NoticesTimeLineActivity) getActivity();
					noticesTimeLineActivity.getAction().setTitle(
							"Noticias Relacionadas Con "
									+ businessManUser.getGremio());
					getNoticesFromGremio(businessManUser);
				} else if (arg1 == 2) {
					NoticesTimeLineActivity noticesTimeLineActivity = (NoticesTimeLineActivity) getActivity();
					noticesTimeLineActivity.getAction().setTitle(
							"Noticias Relacionadas Con "
									+ businessManUser.getSector());
					getNoticesFromSector(businessManUser);
				}
			}
		});
		builderSingle.show();

	}

	public void showFiltersForIntermediant(
			final IntermediaryAgent intermediaryAgent) {
		AlertDialog.Builder builderSingle = new AlertDialog.Builder(
				getActivity());
		builderSingle.setIcon(R.drawable.ic_launcher);
		builderSingle.setTitle("Seleccione un filtro");
		final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.select_dialog_singlechoice);

		arrayAdapter.add("Entity");
		arrayAdapter.add("Contacto");

		builderSingle.setAdapter(arrayAdapter, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				if (arg1 == 0) {
					NoticesTimeLineActivity noticesTimeLineActivity = (NoticesTimeLineActivity) getActivity();
					noticesTimeLineActivity.getAction().setTitle(
							"Noticias Relacionadas Con "
									+ intermediaryAgent.getEntity());
					getNoticesFromEntity(intermediaryAgent);
				} else {
					NoticesTimeLineActivity noticesTimeLineActivity = (NoticesTimeLineActivity) getActivity();
					noticesTimeLineActivity.getAction().setTitle(
							"Noticias Relacionadas Con "
									+ intermediaryAgent.getContacto());
					getNoticesFromContanto(intermediaryAgent);
				}
			}
		});
		builderSingle.show();

	}

	public void getNoticesFromBusinessMan(BusinessManUser businessManUser) {
		if (businessManUser instanceof NationalBusinessManUser) {
			NoticeDAO noticeDAO = new NoticeDAO();
			noticeDAO.getNoticesFromDepartment(businessManUser.getLocation()
					.getDepartament());
			NoticesTimeLineActivity noticesTimeLineActivity = (NoticesTimeLineActivity) getActivity();
			noticesTimeLineActivity.getAction().setTitle(
					"Noticias Relacionadas Con "
							+ businessManUser.getLocation().getDepartament());
		}
		if (businessManUser instanceof InternationalBussinessManUser) {
			NoticesTimeLineActivity noticesTimeLineActivity = (NoticesTimeLineActivity) getActivity();
			noticesTimeLineActivity.getAction().setTitle(
					"Noticias Relacionadas Con EL Exterior");
			NoticeDAO noticeDAO = new NoticeDAO();
			noticeDAO
					.getNoticesFromCountrie(((InternationalBussinessManUser) businessManUser)
							.getOperatingCountries());
		}

	}

	public void getNoticesFromSector(BusinessManUser businessManUser) {
		NoticeDAO noticeDAO = new NoticeDAO();
		noticeDAO.getNoticeFromSector(businessManUser.getSector());
	}

	public void getNoticesFromEntity(IntermediaryAgent intermediaryAgent) {
		NoticeDAO noticeDAO = new NoticeDAO();
		noticeDAO.getNoticeFromEntity(intermediaryAgent.getEntity());
	}

	public void getNoticesFromGremio(BusinessManUser businessManUser) {
		NoticeDAO noticeDAO = new NoticeDAO();
		noticeDAO.getNoticesFromGremio(businessManUser.getGremio());
	}

	public void getNoticesFromContanto(IntermediaryAgent intermediaryAgent) {
		NoticeDAO noticeDAO = new NoticeDAO();
		noticeDAO.getNoticeFromContacto(intermediaryAgent.getContacto());
	}

	public void showNotices(List<Notice> noticeList) {
		dissmissProgressDialog();
		NoticesTimeLineActivity noticesTimeLineActivity = (NoticesTimeLineActivity) getActivity();
		CustomAdapter customAdapter = new CustomAdapter(getActivity(),
				noticeList);
		noticesTimeLineActivity.getListviewNotices().setAdapter(customAdapter);

	}

}
