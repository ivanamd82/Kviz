package org.bildit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.dto.Result;

public class ResultDAO implements IResultDAO {
	
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public ArrayList<Result> getResult(String name) throws SQLException {
		
		ArrayList<Result> results = new ArrayList<Result>();
		
		String query = "SELECT * FROM kviz.result WHERE result.nameOfUser = ?";
		
		ResultSet rs = null;
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				results.add(new Result(rs.getInt("ID"),rs.getString("nameOfUser"),rs.getInt("score"),rs.getTimestamp("date")));
			}
			
			rs.close();
		}
		return results;
	}

	@Override
	public boolean addResult(Result result) throws SQLException {
		
		String query = "INSERT INTO kviz.result (nameOfUser, score, date) VALUES (?, ?, ?)";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, result.getNameUser() );
			ps.setInt(2, result.getScore());
			ps.setTimestamp(3, result.getDate());
			
			ps.executeUpdate();
			
		}
		return true;
	}
	
	public ArrayList<Result> topNScore(int n) throws SQLException {
		
		ArrayList<Result> results = new ArrayList<Result>();
		
		String query = "SELECT * FROM kviz.result ORDER BY score DESC LIMIT ?";
		
		ResultSet rs = null;
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			
			ps.setInt(1, n);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				results.add(new Result(rs.getInt("ID"),rs.getString("nameOfUser"),rs.getInt("score"),rs.getTimestamp("date")));
			}
			rs.close();
		}
		return results;
	}

}
