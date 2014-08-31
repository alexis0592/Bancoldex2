package com.reyesmagos.bancoldex.bancoldexapp.persistencia.dao;

import java.util.List;

import com.reyesmagos.bancoldex.bancoldexapp.modelo.Notice;

public interface INoticeDAO {

	public void getNoticesFromDepartment(String department);

	public void getNoticesFromCountrie(List<String> countrie);

	public void getNoticesFromGremio(String Gremio);

	public void getNoticeFromContacto(String contacto);

	public void getNoticeFromEntity(String entity);
	
	public void getNoticeFromSector(String sector);

}
