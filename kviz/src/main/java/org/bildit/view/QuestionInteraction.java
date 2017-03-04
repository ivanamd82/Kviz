package org.bildit.view;

import java.sql.SQLException;
import java.util.Scanner;

import org.bildit.BO.QuestionAndAnswerBO;
import org.bildit.DTO.Question;

public class QuestionInteraction {
	
	static Scanner input = new Scanner(System.in);
	QuestionAndAnswerBO questionBO = new QuestionAndAnswerBO();
	Question question;
	
	public void addNewQuestion() throws SQLException {

		System.out.println("Unesite pitanje: ");
 		String questionDesc = input.nextLine();
 		
		System.out.println("Unesite ponudjenje odgovore (a, b, c): ");
		String offeredAnswers = input.nextLine();
		
		System.out.println("Tacan odgovor: ");
		char correctAnswer = input.nextLine().charAt(0);
		
		question = new Question(questionDesc, offeredAnswers, correctAnswer);
		
		if (questionBO.addQuestionBO(question)) {
			System.out.println("Pitanje uspjesno dodano.");
		}
		else {
			System.out.println("Greska, molim vas pokusajte ponovo.");
		}
	}
	
	public void editQuestion() throws SQLException {
		
		System.out.println("ID pitanja: ");
		int ID = input.nextInt();
		input.nextLine();
		System.out.println(questionBO.getQuestionBO(ID).printQuestion());
		System.out.println("Unesite novo pitanje: ");
		String newQuestion = input.nextLine();
		if (questionBO.updateQuestionBO(ID, newQuestion)) {
			System.out.println("Pitanje uspjesno izmjenjeno.");
		}
		else {
			System.out.println("Greska, molim vas pokusajte ponovo.");
		}
		
	}
	
	public void editAnswer() throws SQLException {
		
		System.out.println("ID pitanja: ");
		int ID = input.nextInt();
		input.nextLine();
		System.out.println(questionBO.getQuestionBO(ID));
		System.out.println("Unesite nove ponudjene odgovore: ");
		String offeredAnswers = input.nextLine();
		System.out.println("Unesite novi tacan odgovor: ");
		char correctAnswer = input.nextLine().charAt(0);
		if (questionBO.updateAnswerBO(ID, offeredAnswers, correctAnswer)) {
			System.out.println("Pitanje uspjesno izmjenjeno.");
		}
		else {
			System.out.println("Greska, molim vas pokusajte ponovo.");
		}
		
	}

}
