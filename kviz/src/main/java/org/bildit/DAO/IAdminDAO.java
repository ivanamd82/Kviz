package org.bildit.DAO;

import java.sql.SQLException;

import org.bildit.DTO.Admin;


public interface IAdminDAO {
	
	public Admin getAdmin(String name) throws SQLException; 
	
	public boolean addAdmin(String name, String password) throws SQLException;
	
	public boolean updateAdmin(Admin user, String password) throws SQLException;	

}
