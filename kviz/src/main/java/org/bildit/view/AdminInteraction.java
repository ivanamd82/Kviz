package org.bildit.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.bildit.BO.AdminBO;
import org.bildit.DTO.Admin;

public class AdminInteraction extends PersonInteraction {
	
	static Scanner input = new Scanner(System.in);
	
	Admin admin;
	AdminBO adminBO = new AdminBO();
	QuestionInteraction questionI = new QuestionInteraction();
	
	public Admin loginInput() {
		
		System.out.println("Unesite korisnicko ime: ");
		String userName = input.next();
		System.out.print("Unesite sifru: ");
		String userPassword = input.next();
		Admin admin = new Admin(userName, userPassword);
		
		return admin;
	}
	
	public Admin loginMainMenu() throws SQLException {
		
		this. admin = loginInput();
		
		try {
			admin = adminBO.getAdminBO(admin.getName(),admin.getPassword());
			if(admin == null) {
				System.out.println("Pogresna sifra!");
				
				return null;
			}
			else {
				System.out.println("Uspjesno ste ulogovali.");
				return admin;
			}
		} catch (NullPointerException e) {
			System.out.println("Pogreso korisnicko ime ili baza prazna");
			e.printStackTrace();
			return null;
		}
	}


	public void printAdminMenu(Admin admin) throws SQLException {
		
		System.out.println("\nIzaberite opciju: \n"
						+ "1. Dodati novo pitanje i odgovor \n"
						+ "2. Editovanje pitanja \n"
						+ "3. Editovanje odgovora\n"
						+ "4. Promjena sifre\n"
						+ "5. add new admin\n"
						+ "6. Brisanje igraca\n"						
						+ "7. Izlaz\n");	
		
		try {
			int izbor = input.nextInt();
			
			switch (izbor) {
			case 1: {
				addNewQuestion();
				break;
			}
			case 2: {
				editQuestion();
				break;
			}
			case 3: {
				editAnswer();
				break;
			}
			case 4: {
				changePassword();
				break;
			}
			case 5: {
				addAdmin();
				break;
			}
			case 6: {
				deleteUser();
				break;
			}
			case 7: {
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


	private void addNewQuestion() throws SQLException {
	
		questionI.addNewQuestion();				
	}	

	private void editQuestion() throws SQLException {
		
		questionI.editQuestion();
	}

	private void editAnswer() throws SQLException {
		
		questionI.editAnswer();		
	}

	private void changePassword() throws SQLException {
		
		String newPassword = newPassword();
		
		if (adminBO.updateAdminBO(admin, newPassword)) {
			System.out.println("Sifra uspijesno izmjenjena");			
		}
		else {
			System.out.println("Greska, molim vas pokusajte ponovo.");
		}		
		
	}

	private void addAdmin() throws SQLException {

		Admin admin = loginInput();
		
		if (adminBO.addAdminBO(admin.getName(), admin.getPassword())) {
			System.out.println("Uspjesno ste se dodali novog administratora.");
		}
		else {
			System.out.println("Pogresno korisnicko ime/ime je vec zauzeto");
		}				
	}

	
	private void deleteUser() throws SQLException {
		
		UserInteraction userI = new UserInteraction();
		
		System.out.println("Unesite ime: ");
		String userName = input.nextLine();
		userI.deleteUser(userName);		
	}

}
