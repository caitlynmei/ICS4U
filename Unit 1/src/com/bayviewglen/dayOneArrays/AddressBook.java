package com.bayviewglen.dayOneArrays;

import java.util.Scanner;

public class AddressBook {
	final String VALID_CONTACT_NAME_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final String VALID_CONTACT_PHONE_NUMBER = "0123456789";
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
				System.out.println("\nPlease enter one of the following numbers (1, 2, or 3) to: \n(1) Add a contact \n(2) Display all contacts \n(3) Search for a specific contact");
				System.out.print("Enter menu option here: ");
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
	public boolean contactNameCheck(Scanner keyboard, String contactName) {
		String tempContactName = contactName;
		boolean validName = false; // to check if the user entered a valid contact name
		while (!validName) {
			validName = true;
			for (int i = 0; i < tempContactName.length() && validName; i++) {
				if (VALID_CONTACT_NAME_CHARACTERS.indexOf(tempContactName.charAt(i)) == -1) {
					validName = false;
					System.out.println("Please enter a name containing \'only\' characters from the English alphabet. No numbers");
					System.out.println("(*Hint: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z)");
					System.out.print("Please enter here: ");
				} 
			}
		}
		return validName;
	}

	// method checks if the user entered a phone number using valid numbers
	public boolean contactNumCheck(Scanner keyboard, String phoneNum) {
		String contactNum = phoneNum;
		boolean validNum = false; // to check if the user entered a valid contact phone number
		while (!validNum) {
			validNum = true;
			for (int i = 0; i < contactNum.length() && validNum; i++) {
				if (VALID_CONTACT_PHONE_NUMBER.indexOf(contactNum.charAt(i)) == -1) {
					validNum = false;
					System.out.println("Please enter a phone number containing \'only\' numbers. No characters.");
					System.out.println("(*Hint: 0 1 2 3 4 5 6 7 8 9)");
					System.out.print("Please enter here: ");
				}
			}
		}
		return validNum;
	}

	// (1) Add a Contact
	public void addContact(Scanner keyboard) {
		// AddressBook tempContact = new AddressBook();
		String lastName = "";
		String firstName = "";
		String phoneNum = "";

		System.out.println("\n--- ADD A NEW CONTACT ---");
		System.out.println("Yay! A new friend :) ");

		// *** NEED TO SAVE THE INFO

		System.out.print("Please enter the new contact's LAST NAME: ");
		// to check if user entered valid characters for the contact's last name (no numbers)
		boolean invalidInput = true;
		while (invalidInput) {
			lastName = keyboard.nextLine().toUpperCase(); // assigning last name to contact
			if (contactNameCheck(keyboard, lastName)) {
				//lastName.setlname(lastName);
				invalidInput = false;
			} else {
				System.out.println("Please enter a last name containing only characters from the English alphabet.");
			}
		}

		System.out.print("Please enter the new contact's FIRST NAME: ");
		// to check if user entered valid characters for the contact's first name (no numbers)
		invalidInput = true;
		while (invalidInput) {
			firstName = keyboard.nextLine().toUpperCase(); // assigning first name to contact
			if (contactNameCheck(keyboard, firstName)) {
				invalidInput = false;
			} else {
				System.out.println("Please enter a first name containing only characters from the English alphabet.");
			}
		}

		System.out.print("Please enter the new contact's PHONE NUMBER (numbers only): ");
		// **if time, check for only 10 digits
		// to check if user entered valid numbers for the contact's phone number (no characters)
		invalidInput = true;
		while (invalidInput) {
			phoneNum = keyboard.nextLine(); // assigning phone number to contact
			if (contactNumCheck(keyboard, phoneNum)) {
				invalidInput = false;
			} else {
				System.out.println("Please enter a phone number containg only numbers.");
			}			
		}

		System.out.println("f: " + firstName + ", l: " + lastName + ", num: " + phoneNum); // checking variables

		// contacts[numContacts] = Contact(lastName, firstName, phoneNum);
		//System.out.println("Great!! Your friend " + tempContact.lName(lastName) + ", " + tempContact.fName(firstName) + " (" + contact.phone(phoneNum) + ") has been added to your address book.");
		// contacts[numContacts] = " ";
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
