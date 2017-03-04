package org.bildit;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.bildit.DTO.Admin;
import org.bildit.DTO.User;
import org.bildit.view.AdminInteraction;
import org.bildit.view.UserInteraction;

public class App {
	
	static Scanner input = new Scanner(System.in);
	static UserInteraction userI = new UserInteraction();
	static AdminInteraction adminI = new AdminInteraction();
	
    public static void main( String[] args ) throws SQLException{
    

    	while(true) {
    		printMainMenu(userI);
   		}     
     }
    
    public static void printMainMenu(UserInteraction userI) throws SQLException {
    	
    	Admin admin = null;
    	User user = null;
    	
    	System.out.println("Izaberite opciju: \n"
				+ "1. Log - admin \n"
				+ "2. Log - igrac \n"
				+ "3. Registracija - igrac\n"
				+ "4. Izlaz\n");
    	
    	try {		
			int izbor = input.nextInt();
			
			switch(izbor) {	
			
			case 1: {
				input.nextLine();
				admin = adminI.loginMainMenu();
				if (admin != null) {
					while(true) {
						adminI.printAdminMenu(admin);
					}
				}
				break;
			}
			case 2: {
				input.nextLine();
				user = userI.loginMainMenu();
				if (user != null) {
					while(true) {
						userI.printUserMenu(user);
					}
				}
				break;
			}
			case 3: {
				input.nextLine(	);
				userI.registracija();
				break;
			}
			case 4: {
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
}
