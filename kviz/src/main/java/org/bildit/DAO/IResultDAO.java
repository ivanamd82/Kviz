package org.bildit.DAO;

import java.sql.SQLException;

import org.bildit.DTO.Result;

public interface IResultDAO {
	
	public Result getResult(String name) throws SQLException;
	
	public boolean addResult(Result result) throws SQLException;
}
