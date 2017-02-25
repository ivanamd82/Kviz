package org.bildit.BO;

import org.bildit.DAO.AdminDAO;

public class AdminBO {
	
	AdminDAO adminDAO = new AdminDAO();

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
		
	}

}
