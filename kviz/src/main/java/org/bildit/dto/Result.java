package org.bildit.dto;

import java.sql.Timestamp;
import java.util.Date;

public class Result {
	
	private int ID;
	private String nameUser;
	private int score;
	private Timestamp date;
	
	public Result() {
		
	}
	
	public Result(String nameUser, int score) {		
		Date newDate = new Date();
		Timestamp stampDate = new Timestamp(newDate.getTime());
		this.nameUser = nameUser;
		this.score = score;
		this.date = stampDate;
	}
	
	public Result(int ID, String nameUser, int score, Timestamp date) {
		this.ID = ID;
		this.nameUser = nameUser;
		this.score = score;
		this.date = date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return ID + " " + nameUser + " " + score + " " + date;
	}
	
}
