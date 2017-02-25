package org.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bildit.DTO.Question;

public class QuestionAndAnswerDAO implements IQuestionAndAnswerDAO {
	
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public Question getQuestion(int ID) throws SQLException {

		Question question = null;
		
		String query = "SELECT * FROM kviz.questionAndAnswer WHERE questionAndAnswer.ID = ?";
		
		ResultSet rs = null;
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, ID);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				question = new Question(rs.getInt("ID"),rs.getString("question"),rs.getString("offeredAnswers"),rs.getString("correctAnswer").charAt(0));
			}
			
			rs.close();
		}
		return question;
		
	}

	@Override
	public boolean addQuestion(Question question) throws SQLException {

		String query = "INSERT INTO kviz.questionAndAnswer (question, offeredAnswers, correctAnswer) VALUES (?, ?, ?)";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, question.getQuestion());
			ps.setString(2, question.getOfferedAnswers());
			ps.setString(3, question.getCorrectAnswer()+"");
			
			ps.executeUpdate();
			
		}
		return true;
	}

	@Override
	public boolean updateQuestion(Question question, String newQuestion) throws SQLException {
		
		String query = "UPDATE kviz.questionAndAnswer SET question = ? WHERE questionAndAnswer.ID = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, newQuestion);
			ps.setInt(2, question.getID());
			ps.executeUpdate();
	
			return true;
		}
	}
	
	@Override
	public boolean updateAnswer(Question question, String offeredAnswers, char correctAnswer) throws SQLException {
		
		String query = "UPDATE kviz.questionAndAnswer SET offeredAnswers = ?, correctAnswer WHERE questionAndAnswer.ID = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, offeredAnswers);
			ps.setString(2, correctAnswer+"");
			ps.setInt(3, question.getID());
			ps.executeUpdate();
	
			return true;
		}
	}

	@Override
	public boolean deleteQuestion(int ID) throws SQLException {
		
		String query = "DELETE FROM kviz.questionAndAnswer WHERE ID = ?";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, ID);
			ps.executeUpdate();
			
			return true;
		}
	}

}
