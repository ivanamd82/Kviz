package org.bildit.BO;

import java.sql.SQLException;

import org.bildit.DAO.UserDAO;
import org.bildit.DTO.User;

public class UserBO {	
	
	UserDAO userDAO = new UserDAO();
	User user = null;


	public User getUserBO(String name, String password) throws SQLException {

		if (name == "" || password == "") {
			return null;
		}
		else {
			user = userDAO.getUser(name);
		
			if(!user.getPassword().equals(password)) {
				return null;
			}
			else {		
				return user;
			}
		}
	}

	public boolean addUserBO(String name, String password) throws SQLException {
		
		if (name == "" || password == "") {
			return false;
		}
		else {
			User user = userDAO.getUser(name);
			if (user != null) {
				return false;
			}
			else {
				return userDAO.addUser(name, password);
			}
		}		
	}

	public boolean updateUserBO(User user, String password) throws SQLException {
		
		if (user == null) {
			return false;
		} else {
			if (password == "") {	
				return false;
			}
			else {
				user.setPassword(password);
				return userDAO.updateUser(user, password);
			}
		}
	
	}

	public boolean deleteUseBO(String name) throws SQLException {
		
		if (name == "") {
			return false;
		}
		else {
			return userDAO.deleteUser(name);
			
		}
	}
	
	public void setUserDAO(UserDAO userDAO) {
		
		this.userDAO = userDAO;		
	}

}
