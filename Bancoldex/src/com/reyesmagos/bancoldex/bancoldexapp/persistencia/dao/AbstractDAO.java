package com.reyesmagos.bancoldex.bancoldexapp.persistencia.dao;

import com.parse.ParseQuery;
import com.reyesmagos.bancoldex.bancoldexapp.services.asyntask.DAOAsynTask;

public abstract class AbstractDAO {
	
	public void executeAsynTaskDAO(ParseQuery parseQuery){
		DAOAsynTask daoAsynTask = new DAOAsynTask(this);
		daoAsynTask.execute(parseQuery);
	}

}
