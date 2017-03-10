package org.bildit.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.bildit.bo.ResultBO;
import org.bildit.dto.Result;

public class ResultInteraction {
	
	static Scanner input = new Scanner(System.in);
	final static int n = 100;
	ResultBO resultBO = new ResultBO();
	Result result;
	ArrayList<Result> results;
	
	public void getResultI(String userName) throws SQLException{
		
		results = resultBO.getResultBO(userName);
		if(results.isEmpty()) {
			System.out.println("Nema dosad odigranih partija");
		}
		else {
			printsResults();
		}
	}
	
	public void addresultI(String userName, int points) throws SQLException {
		result = new Result(userName, points);
		resultBO.addResultBO(result);
		
	}
	
	public void top100() throws SQLException{
		
		results = resultBO.topNScoreBO(n);
		if(results.isEmpty()) {
			System.out.println("Nema dosad odigranih partija");
		}
		else {
			printsResults();
		}
	}
	
	public void printsResults() {
		
		for (Result result: results) {
			System.out.println(result);
		}
	}
}
