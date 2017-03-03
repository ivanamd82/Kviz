package org.bildit.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.bildit.BO.QuestionAndAnswerBO;
import org.bildit.DTO.Question;

public class Game {
	
	static Scanner input = new Scanner(System.in);
	int numberOfQuestion = 10;
	int points = 0;
	ArrayList<Question> listOfQuestion;	
	
	QuestionAndAnswerBO questionBO = new QuestionAndAnswerBO();
	
	private void loadList() throws SQLException {
		
		this.listOfQuestion = questionBO.listOfQuestions();
		Collections.shuffle(listOfQuestion);
	}
	
	public void game() throws SQLException {
		
		loadList();
		
		if(numberOfQuestion > listOfQuestion.size()) {
			numberOfQuestion = listOfQuestion.size();
		}
		
		for(int i = 0; i < numberOfQuestion; i++) {
			System.out.println(listOfQuestion.get(i).printQuestion());	
			System.out.println("Tacan odgovor: ");
			char answer = input.next().charAt(0);
			if (isCorrect(listOfQuestion.get(i).getCorrectAnswer(),answer)) {
				System.out.println("Tacan odgovor");
				points++;
			}
			else {
				System.out.println("Pogresan odgovor");
			}
		}
	}
	
	private boolean isCorrect(char correctAnswer, char answer) {
		return (correctAnswer == answer) ? true : false;
	}
	
		
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public ArrayList<Question> getListOfQuestion() {
		return listOfQuestion;
	}

	public void setListOfQuestion(ArrayList<Question> listOfQuestion) {
		this.listOfQuestion = listOfQuestion;
	}
}
