package org.bildit.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.DTO.Question;

public interface IQuestionAndAnswerDAO {
	
	public Question getQuestion(int ID) throws SQLException;
	
	public ArrayList<Question> listOfQuestions() throws SQLException;
	
	public boolean addQuestion(Question question) throws SQLException;
	
	public boolean updateQuestion(int ID, String newQuestion) throws SQLException;
	
	public boolean updateAnswer(int ID, String offeredAnswers, char correctAnswer) throws SQLException;
	
	public boolean deleteQuestion(int ID) throws SQLException;

}
