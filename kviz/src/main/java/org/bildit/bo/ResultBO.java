package org.bildit.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.dao.ResultDAO;
import org.bildit.dto.Result;

public class ResultBO {
	
	ResultDAO resultDAO = new ResultDAO();
	Result result = null;
	ArrayList<Result> list;
	
	public ArrayList<Result> getResultBO(String nameUser) throws SQLException {
		
		list = new ArrayList<>();
		
		if (nameUser == "") {
			return null;
		}
		else {
			list = resultDAO.getResult(nameUser);
			return list;
		}
	}

	public boolean addResultBO(Result result) throws SQLException {
		
		if (result == null) {
			return false;
		}
		else {
			if (result.getNameUser() == "") { 
				return false;
			}
			else {
				return resultDAO.addResult(result);
			}
		}
	}
	
	public ArrayList<Result> topNScoreBO(int n) throws SQLException {
		
		list = new ArrayList<>();
		
		if (n == 0) {
			return null;
		}
		else {
			list = resultDAO.topNScore(n);
			return list;
		}
		
	}
	
	public void setResultDAO(ResultDAO resultDAO) {
		this.resultDAO = resultDAO;
		
	}

}
