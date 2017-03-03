package org.bildit.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.bildit.BO.UserBO;
import org.bildit.DTO.User;

public class UserInteraction {
	
	static Scanner input = new Scanner(System.in);
	
	User user;
	UserBO userBO = new UserBO();
	ResultInteraction resultI = new ResultInteraction();

	public User loginInput() {
		
		System.out.println("Unesite korisnicko ime: ");
		String userName = input.next();
		System.out.print("Unesite sifru: ");
		String userPassword = input.next();
		
		User user = new User(userName, userPassword);
		
		return user;
	}
	
	public User loginMainMenu() throws SQLException {
		
		this.user = loginInput();
		
		try {			
			this.user = userBO.getUserBO(user.getName(),user.getPassword());
			if(user == null) {
				System.out.println("Pogresna sifra!");
				return null;
			}
			else {
				System.out.println("Uspjesno ste ulogovali.");
				return user;
			}
		} catch (NullPointerException e) {
			System.out.println("Pogresno korisnicko ime ili baza prazna");
			return null;
		}
	}

	public void registracija() throws SQLException {

		User user = loginInput();
		
		if (userBO.addUserBO(user.getName(),user.getPassword())) {
			System.out.println("Uspjesno ste se registrovali.");
		}
		else {
			System.out.println("Pogresno korisnicko ime/ime je vec zauzeto");
		}				
	}

	public void printUserMenu(User user) throws SQLException {
		
		System.out.println("\nIzaberite opciju: \n"
				+ "1. Nova igra\n"
				+ "2. Izlistaj resultate prethocnih partija\n"
				+ "3. Top 100\n"
				+ "4. Promjena sifre\n"
				+ "5. Izlaz\n");	
		
		try {
			int izbor = input.nextInt();
			
			switch (izbor) {
			case 1: {
				game();
				break;
			}
			case 2: {
				listOfPreviousGames();
				break;
			}
			case 3: {
				topPlayer();
				break;
			}
			case 4: {
				changePassword();
				break;
			}
			case 5: {
				System.out.println("Pa-pa");				
				System.exit(0);	
			}
			default: throw new InputMismatchException("Pogresan unos.");
			}															
		} catch (InputMismatchException ex) {		
			System.out.println("Pogresan unos. Pokusajte ponovo: ");			
			input.nextLine();	
		}		
		
	}

	private void game() throws SQLException {
		
		Game kviz = new Game();
		kviz.game();
		resultI.addresultI(user.getName(),kviz.getPoints());
		
		
	}

	private void listOfPreviousGames() throws SQLException {
		
		resultI.getResultI(user.getName());
		
	}

	private void topPlayer() throws SQLException {
		
		resultI.top100();
	}

	private void changePassword() {
		
		System.out.println("under construction");
	}
	public void deleteUser(String name) throws SQLException{
		if (userBO.deleteUseBO(name)) {
			System.out.println("Igrac uspjesno izbrisan");
		}
		else {
			System.out.println("Greska, molim vas pokusajte ponovo.");
		}
	}
		
}
