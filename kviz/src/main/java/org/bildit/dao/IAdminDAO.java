package org.bildit.dao;

import java.sql.SQLException;

import org.bildit.dto.Admin;


public interface IAdminDAO {
	
	public Admin getAdmin(String name) throws SQLException; 
	
	public boolean addAdmin(String name, String password) throws SQLException;
	
	public boolean updateAdmin(Admin user, String password) throws SQLException;	

}
