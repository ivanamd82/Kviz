package org.bildit.BO.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.bildit.bo.UserBO;
import org.bildit.dao.UserDAO;
import org.bildit.dto.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserBOTest {
	
	
	UserBO userBO;
	UserDAO mockUserDAO;
	User emptyUser;
	User validUser;
	
	@Before
	public void setUp() {
		
		userBO = new UserBO();
		mockUserDAO = Mockito.mock(UserDAO.class);
		userBO.setUserDAO(mockUserDAO);
		emptyUser = new User("","");
		validUser = new User("name","password");
	}

	@Test
	public void getUserBOShouldReturnNullWhenNameIsEmpty() throws SQLException {
		
		User result = userBO.getUserBO(emptyUser.getName(),emptyUser.getPassword());
		
		assertNull(result);		
	}
	
	@Test
	public void getUserBOShouldReturnNullWhenPasswordIsEmpty() throws SQLException {
		
		User result = userBO.getUserBO(emptyUser.getName(), emptyUser.getPassword());
		
		assertNull(result);
	}
	
	@Test
	public void getUserBOShouldReturnNullWhenPasswordNotMatch() throws SQLException {
		
		Mockito.when(mockUserDAO.getUser(validUser.getName())).thenReturn(validUser);
		
		User result = userBO.getUserBO(validUser.getName(), "sifra");
		
		assertNull(result);
		
		Mockito.verify(mockUserDAO).getUser(validUser.getName());
	}
	
	@Test
	public void getUserBOShouldReturnNotNullWhenPasswordMatch() throws SQLException {
		
		Mockito.when(mockUserDAO.getUser(validUser.getName())).thenReturn(validUser);
		
		User result = userBO.getUserBO(validUser.getName(),validUser.getPassword());
		
		assertSame(validUser, result);
		
		Mockito.verify(mockUserDAO).getUser(validUser.getName());
	}
	
	@Test
	public void addUserBOShouldReturnFalseWhenNameIsEmpty() throws SQLException {
		
		boolean result = userBO.addUserBO(emptyUser.getName(), emptyUser.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void addUserBOShouldReturnFalseWhenPasswordIsEmpty() throws SQLException {
		
		boolean result = userBO.addUserBO(emptyUser.getName(), emptyUser.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void addUserBOShouldReturnFalseWhenUserIsNotNull() throws SQLException {
		
		Mockito.when(mockUserDAO.getUser(validUser.getName())).thenReturn(validUser);
		
		boolean result = userBO.addUserBO(validUser.getName(), validUser.getPassword());
		
		assertFalse(result);
		
		Mockito.verify(mockUserDAO).getUser(validUser.getName());
	}
	
	@Test
	public void addUserBOShouldReturnTrueWhenDAOaddMethodIsCalled() throws SQLException {
		
		Mockito.when(mockUserDAO.addUser(validUser.getName(), validUser.getPassword())).thenReturn(true);
		
		boolean result = userBO.addUserBO(validUser.getName(), validUser.getPassword());
		
		assertTrue(result);
		
		Mockito.verify(mockUserDAO).addUser(validUser.getName(), validUser.getPassword());
	}
	
	@Test
	public void updateUserBOShouldReturnFalseWhenUserIsNull() throws SQLException {
		
		boolean result = userBO.updateUserBO(null,validUser.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void updateUserBOShouldReturnFalseWhenPasswordIsEmpty() throws SQLException {
		
		boolean result = userBO.updateUserBO(validUser,emptyUser.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void updateUserBOShouldReturnTrueWhenDAOupdateMetodIsCalled() throws SQLException {
	
		Mockito.when(mockUserDAO.updateUser(validUser, validUser.getPassword())).thenReturn(true);
		
		boolean result = userBO.updateUserBO(validUser, validUser.getPassword());
		
		assertTrue(result);
		
		Mockito.verify(mockUserDAO).updateUser(validUser, validUser.getPassword());
	}
	
	@Test
	public void deleteUserBOShouldReturnFalseWhenNameIsEmpty() throws SQLException {
		
		boolean result = userBO.deleteUseBO(emptyUser.getName());
		
		assertFalse(result);		
	}
	
	@Test
	public void deleteUserBOShouldReturnTrueWhenDAOdeleteMethodIsCalled() throws SQLException {
		
		Mockito.when(mockUserDAO.deleteUser(validUser.getName())).thenReturn(true);
		
		boolean result = userBO.deleteUseBO(validUser.getName());
		
		assertTrue(result);
		
		Mockito.verify(mockUserDAO).deleteUser(validUser.getName());
	}
}
