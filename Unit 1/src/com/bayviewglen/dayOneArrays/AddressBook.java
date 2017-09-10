package com.bayviewglen.dayOneArrays;

import java.util.Scanner;

public class AddressBook {
	final String VALID_CONTACT_NAME_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Contact[] contacts;
	private int numContacts;

	public AddressBook() {
		contacts = new Contact[1000];
		numContacts = 0;
	}

	// welcome message that offers menu options
	public void welcomeMenu(Scanner keyboard) {
		String optionNum = "";
		
		System.out.println("Welcome to your faithful addressbook!");
		System.out.println("\n--- MENU OPTIONS ---");
		System.out.println("(1) Add a contact");
		System.out.println("(2) Display all my contacts");
		System.out.println("(3) Search for a specific contact");
		System.out.print("\nPlease enter one of the corresponding numbers above to carry out an option: ");
		
		boolean invalidInput = true; // to check if user entered a valid option number: (1), (2), or (3)
		while (invalidInput) { 
			optionNum = keyboard.nextLine();
			if (optionNum.equals("1") || optionNum.equals("2") || optionNum.equals("3")) {
				invalidInput = false;
			} else { 
				System.out.println("Please enter one of the following numbers to: \n(1) Add a contact \n(2) Display all contacts \n(3) Search for a specific contact");
			} 
		}
		
		// determining which option the user entered 
		if (optionNum == "1") {
			addContact(keyboard);	
		} else if (optionNum == "2") {
			displayAll();
		} /*else if (optionNum == "3") {
			if () {
				// option 1 for display
			} else if {
				// option 2 for delete
			}
		}*/
		
		
	}

	// method checks if the user entered a contact name using valid characters 
	public boolean contactNameCheck(String contactName) {
		boolean validName = false; // to check if the user entered a valid number for menu options
		while (!validName) {
			validName = true;
			for (int i = 0; i < contactName.length() && validName; i++) {
				if (VALID_CONTACT_NAME_CHARACTERS.indexOf(contactName.charAt(i)) == -1) {
					validName = false;
					System.out.println("Please enter a name containing \'only\' characters from the English alphabet:");
					System.out.println("(*Hint: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z)");
				}
			}
		}
		return validName;
	}

	// (1) Add a Contact
	public void addContact(Scanner keyboard) {
		String lastName = "";

		System.out.println("\n--- ADD A NEW CONTACT ---");
		System.out.println("Yay! A new friend :) ");
		System.out.print("Please enter the new contact's \'last name\': ");

		// to check if user entered valid characters for the contact's last name
		boolean invalidInput = true;
		while (invalidInput) {
			lastName = keyboard.nextLine().toUpperCase();
			if (contactNameCheck(lastName)) {
				invalidInput = false;
			} else {
				System.out.println("Please enter ... testing");
			}
		}
		
		System.out.print("Please enter the new contact's \'first name\': ");
		
		System.out.print("Please enter the new contact's phone number (only numbers please): ");
		
		//contacts[numContacts] = " ";
		numContacts++;
	}

	// (2) Display All Contacts 
	public void displayAll() {
		// TODO Auto-generated method stub
		
		// array that contains 
		

	}

	// (3) Search for a Specific Contact
	public void search() {
		// TODO Auto-generated method stub

	}

}
