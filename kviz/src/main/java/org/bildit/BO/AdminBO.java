package org.bildit.BO;

import java.sql.SQLException;

import org.bildit.DAO.AdminDAO;
import org.bildit.DTO.Admin;

public class AdminBO {
	
	AdminDAO adminDAO = new AdminDAO();
	Admin admin = null;
	
	public Admin getAdminBO(String name, String password) throws SQLException {
		
		if(name == "" || password == "") {
			return null;
		}
		else {
			admin = adminDAO.getAdmin(name);
		
			if(!admin.getPassword().equals(password)) {
				return null;
			}
			else {		
				return admin;
			}
		}

	}
	
	public boolean addAdminBO(String name, String password) throws SQLException {

		if (name == "" || password == "") {
			return false;
		}
		else {
			Admin admin = adminDAO.getAdmin(name);
			if (admin != null) {
				return false;
			}
			else {
				return adminDAO.addAdmin(name, password);
			}
		}		
	}
	
	public boolean updateAdminBO(Admin admin, String password) throws SQLException {
		
		if (admin == null) {
			return false;
		} else {
			if (password == "") {	
				return false;
			}
			else {
				admin.setPassword(password);
				return adminDAO.updateAdmin(admin, password);
			}
		}
	}	
	
	public void setAdminDAO(AdminDAO adminDAO) {
		
		this.adminDAO = adminDAO;		
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


}
