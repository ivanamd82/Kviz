package org.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.DTO.Result;

public class ResultDAO implements IResultDAO {
	
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public Result getResult(String name) throws SQLException {
		
		Result result = null;
		String query = "SELECT * FROM kviz.result WHERE result.ID = ?";
		
		ResultSet rs = null;
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new Result(rs.getInt("ID"),rs.getString("nameUser"),rs.getInt("score"),rs.getTimestamp("date"));
			}
			
			rs.close();
		}
		return result;
	}

	@Override
	public boolean addResult(Result result) throws SQLException {
		
		String query = "INSERT INTO kviz.result (nameUser, score, date) VALUES (?, ?, ?)";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, result.getNameUser() );
			ps.setInt(2, result.getScore());
			ps.setTimestamp(3, result.getDate());
			
			ps.executeUpdate();
			
		}
		return true;
	}
	
	public ArrayList<Result> topNScore(int n) throws SQLException {
		
		ArrayList<Result> topN = new ArrayList<Result>();
		
		String query = "SELECT * FROM kviz.result ORDER BY 'score' limit = ?";
		
		ResultSet rs = null;
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			
			ps.setInt(1, n);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				topN.add(new Result(rs.getInt("ID"),rs.getString("nameUser"),rs.getInt("score"),rs.getTimestamp("date")));
			}
			rs.close();
		}
		return topN;
	}

}
