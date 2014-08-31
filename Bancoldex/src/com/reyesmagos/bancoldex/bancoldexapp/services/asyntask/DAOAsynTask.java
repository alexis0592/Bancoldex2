package com.reyesmagos.bancoldex.bancoldexapp.services.asyntask;

import java.util.List;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.reyesmagos.bancoldex.bancoldexapp.persistencia.dao.AbstractDAO;
import com.reyesmagos.bancoldex.bancoldexapp.persistencia.dao.NoticeDAO;

import android.os.AsyncTask;

public class DAOAsynTask extends AsyncTask<ParseQuery, String, Boolean> {

	private AbstractDAO ownerDAO;
	private List daoResults;

	public DAOAsynTask(AbstractDAO ownerDAO) {
		super();
		this.ownerDAO = ownerDAO;
	}

	@Override
	protected Boolean doInBackground(ParseQuery... queries) {
		// TODO Auto-generated method stub
		ParseQuery query = queries[0];
		try {
			daoResults = query.find();

			return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result) {
			if (this.ownerDAO instanceof NoticeDAO) {
				NoticeDAO noticeDAO = (NoticeDAO) this.ownerDAO;
				noticeDAO.createNotice(daoResults);
			}
		}
	}

}
