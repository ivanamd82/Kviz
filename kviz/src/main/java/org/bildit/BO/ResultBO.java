package org.bildit.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.DAO.ResultDAO;
import org.bildit.DTO.Result;

public class ResultBO {
	
	ResultDAO resultDAO = new ResultDAO();
	Result result = null;
	ArrayList<Result> topN;
	
	public Result getResultBO(String nameUser) throws SQLException {
		
		if (nameUser == "") {
			return null;
		}
		else {
			return resultDAO.getResult(nameUser);
		}
	}

	public boolean addResult(Result result) throws SQLException {
		
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
		
		topN = new ArrayList<>();
		
		if (n == 0) {
			return null;
		}
		else {
			topN = resultDAO.topNScore(n);
			return topN;
		}
		
	}
	
	public void setResultDAO(ResultDAO resultDAO) {
		this.resultDAO = resultDAO;
		
	}

}
