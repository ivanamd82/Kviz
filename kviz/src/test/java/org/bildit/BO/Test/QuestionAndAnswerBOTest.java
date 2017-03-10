package org.bildit.BO.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.bo.QuestionAndAnswerBO;
import org.bildit.dao.QuestionAndAnswerDAO;
import org.bildit.dto.Question;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class QuestionAndAnswerBOTest {
	
	QuestionAndAnswerBO questionBO;
	QuestionAndAnswerDAO mockQuestionDAO;
	int zero;
	Question validQuestion;
	Question emptyQuestion;
	ArrayList<Question> list;
	
	@Before
	public void setUp() {
		
		questionBO = new QuestionAndAnswerBO();
		mockQuestionDAO = Mockito.mock(QuestionAndAnswerDAO.class);
		questionBO.setQuestionDAO(mockQuestionDAO);		
		zero = 0;
		validQuestion = new Question(1, "Pitanje?", "a) prvi b) drugi", 'a');
		emptyQuestion = new Question(0, "", "", '\u0000');
		list = new ArrayList<>();
	}

	@Test
	public void getQuestionBOShouldReturnNullWhenIDIsZero() throws SQLException{
		
		Question result = questionBO.getQuestionBO(zero);
		
		assertNull(result);
	}
	
	@Test
	public void getQuestionBOShouldReturnNotNullWhenDAOgetMethodIsCalled() throws SQLException {
		
		Mockito.when(mockQuestionDAO.getQuestion(validQuestion.getID())).thenReturn(validQuestion);
		
		Question result = questionBO.getQuestionBO(validQuestion.getID());
		
		assertSame(validQuestion, result);
		
		Mockito.verify(mockQuestionDAO).getQuestion(validQuestion.getID());
		
	}
	@Test
	public void listOfQuestionsBOShouldReturnListWhenDaoMethodIsCalled() throws SQLException {
		
		list.add(validQuestion);
		
		Mockito.when(mockQuestionDAO.listOfQuestions()).thenReturn(list);
		
		ArrayList<Question> result = questionBO.listOfQuestions();
		
		assertSame(list, result);
		
		Mockito.verify(mockQuestionDAO).listOfQuestions();
	}

	@Test
	public void addQuestionBOShouldReturnFalseWhenQuestionIsNull() throws SQLException {
		
		boolean result = questionBO.addQuestionBO(null);
		
		assertFalse(result);
	}
	
	@Test
	public void addQuestionBOShouldReturnFalseWhenQuestionIsEmpty() throws SQLException {
		
		boolean result = questionBO.addQuestionBO(emptyQuestion);	
		
		assertFalse(result);
	}
	
	@Test
	public void addQuestionBOShouldReturnFalseWhenOfferedAnswerIsEmpty() throws SQLException {
		
		boolean result = questionBO.addQuestionBO(emptyQuestion);	
		
		assertFalse(result);
	}
	
	@Test
	public void addQuestionBOShouldReturnFalseWhenCorrectAnswerIsEmpty() throws SQLException {
		
		boolean result = questionBO.addQuestionBO(emptyQuestion);	
		
		assertFalse(result);
	}
	
	@Test
	public void addQuestionBOShouldReturnTrueWhenDAOaddMethodIsCalled() throws SQLException {
		
		Mockito.when(mockQuestionDAO.addQuestion(validQuestion)).thenReturn(true);
		
		boolean result = questionBO.addQuestionBO(validQuestion);
		
		assertTrue(result);
		
		Mockito.verify(mockQuestionDAO).addQuestion(validQuestion);
		
	}
	
	@Test
	public void updateQuestionBOShouldReturnFalseWhenIDIsZero() throws SQLException {
		
		boolean result = questionBO.updateQuestionBO(emptyQuestion.getID(), emptyQuestion.getQuestion());
		
		assertFalse(result);
	}
	
	@Test
	public void updateQuestionBOShouldReturnFalseWhenNewQuestionIsEmpty() throws SQLException {
		
		boolean result = questionBO.updateQuestionBO(emptyQuestion.getID(), emptyQuestion.getQuestion());
		
		assertFalse(result);
	}
	
	@Test
	public void updateQuestionBOShouldReturnTrueWhenDAOupdateMethodIsCalled() throws SQLException {
		
		Mockito.when(mockQuestionDAO.updateQuestion(validQuestion.getID(), validQuestion.getQuestion())).thenReturn(true);
		
		boolean result = questionBO.updateQuestionBO(validQuestion.getID(), validQuestion.getQuestion());
		
		assertTrue(result);
		
		Mockito.verify(mockQuestionDAO).updateQuestion(validQuestion.getID(), validQuestion.getQuestion());
	}
	
	@Test
	public void updateAnswerBOShouldReturnFalseWhenIDIsZero() throws SQLException {
		
		boolean result = questionBO.updateAnswerBO(emptyQuestion.getID(), emptyQuestion.getOfferedAnswers(), emptyQuestion.getCorrectAnswer());
		
		assertFalse(result);
	}
	
	@Test
	public void updateAnswerBOShouldReturnFalseWhenNewOfferedAnswerIsEmpty() throws SQLException {
		
		boolean result = questionBO.updateAnswerBO(emptyQuestion.getID(), emptyQuestion.getOfferedAnswers(), emptyQuestion.getCorrectAnswer());
		
		assertFalse(result);
	}
	
	@Test
	public void updateAnswerBOShouldReturnFalseWhenNewCorrectAnswerIsEmpty() throws SQLException {
		
		boolean result = questionBO.updateAnswerBO(emptyQuestion.getID(), emptyQuestion.getOfferedAnswers(), emptyQuestion.getCorrectAnswer());
		
		assertFalse(result);
	}
	
	@Test
	public void updateAnswerBOShouldReturnTrueWhenDAOupdateMethodIsCalled() throws SQLException {
		
		Mockito.when(mockQuestionDAO.updateAnswer(validQuestion.getID(), validQuestion.getOfferedAnswers(),validQuestion.getCorrectAnswer())).thenReturn(true);
		
		boolean result = questionBO.updateAnswerBO(validQuestion.getID(), validQuestion.getOfferedAnswers(), validQuestion.getCorrectAnswer());
		
		assertTrue(result);
	}
	
	@Test
	public void deleteQuestionBOShouldReturnFalseWhenIDIsZero() throws SQLException {
		
		boolean result = questionBO.deleteQuestionBO(zero);
		
		assertFalse(result);		
	}
	
	@Test
	public void deleteQuestionBOShouldReturnTrueWhenDaoDeleteMetodIsCalled() throws SQLException {
		
		Mockito.when(mockQuestionDAO.deleteQuestion(validQuestion.getID())).thenReturn(true);
		
		boolean result = questionBO.deleteQuestionBO(validQuestion.getID());
		
		assertTrue(result);
		
		Mockito.verify(mockQuestionDAO).deleteQuestion(validQuestion.getID());
	}	
	
}
