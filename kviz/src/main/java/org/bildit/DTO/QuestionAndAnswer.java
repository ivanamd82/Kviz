package org.bildit.DTO;

public class QuestionAndAnswer {
	
	private int ID;
	private String question;
	private String offeredAnswers;
	private String correctAnswer;
	
	public QuestionAndAnswer() {
		
	}

	public QuestionAndAnswer(int ID, String question, String offeredAnswers, String correctAnswe) {
		this.ID = ID;
		this.question = question;
		this.offeredAnswers = offeredAnswers;
		this.correctAnswer = correctAnswe;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOfferedAnswers() {
		return offeredAnswers;
	}

	public void setOfferedAnswers(String offeredAnswers) {
		this.offeredAnswers = offeredAnswers;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	@Override
	public String toString() {
		return "ID: "+ ID + " Pitanje: "+ question + "\nPonudjeni odgovori: "+ offeredAnswers + "\nTacan odgovor: ";
	}
	
}
