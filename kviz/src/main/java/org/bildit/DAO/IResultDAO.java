package org.bildit.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.DTO.Result;

public interface IResultDAO {
	
	public ArrayList<Result> getResult(String name) throws SQLException;
	
	public boolean addResult(Result result) throws SQLException;
	
	public ArrayList<Result> topNScore(int n) throws SQLException;
}
