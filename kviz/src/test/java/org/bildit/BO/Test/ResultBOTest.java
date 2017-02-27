package org.bildit.BO.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.BO.ResultBO;
import org.bildit.DAO.ResultDAO;
import org.bildit.DTO.Result;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ResultBOTest {
	
	ResultBO resultBO;
	ResultDAO mockResultDAO;
	String empty;
	Result validResult;
	Result emptyResult;
	ArrayList<Result> top;

	@Before
	public void setUp() throws Exception {
		
		resultBO = new ResultBO();
		mockResultDAO = Mockito.mock(ResultDAO.class);
		resultBO.setResultDAO(mockResultDAO);
		validResult = new Result("igrac",200);
		emptyResult = new Result("",0);
	}

	@Test
	public void getScoreBOShouldReturnNullWhenNameIsEmpty() throws SQLException {
		
		Result result = resultBO.getResultBO(emptyResult.getNameUser());
		
		assertNull(result);
	}
	
	@Test
	public void getResultBOShouldReturnResultWhenDAOgetMethodIsCalled() throws SQLException {
		
		Mockito.when(mockResultDAO.getResult(validResult.getNameUser())).thenReturn(validResult);
		
		Result result = resultBO.getResultBO(validResult.getNameUser());
		
		assertSame(validResult, result);
		
		Mockito.verify(mockResultDAO).getResult(validResult.getNameUser());
	}
	
	@Test
	public void addResultShouldReturnFalseWhenResultIsNull() throws SQLException {
		
		boolean result = resultBO.addResult(null);
		
		assertFalse(result);
	}
	
	@Test
	public void addResultShouldReturnFalseWhenUserNameIsEmpty() throws SQLException {
		
		boolean result = resultBO.addResult(emptyResult);
		
		assertFalse(result);
		
	}
	
	@Test
	public void addResultShouldReturnTrueWhenDAoaddMethodIsCalled() throws SQLException {
		
		Mockito.when(mockResultDAO.addResult(validResult)).thenReturn(true);
		
		boolean result = resultBO.addResult(validResult);
		
		assertTrue(result);
	}
	
	@Test
	public void topNScoreShouldReturnNullWhenNisZwero() throws SQLException {
		
		ArrayList<Result> result = resultBO.topNScoreBO(0);
		assertNull(result);
	}
	
	@Test
	public void topNScoreShouldReturnListWhenDaoMethod() throws SQLException {
		
		top = new ArrayList<>();
		top.add(validResult);
		
		Mockito.when(mockResultDAO.topNScore(1)).thenReturn(top);
		
		ArrayList<Result> result = resultBO.topNScoreBO(1);
		assertSame(top.get(0), result.get(0));
	}
}
