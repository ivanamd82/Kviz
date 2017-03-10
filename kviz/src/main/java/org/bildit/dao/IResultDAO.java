package org.bildit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.dto.Result;

public interface IResultDAO {
	
	public ArrayList<Result> getResult(String name) throws SQLException;
	
	public boolean addResult(Result result) throws SQLException;
	
	public ArrayList<Result> topNScore(int n) throws SQLException;
}
