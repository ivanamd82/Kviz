package org.bildit.DTO;

public class Question {
	
	private int ID;
	private String question;
	private String offeredAnswers;
	private char correctAnswer;
	
	public Question() {
		
	}
	public Question(String question, String offeredAnswers, char correctAnswe) {
		this.question = question;
		this.offeredAnswers = offeredAnswers;
		this.correctAnswer = correctAnswe;
	}

	public Question(int ID, String question, String offeredAnswers, char correctAnswe) {
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

	public char getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(char correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	@Override
	public String toString() {
		return "ID: "+ ID + " Pitanje: "+ question + "\nPonudjeni odgovori: "+ offeredAnswers + "\nTacan odgovor: "+correctAnswer;
	}
	
	public String printQuestion() {
		return question+"\n"+offeredAnswers+"\n";
	}
	
}
