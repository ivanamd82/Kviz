package org.bildit.BO.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.bo.ResultBO;
import org.bildit.dao.ResultDAO;
import org.bildit.dto.Result;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ResultBOTest {
	
	ResultBO resultBO;
	ResultDAO mockResultDAO;
	String empty;
	Result validResult;
	Result emptyResult;
	ArrayList<Result> list;

	@Before
	public void setUp() throws Exception {
		
		resultBO = new ResultBO();
		mockResultDAO = Mockito.mock(ResultDAO.class);
		resultBO.setResultDAO(mockResultDAO);
		validResult = new Result("igrac",200);
		emptyResult = new Result("",0);
		list = new ArrayList<>();
	}

	@Test
	public void getScoreBOShouldReturnNullWhenNameIsEmpty() throws SQLException {
		
		ArrayList<Result> result = resultBO.topNScoreBO(0);
				
		assertNull(result);
	}
	
	@Test
	public void getResultBOShouldReturnResultWhenDAOgetMethodIsCalled() throws SQLException {
		
		list.add(validResult);
		
		Mockito.when(mockResultDAO.getResult(validResult.getNameUser())).thenReturn(list);		
			
		ArrayList<Result> result = resultBO.getResultBO(validResult.getNameUser());
		
		assertSame(list, result);
		
		Mockito.verify(mockResultDAO).getResult(validResult.getNameUser());
	}
	
	@Test
	public void addResultShouldReturnFalseWhenResultIsNull() throws SQLException {
		
		boolean result = resultBO.addResultBO(null);
		
		assertFalse(result);
	}
	
	@Test
	public void addResultShouldReturnFalseWhenUserNameIsEmpty() throws SQLException {
		
		boolean result = resultBO.addResultBO(emptyResult);
		
		assertFalse(result);
		
	}
	
	@Test
	public void addResultShouldReturnTrueWhenDAoaddMethodIsCalled() throws SQLException {
		
		Mockito.when(mockResultDAO.addResult(validResult)).thenReturn(true);
		
		boolean result = resultBO.addResultBO(validResult);
		
		assertTrue(result);
		Mockito.verify(mockResultDAO).addResult(validResult);
	}
	
	@Test
	public void topNScoreShouldReturnNullWhenNisZwero() throws SQLException {
		
		ArrayList<Result> result = resultBO.topNScoreBO(0);
		assertNull(result);
	}
	
	@Test
	public void topNScoreShouldReturnListWhenDaoMethod() throws SQLException {
		
		list.add(validResult);
		
		Mockito.when(mockResultDAO.topNScore(1)).thenReturn(list);
		
		ArrayList<Result> result = resultBO.topNScoreBO(1);
		
		assertSame(list.get(0), result.get(0));
		
		Mockito.verify(mockResultDAO).topNScore(1);
	}
}
