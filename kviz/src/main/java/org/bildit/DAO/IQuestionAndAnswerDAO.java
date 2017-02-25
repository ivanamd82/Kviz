package org.bildit.DAO;

import java.sql.SQLException;

import org.bildit.DTO.Question;

public interface IQuestionAndAnswerDAO {
	
	public Question getQuestion(int ID) throws SQLException;
	
	public boolean addQuestion(Question question) throws SQLException;
	
	public boolean updateQuestion(Question question, String newQuestion) throws SQLException;
	
	public boolean updateAnswer(Question question, String offeredAnswers, char correctAnswer) throws SQLException;
	
	public boolean deleteQuestion(int ID) throws SQLException;

}
