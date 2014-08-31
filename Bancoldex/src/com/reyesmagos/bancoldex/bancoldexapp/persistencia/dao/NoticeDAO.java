package com.reyesmagos.bancoldex.bancoldexapp.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.reyesmagos.bancoldex.bancoldexapp.controlador.FacadeController;
import com.reyesmagos.bancoldex.bancoldexapp.modelo.Notice;
import com.reyesmagos.bancoldex.bancoldexapp.services.asyntask.DAOAsynTask;

public class NoticeDAO extends AbstractDAO implements INoticeDAO {

	@Override
	public void getNoticesFromDepartment(String department) {
		// TODO Auto-generated method stub
		ParseQuery query = new ParseQuery("Notice");
		query.whereEqualTo("departament", department);
		executeAsynTaskDAO(query);
	}

	@Override
	public void getNoticesFromCountrie(List<String> countrie) {
		// TODO Auto-generated method stub
		ParseQuery query = new ParseQuery("Notice");
		String s = countrie.get(0);
		query.whereEqualTo("countrie", s);

		executeAsynTaskDAO(query);

	}

	@Override
	public void getNoticesFromGremio(String gremio) {
		// TODO Auto-generated method stub
		ParseQuery query = new ParseQuery("Notice");
		query.whereEqualTo("gremio", gremio);
		executeAsynTaskDAO(query);
	}

	@Override
	public void getNoticeFromContacto(String contacto) {
		ParseQuery query = new ParseQuery("Notice");
		query.whereEqualTo("contacto", contacto);
		executeAsynTaskDAO(query);
	}

	@Override
	public void getNoticeFromEntity(String entity) {
		ParseQuery query = new ParseQuery("Notice");
		query.whereEqualTo("entity", entity);
		executeAsynTaskDAO(query);
	}

	@Override
	public void getNoticeFromSector(String Sector) {
		ParseQuery query = new ParseQuery("Notice");
		query.whereEqualTo("sector", Sector);
		executeAsynTaskDAO(query);
	}

	@Override
	public void executeAsynTaskDAO(ParseQuery parseQuery) {
		// TODO Auto-generated method stub
		super.executeAsynTaskDAO(parseQuery);

	}

	public void createNotice(List lista) {
		List<Notice> noticeList = new ArrayList<Notice>();
		for (Object object : lista) {
			ParseObject parseObject = (ParseObject) object;
			Notice notice = new Notice();
			notice.setContent(parseObject.getString("content"));
			notice.setCountrie(parseObject.getString("countrie"));
			notice.setDate(parseObject.getString("date"));
			notice.setDepartment(parseObject.getString("departament"));
			notice.setGremio(parseObject.getString("gremio"));
			notice.setSector(parseObject.getString("sector"));
			notice.setTitle(parseObject.getString("title"));
			notice.setContacto(parseObject.getString("contacto"));
			noticeList.add(notice);

		}
		FacadeController.getInstance().showNotices(noticeList);

	}

}
