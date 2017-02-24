package org.bildit.DAO;

import org.bildit.DTO.Question;

public interface IQuestionAndAnswerDAO {
	
	public Question getQuestion();
	
	public boolean addQuestion();
	
	public boolean updateQuestion();
	
	public boolean deleteQuestion();

}
