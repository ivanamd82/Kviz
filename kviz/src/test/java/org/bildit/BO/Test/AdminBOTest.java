package org.bildit.BO.Test;

import static org.junit.Assert.fail;

import org.bildit.BO.AdminBO;
import org.bildit.DAO.AdminDAO;
import org.bildit.DTO.Admin;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AdminBOTest {
	
	AdminDAO mockAdminDAO;
	AdminBO adminBO;
	Admin emptyAdmin;
	Admin validAdmin;
	
	@Before
	public void setUp() {
		
		adminBO = new AdminBO();
		mockAdminDAO = Mockito.mock(AdminDAO.class);
		adminBO.setAdminDAO(mockAdminDAO);
		emptyAdmin = new Admin("","");
		validAdmin = new Admin("name","password");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
