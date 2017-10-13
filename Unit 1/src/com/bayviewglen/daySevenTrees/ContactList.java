package com.bayviewglen.daySevenTrees;

import java.util.Arrays;
import java.util.Scanner;

public class ContactList {
	final String VALID_CONTACT_NAME_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final String VALID_CONTACT_PHONE_NUMBER = "0123456789";
	//final int lastContactIndex = 999; // used for deleting a contact 
	//private Contact[] contacts;
	private BinarySearchTree contacts;
	
	private int numContacts;

	public ContactList() {
		BinarySearchTree contacts = new BinarySearchTree();
		//contacts = new Contact[1000];
		//numContacts = 0;
	}

	// --- WELCOME MESSAGE that offers menu options --- 
	public void welcomeMenu(Scanner keyboard, ContactList contact) {
		String optionNum = "";

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
				System.out.println(
						"\nPlease enter one of the following numbers (1, 2, or 3) to: \n(1) Add a contact \n(2) Display all contacts \n(3) Search for a specific contact");
				System.out.print("Enter a menu option here: ");
			}
		}

		// determining which option the user entered
		if (optionNum.equals("1")) {
			addContact(keyboard, contact); 
		} else if (optionNum.equals("2")) {
			displayAll();
		} else if (optionNum.equals("3")) {
			search(keyboard, contact);
		}
	}
	
	// (1) Add a Contact
	public void addContact(Scanner keyboard, ContactList contact) {
		String lastName = "";
		String firstName = "";
		String phoneNum = "";
		Contact tempContact = new Contact(lastName, firstName, phoneNum);

		System.out.println("\n--- ADD A NEW CONTACT ---");
		System.out.println("Yay! A new friend :) ");

		System.out.print("Please enter the new contact's LAST NAME: ");
		// to check if user entered valid characters for the contact's last name (no numbers)
		boolean invalidInput = true;
		while (invalidInput) {
			if (contactLnameCheck(keyboard, lastName, tempContact)) {
				invalidInput = false;
			} else {
				System.out.println("Please enter a last name containing only characters from the English alphabet.");
			}
		}

		System.out.print("Please enter the new contact's FIRST NAME: ");
		// to check if user entered valid characters for the contact's first name (no numbers)
		invalidInput = true;
		while (invalidInput) {
			if (contactFnameCheck(keyboard, firstName, tempContact)) {
				invalidInput = false;
			} else {
				System.out.println("Please enter a first name containing only characters from the English alphabet.");
			}
		}

		System.out.print("Please enter the new contact's PHONE NUMBER (numbers only): ");
		// to check if user entered valid numbers for the contact's phone number (no characters)
		invalidInput = true;
		while (invalidInput) {
			if (contactNumCheck(keyboard, phoneNum, tempContact)) {
				invalidInput = false;
			} else {
				System.out.println("Please enter a phone number containg only numbers.");
			}
		}

		System.out.println("Great!! Your friend " + tempContact.getLname() + ", " + tempContact.getFname() + " (" + tempContact.getPhone() + ") has been added to your address book!");

		contacts.add(tempContact);
		
		// -- original --
		//contacts[numContacts] = tempContact;
		//numContacts++;
		//sort(); // sorting 
		
		printBST(); // checking 		
	}
	
	// --- checks if the user entered a LAST NAME using valid characters ---
	public boolean contactLnameCheck(Scanner keyboard, String lastName, Contact newContact) {
		String tempLname = lastName;
		boolean validName = false; // to check if the user entered a valid last name
		while (!validName) {
			tempLname = keyboard.nextLine().toUpperCase(); // assigning last name to contact
			validName = true;
			for (int i = 0; i < tempLname.length() && validName; i++) {
				if (VALID_CONTACT_NAME_CHARACTERS.indexOf(tempLname.charAt(i)) == -1) {
					validName = false;
					System.out.println("\nPlease enter a name containing \'only\' characters from the English alphabet. No numbers.");
					System.out.println("(*Hint: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z)");
					System.out.print("\nEnter here: ");
				}
			}
		}
		lastName = tempLname;
		newContact.setLname(lastName);
		//System.out.println("lastName: " + lastName); // checking
		return validName;
	}

	// --- checks if the user entered a FIRST NAME using valid characters ---
	public boolean contactFnameCheck(Scanner keyboard, String firstName, Contact newContact) {
		String tempLname = firstName;
		boolean validName = false; // to check if the user entered a valid first name
		while (!validName) {
			tempLname = keyboard.nextLine().toUpperCase(); // assigning first name to contact
			validName = true;
			for (int i = 0; i < tempLname.length() && validName; i++) {
				if (VALID_CONTACT_NAME_CHARACTERS.indexOf(tempLname.charAt(i)) == -1) {
					validName = false;
					System.out.println("\nPlease enter a name containing \'only\' characters from the English alphabet. No numbers.");
					System.out.println("(*Hint: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z)");
					System.out.print("\nEnter here: ");
				}
			}
		}
		firstName = tempLname;
		newContact.setFname(firstName);
		//System.out.println("firstName: " + firstName); // checking
		return validName;
	}

	// --- method checks if the user entered a phone number using valid numbers ---
	public boolean contactNumCheck(Scanner keyboard, String phoneNum, Contact newContact) {
		String contactNum = phoneNum;
		boolean validNum = false; // to check if the user entered a valid contact phone number
		while (!validNum) {
			contactNum = keyboard.nextLine(); // assigning phone number to contact
			validNum = true;
			for (int i = 0; i < contactNum.length() && validNum; i++) {
				if (VALID_CONTACT_PHONE_NUMBER.indexOf(contactNum.charAt(i)) == -1) {
					validNum = false;
					System.out.println("\nPlease enter a phone number containing \'only\' numbers. No characters.");
					System.out.println("(*Hint: 0 1 2 3 4 5 6 7 8 9)");
					System.out.print("Please enter here: ");
				}
			}
		}
		phoneNum = contactNum;
		newContact.setPhone(phoneNum);
		return validNum;
	}

	
	// (2) Display All Contacts
	public void displayAll() {
		System.out.println("\n--- DISPLAY ALL CONTACTS ---");
		
		if (contacts.getRoot() == null) {
			System.out.println("You don't have any friends yet...");
		} else {
			System.out.println("Hi there! You have the following friends in your addressbook: ");
			sortBST();
			
			/*
			for (int i = 0; i < numContacts; i++) {
				System.out.println("- " + contacts[i].getLname() + ", " + contacts[i].getFname() + " (" + contacts[i].getPhone() + ")");
			}
			*/
		}
	}
	

	// (3) Search for a Specific Contact
	public void search(Scanner keyboard, ContactList contact) {
		String tempLName = "";
		String tempFName = "";
		String tempFullName = "";
		
		System.out.println("\n--- SEARCH FOR A SPECIFIC CONTACT ---");
		System.out.println("Who would you like to search for?");
		System.out.print("Please enter the contact's LAST NAME: ");
		tempLName = keyboard.nextLine().toUpperCase();
		System.out.print("Please enter the contact's FIRST NAME: ");
		tempFName = keyboard.nextLine().toUpperCase();
		
		tempFullName = tempLName + tempFName;
		boolean foundContact = false;

		// to check if user has a contact with the entered last name
		boolean invalidContact = true;
		while (invalidContact) {
			//invalidContact = false;
			if (searchContact(keyboard, tempFullName)) {
				invalidContact = false;	
				System.out.println(
						"\nPlease enter one of the following numbers to: \n(1) Display Contact Info \n(2) Delete Contact");
				System.out.print("Enter a menu option here: ");
				foundContact = true;
			} else {
				System.out.println("\nYou do not have a contact with that last name.");
				invalidContact = false;
			}
		}
		
		
		if (foundContact) {
			String optionNum = "";
			boolean invalidInput = true; // to check if user entered a valid option number: (1) or (2)
			while (invalidInput) {
				optionNum = keyboard.nextLine();
				if (optionNum.equals("1") || optionNum.equals("2")) {
					invalidInput = false;
				} else {
					System.out.println(
							"\nPlease enter one of the following numbers to: \n(1) Display Contact Info \n(2) Delete Contact");
					System.out.print("Enter a menu option here: ");
				}
			}
			
			if (optionNum.equals("1")) {
				displayInfo(tempFullName);
			} else if (optionNum.equals("2")) {
				deleteContact(tempFullName);
			}
		}
	}
	
	
	// --- searches to see if user has the entered contact name in address book --- 
	private boolean searchContact(Scanner keyboard, String tempFullName) {
		boolean haveContact = false;
		
		/*
		for (int i=0; i<numContacts; i++) {
			if (contacts[i].getFullName().equals(tempFullName)) {
				haveContact = true;
			}
		}
		*/
		
		Contact temp = contacts.searchBST(contacts.getRoot(), tempFullName);
		if (temp != null) {
			haveContact = true;
		}
			
		return haveContact;
	}
		
	// (3A) Display Contact Info
	private void displayInfo(String tempFullName) {
		//int contactIndex = 0;
		
		//boolean haveContact = false;
		
		Contact tempContact = contacts.searchBST(contacts.getRoot(), tempFullName);
		if (tempContact != null) {
			System.out.println("Yay! You found your friend!");
			System.out.println(tempContact.getLname() + ", "  + " has the phone number: " + tempContact.getPhone() + ".");
		}
	
		//tempContact.getFname() <-- add in ^
		
		/*
		for (int i=0; i<numContacts; i++) {
			if (contacts[i].getFullName().equals(tempFullName)) {
				contactIndex = i;
			}
		}
		*/
		
		//System.out.println("Yay! You found your friend!");
		//System.out.println(contacts.getRoot());
		
		//System.out.println(contacts[contactIndex].getLname() + ", " + contacts[contactIndex].getFname() + " has the phone number: " + contacts[contactIndex].getPhone());
	}

	// (3B) Delete Contact
	private void deleteContact(String tempFullName) {
		System.out.println("Okay then, um... The address book is now unfriending this contact and annihilating her/him from memory.");
		
		contacts.delete(tempFullName);
		
		/*
		for (int i=0; i<numContacts; i++) {
			if (contacts[i].getFullName().equals(tempFullName)) {
				if (i == lastContactIndex) {
					contacts[i] = null;
				} else {
					while (i<numContacts-1) {
						Contact temp = contacts[i+1];
						contacts[i] = temp;
						i++;
					}
					contacts[i+1] = null;
				}
				
			}
		}
		numContacts--;
		*/
	}

	/*
	// checking method 
	public void print() {
		for (int i=0; i<numContacts; i++) {
			System.out.println("Last: " + contacts[i].getLname() + ", First: " + contacts[i].getFname() + ", Phone: " + contacts[i].getPhone());
		}
	}
	*/
	
	// checking method
	public void printBST() {
		contacts.inorderTraversal(contacts.getRoot());
	}
	
	// sorting contacts in order: from smallest to greatest regarding ASCII 
	public void sortBST() {
		contacts.inorderTraversal(contacts.getRoot());
	}
	
	/*
	// original sorting contacts in order: from smallest to greatest regarding ASCII 
	public void sort() {
		for (int i=0; i<contacts.length-1; i++) {
			if (contacts[i] == null || contacts[i+1] == null) {
				i++;
			} else if ((contacts[i].compare(contacts[i], contacts[i+1])) == -1) {
				Contact smaller = contacts[i];
				Contact bigger = contacts[i+1];
				contacts[i] = smaller;
				contacts[i+1] = bigger; 
			}
		}
	}
	*/

	// checking if user is done using the address book 
	public boolean finished(Scanner keyboard, ContactList contact) {
		boolean closeBook = false;
		
		System.out.println("\nAre you finished with the address book? ");
		System.out.println("Please enter (1) to close and save (2) to continue");
		
		String optionNum = "";
		boolean invalidInput = true; // to check if user entered a valid option number: (1) or (2)
		while (invalidInput) {
			optionNum = keyboard.nextLine();
			if (optionNum.equals("1") || optionNum.equals("2")) {
				invalidInput = false;
			} else {
				System.out.println(
						"\nPlease enter one of the following numbers to: \n(1) Close and Save \n(2) Continue Using the Address Book");
				System.out.print("Enter a menu option here: ");
			}
		}
		
		if (optionNum.equals("1")) {
			closeBook = true;
		} 
		
		return closeBook;
	}

	// closing message after user is done with address book 
	public void closingMessage() {
		System.out.println("Alright then. Thank you for using the address book! :)");
	}	
}
