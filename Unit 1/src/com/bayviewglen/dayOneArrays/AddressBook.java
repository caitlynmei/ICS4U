package com.bayviewglen.dayOneArrays;

import java.util.Arrays;
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
	public void welcomeMenu(Scanner keyboard, AddressBook contact) {
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
			addContact(keyboard, contact);	// ***** FOR SOME REASON IT JUST ENDS HERE...
		} else if (optionNum == "2") {
			displayAll();
		} else if (optionNum == "3") {
			search(keyboard, contact);
		}
	
	}
	/*
	boolean validGuessedSolution = false; // to check if guessed character is a single alphanumeric character
	while (!validGuessedSolution){
		validGuessedSolution = true;
		phraseSolution = keyboard.nextLine().toUpperCase(); // changing guess of character to upper case
		for (int c = 0; c < guessedCharacter.length() && validGuessedSolution; c++){
			if (VALID_CHARACTERS_SPACE.indexOf(phraseSolution.charAt(c)) == -1){ 
				validGuessedSolution = false; 
				System.out.println(guesser + ", please enter a valid phrase with only alphanumeric characters (you can use spaces): ");
			} 
		}
	}*/
	
	
	// method checks if the user entered a contact name using valid characters
	public boolean contactNameCheck(Scanner keyboard, String contactName) {
		String tempContactName = contactName;
		boolean validName = false; // to check if the user entered a valid contact name
		while (!validName) {
			validName = true;
			for (int i = 0; i < tempContactName.length() && validName; i++) {
				if (VALID_CONTACT_NAME_CHARACTERS.indexOf(tempContactName.charAt(i)) == -1) {
					validName = false;
					System.out.println("\nPlease enter a name containing \'only\' characters from the English alphabet. No numbers.");
					System.out.println("(*Hint: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z)");
					System.out.print("\nEnter here: ");
					tempContactName = keyboard.nextLine().toUpperCase(); // assigning last name to contact
				} 
			}
		}
		contactName = tempContactName;
		System.out.println("contactName: " + contactName); // checking 
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
					contactNum = keyboard.nextLine(); // assigning phone number to contact
				}
			}
		}
		return validNum;
	}

	// (1) Add a Contact
	public void addContact(Scanner keyboard, AddressBook contact) {
		String lastName = "";
		String firstName = "";
		String phoneNum = "";
		
		System.out.println("\n--- ADD A NEW CONTACT ---");
		System.out.println("Yay! A new friend :) ");

		System.out.print("Please enter the new contact's LAST NAME: ");
		// to check if user entered valid characters for the contact's last name (no numbers)
		boolean invalidInput = true;
		while (invalidInput) {
			lastName = keyboard.nextLine().toUpperCase(); // assigning last name to contact
			if (contactNameCheck(keyboard, lastName)) {
				invalidInput = false;
				System.out.println("Check lastName: " + lastName);
			} else {
				//lastName = keyboard.nextLine().toUpperCase(); // assigning last name to contact
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

		//System.out.println("f: " + firstName + ", l: " + lastName + ", num: " + phoneNum); // checking variables
		
		// saving contact information
		Contact tempContact = new Contact(lastName, firstName, phoneNum);
		tempContact.setLname(lastName);
		tempContact.setFname(firstName);
		tempContact.setPhone(phoneNum);
		
		System.out.println("Great!! Your friend " + tempContact.getLname() + ", " + tempContact.getFname() + " (" + tempContact.getPhone() + ") has been added to your address book!");
		
		contacts[numContacts] = tempContact;
		Arrays.sort(contacts);
		numContacts++;
		
		//System.out.println("contact: " + contacts[numContacts-1].toString() + ", numContactsFirst: " + (numContacts-1) + ", numContactsNext: " + numContacts); // checking variables
		// ***SIDE NOTE: what is the method to show arrays?
	}

	// (2) Display All Contacts
	public void displayAll() {
		System.out.println("\n--- DISPLAY ALL CONTACTS ---");
		System.out.println("Hi there! You have the following friends in your addressbook: ");
		
		for (int i=0; i<numContacts; i++) {
			System.out.println("- " + contacts[i].getLname() + ", " + contacts[i].getFname() + " (" + contacts[i].getPhone() + ")");
		}
	}

	// (3) Search for a Specific Contact
	public void search(Scanner keyboard, AddressBook contact) {
		String tempLname = "";
		int tempNumLnameContacts = 0; // number of contacts with the last name user is searching for 
		int[] tempLnameContacts = new int[tempNumLnameContacts]; // holds indices for contacts with the last name user is searching for 
		
		System.out.println("\n--- SEARCH FOR A SPECIFIC CONTACT ---");
		System.out.println("Who would you like to search for?");
		System.out.print("Please enter the contact's LAST NAME: ");
		
		// to check if user entered valid characters for the contact's last name (no numbers)
		boolean invalidInput = true;
		while (invalidInput) {
			tempLname = keyboard.nextLine().toUpperCase(); // assigning last name to contact
			if (contactNameCheck(keyboard, tempLname)) {
				invalidInput = false;
			} else {
				System.out.println("Please enter a last name containing only characters from the English alphabet.");
			}
		}
		
		System.out.println("You are looking for a contact with the last name " + tempLname + ". Please give your addressbook a second..." );
		
		// to check is user has a contact with the entered last name
		boolean invalidContact = true;
		while (invalidContact) {
			if (!checkContact(keyboard, tempLname, tempLnameContacts, tempNumLnameContacts)) {
				System.out.println("\nYay! Your friends with the last name " + tempLname + " were found: ");
				for (int i=0; i<tempNumLnameContacts; i++) {
					System.out.println("( " + i + ") " + contacts[tempLnameContacts[i]].getLname() + ", " + contacts[tempLnameContacts[i]].getFname() + " (" + contacts[tempLnameContacts[i]].getPhone() + ")");
				}
				//foundContact(keyboard);
				invalidContact = false;
			} else {
				System.out.println("\nYou do not have a contact with that last name.");
				invalidContact = false;
			}
		}
	}

	// (3) Options After Finding Contact 
	/*private void foundContact(Scanner keyboard) {
		String searchOptionNum = "";
		
		System.out.print("\nPlease enter the number corresponding to the specific contact you are searching for: ");
		// check
		
		System.out.println("Yay! You found your friend!");
		System.out.println("On the rare chance that you would like to unfriend a contact and annihilate her/him from this addressbook memory, you have the following options:");
		System.out.println("(1) Close Addressbook and Keep Contact");
		System.out.println("(2) Delete Contact");
		System.out.print("Please enter (1) or (2): ");
		
		boolean invalidInput = true; // to check if user entered a valid option number: (1) or (2)
		while (invalidInput) { 
			searchOptionNum = keyboard.nextLine();
			if (searchOptionNum.equals("1") || searchOptionNum.equals("2")) {
				invalidInput = false;
			} else { 
				System.out.println("\nPlease enter one of the following numbers: (1) Keep contact and close addressbook or (2) Delete a contact.");
				System.out.print("Enter an option number here: ");
			} 
		}
		
		// determining which option the user entered 
		if (searchOptionNum == "1") {
			System.out.println("Alright then, thank you for using the addressbook. Have a good day! :)");
		} else {
			deleteContact();
		}
	}*/

	// (3A) Delete a Contact
	private void deleteContact() {
		// TODO Auto-generated method stub
		
	}

	private boolean checkContact(Scanner keyboard, String Lname, int[] tempLnameContacts, int numLnameContacts) {
		String tempLname = Lname;
		//int j = 0; // for incrementing index of tempLnameContacts
		int tempNumLnameContacts = numLnameContacts;
		boolean invalidName = true; // to check if the user entered a valid contact last name
		while (invalidName) {
			for (int i = 0; i < numContacts && invalidName; i++) {
				if (contacts[i].getLname().equals(tempLname)) {
					//tempNumContact = i;
					tempLnameContacts[++tempNumLnameContacts] = i;
					invalidName = false;
				} else {
					System.out.println("You do not have a contact with that last name.");
					System.out.print("Please try again: ");
				} 
			}
		}
		System.out.println("tempNumLnameContacts: " + tempNumLnameContacts);
		return invalidName;
	}

}
