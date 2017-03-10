package org.bildit.view;

import java.util.Scanner;

import org.bildit.dto.Person;

public class PersonInteraction {
	
	static Scanner input = new Scanner(System.in);
	Person person;
	
	public Person loginInput() {
		
		System.out.println("Unesite korisnicko ime: ");
		String userName = input.next();
		System.out.print("Unesite sifru: ");
		String userPassword = input.next();
		
		this.person = new Person(userName, userPassword);
		
		return person;
	}
	
	public String newPassword() {
		
		String newPassword;
		
		System.out.print("Unesite novu sifru: ");
		newPassword = input.next();
		
		return newPassword;
	}

}
