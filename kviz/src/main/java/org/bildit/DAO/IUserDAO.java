package org.bildit.DAO;

import java.sql.SQLException;

import org.bildit.DTO.User;


public interface IUserDAO {
	
	public User getUser(String name) throws SQLException; 
	
	public boolean addUser(String name, String password) throws SQLException;
	
	public boolean updateUser(User user, String password) throws SQLException;	


}
