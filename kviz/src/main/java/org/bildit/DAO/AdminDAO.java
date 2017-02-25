package org.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bildit.DTO.Admin;

public class AdminDAO implements IAdminDAO {
	
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public Admin getAdmin(String name) throws SQLException {
		
		Admin admin = null;
		
		String query = "SELECT * FROM kviz.admin WHERE admin.name = ?";
		
		ResultSet rs = null;
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				admin = new Admin(rs.getString("name"), rs.getString("password"));
			}
			
			rs.close();
		}
		return admin;
	}

	@Override
	public boolean addAdmin(String name, String password) throws SQLException {
		
		String query = "INSERT INTO kviz.admin (name,password) VALUES (?, ?)";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, name);
			ps.setString(2, password);
			
			ps.executeUpdate();
			
		}
		return true;
	}

	@Override
	public boolean updateAdmin(Admin admin, String password) throws SQLException {
		
		String query = "UPDATE kviz.admin SET password = ? WHERE admin.name = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, password);
			ps.setString(2, admin.getName());
			ps.executeUpdate();
	
			return true;
		}
	}
	
}
