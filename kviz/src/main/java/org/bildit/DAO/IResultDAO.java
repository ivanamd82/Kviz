package org.bildit.DAO;

import java.sql.SQLException;

import org.bildit.DTO.Result;

public interface IResultDAO {
	
	public Result getScore(String name) throws SQLException;
	
	public boolean addScore(Result result) throws SQLException;
}
