package org.bildit.BO.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

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
	public void getAdminBOShouldReturnNullWhenNameIsEmpty() throws SQLException {
		
		Admin result = adminBO.getAdminBO(emptyAdmin.getName(), emptyAdmin.getPassword());
		
		assertNull(result);
	}
	
	@Test
	public void getAdminBOShouldReturnNullWhenPasswordIsEmpty() throws SQLException {
		
		Admin result = adminBO.getAdminBO(emptyAdmin.getName(),emptyAdmin.getPassword());
		
		assertNull(result);
	}
	
	@Test
	public void getAdminBOShouldReturnNullWhenPasswordNotMatch() throws SQLException {
		
		Mockito.when(mockAdminDAO.getAdmin(validAdmin.getName())).thenReturn(validAdmin);
		
		Admin result = adminBO.getAdminBO(validAdmin.getName(), "sifra");
		
		assertNull(result);
		
		Mockito.verify(mockAdminDAO).getAdmin(validAdmin.getName());
	}

	@Test
	public void getAdminBOShouldReturnNotNullWhenPasswordMatch() throws SQLException {
		
		Mockito.when(mockAdminDAO.getAdmin(validAdmin.getName())).thenReturn(validAdmin);
		
		Admin result = adminBO.getAdminBO(validAdmin.getName(), validAdmin.getPassword());
		
		assertNotNull(result);
		
		Mockito.verify(mockAdminDAO).getAdmin(validAdmin.getName());
	}
	
	@Test
	public void addAdminBOShouldReturnFalseWhenNameIsEmpty() throws SQLException {
		
		boolean result = adminBO.addAdminBO(emptyAdmin.getName(), emptyAdmin.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void addAdminBOShouldReturnFalseWhenPasswordIsEmpty() throws SQLException {
		
		boolean result = adminBO.addAdminBO(emptyAdmin.getName(), emptyAdmin.getPassword());
		
		assertFalse(result);	
	}
	
	@Test
	public void addAdminBOShouldReturnFalseWhenReturnedAdminIsNotNull() throws SQLException{
		
		Mockito.when(mockAdminDAO.getAdmin(validAdmin.getName())).thenReturn(validAdmin);
		
		boolean result = adminBO.addAdminBO(validAdmin.getName(), validAdmin.getPassword());
		
		assertFalse(result);
		
		Mockito.verify(mockAdminDAO).getAdmin(validAdmin.getName());
		
	}
	
	@Test
	public void addAdminBOShouldReturnTrueWhenDaoAddMethodIsCalled() throws SQLException{
		
		Mockito.when(mockAdminDAO.addAdmin(validAdmin.getName(), validAdmin.getPassword())).thenReturn(true);
		
		boolean result = adminBO.addAdminBO(validAdmin.getName(), validAdmin.getPassword());
		
		assertTrue(result);
		
		Mockito.verify(mockAdminDAO).addAdmin(validAdmin.getName(), validAdmin.getPassword());
	}
	
	@Test
	public void updateAdminBOShouldReturnFalseWhenAdminIsNull() throws SQLException {
		
		boolean result = adminBO.updateAdminBO(null,validAdmin.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void updateAdminBOShouldReturnFalseWhenPasswordIsEmpty() throws SQLException {
		
		boolean result = adminBO.updateAdminBO(validAdmin, emptyAdmin.getName());
		
		assertFalse(result);
	}
	
	@Test
	public void updateAdminBOShouldReturnTrueWhenDAOupdateMetodIsCalled() throws SQLException {
		
		Mockito.when(mockAdminDAO.updateAdmin(validAdmin, validAdmin.getPassword())).thenReturn(true);
		
		boolean result = adminBO.updateAdminBO(validAdmin, validAdmin.getPassword());
		
		assertTrue(result);
		
		Mockito.verify(mockAdminDAO).updateAdmin(validAdmin, validAdmin.getPassword());
	}	
	

}
