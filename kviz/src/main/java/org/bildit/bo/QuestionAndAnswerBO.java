package org.bildit.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bildit.dao.QuestionAndAnswerDAO;
import org.bildit.dto.Question;


public class QuestionAndAnswerBO {
	
	QuestionAndAnswerDAO questionDAO = new QuestionAndAnswerDAO();
	Question question= null;
	ArrayList<Question> list = null;
	
	public Question getQuestionBO(int ID) throws SQLException {
		
		if(ID == 0) {
			return null;
		}
		else {
			question = questionDAO.getQuestion(ID);
			return question;
		}
	}
	
	public ArrayList<Question> listOfQuestions() throws SQLException {
		
		list = questionDAO.listOfQuestions();
		return list;
	}
	
	public boolean addQuestionBO(Question question) throws SQLException {
		
		if (question == null) {
			return false;
		}
		else {
			if (question.getQuestion() == "" || question.getOfferedAnswers() == "" || question.getCorrectAnswer() == '\u0000') {
				return false;
			}
			else {
				return questionDAO.addQuestion(question);
			}
		}		
		
	}

	public boolean updateQuestionBO(int ID, String newQuestion) throws SQLException {
		
		if (ID == 0 || newQuestion == "") {
			return false;
		}
		else {
			return questionDAO.updateQuestion(ID, newQuestion);
		}
		
	}

	public boolean updateAnswerBO(int ID, String offeredAnswers, char correctAnswer) throws SQLException {
		
		if (ID == 0 || offeredAnswers == "" || correctAnswer == '\u0000') {
			return false;
		}
		else {
			return questionDAO.updateAnswer(ID, offeredAnswers, correctAnswer);
		}
		
	}

	public boolean deleteQuestionBO(int ID) throws SQLException {
		
		if(ID == 0) {
			return false;
		}
		else {		
			return questionDAO.deleteQuestion(ID);
		}
	}	

	public void setQuestionDAO (QuestionAndAnswerDAO questionDAO) {
		
		this.questionDAO = questionDAO;		
	}

}
