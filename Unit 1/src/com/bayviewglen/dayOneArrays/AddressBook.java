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

	// --- WELCOME MESSAGE that offers menu options --- 
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
				System.out.println(
						"\nPlease enter one of the following numbers (1, 2, or 3) to: \n(1) Add a contact \n(2) Display all contacts \n(3) Search for a specific contact");
				System.out.print("Enter a menu option here: ");
			}
		}

		// determining which option the user entered
		if (optionNum.equals("1")) {
			addContact(keyboard, contact); // ***** FOR SOME REASON IT JUST ENDS HERE...
		} else if (optionNum.equals("2")) {
			displayAll();
		} else if (optionNum.equals("3")) {
			search(keyboard, contact);
		}
	}
	
	// (1) Add a Contact
	public void addContact(Scanner keyboard, AddressBook contact) {
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

		contacts[numContacts] = tempContact;
		numContacts++;
		//Arrays.sort(contacts, Ordering.natural().nullsLast());
		
		sort(); // sorting 
		print(); // checking 		
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
		System.out.println("Hi there! You have the following friends in your addressbook: ");

		for (int i = 0; i < numContacts; i++) {
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
			if (searchLnameCheck(keyboard, tempLname)) {
				invalidInput = false;
			} else {
				System.out.println("Please enter a last name containing only characters from the English alphabet.");
			}
		}

		System.out.println("\nPlease give your addressbook a second...");

		// to check if user has a contact with the entered last name
		boolean invalidContact = true;
		while (invalidContact) {
			invalidContact = false;
			if (!checkContact(keyboard, tempLnameContacts, tempNumLnameContacts)) {
				System.out.println("\nYay! Your friend(s) with this last name was(were) found: ");
				for (int i = 0; i < tempNumLnameContacts; i++) {
					System.out.println("( " + i + ") " + contacts[tempLnameContacts[i]].getLname() + ", "
							+ contacts[tempLnameContacts[i]].getFname() + " ("
							+ contacts[tempLnameContacts[i]].getPhone() + ")");
				}
				// foundContact(keyboard);
				invalidContact = false;
			} else {
				System.out.println("\nYou do not have a contact with that last name.");
				invalidContact = false;
			}
		}
	}

	// --- checks if the user entered a LAST NAME TO SEARCH using valid characters ---
	public boolean searchLnameCheck(Scanner keyboard, String contactName) {
		String tempContactName = contactName;
		boolean validName = false; // to check if the user entered a valid contact last name
		while (!validName) {
			tempContactName = keyboard.nextLine().toUpperCase(); // assigning last name to contact
			validName = true;
			for (int i = 0; i < tempContactName.length() && validName; i++) {
				if (VALID_CONTACT_NAME_CHARACTERS.indexOf(tempContactName.charAt(i)) == -1) {
					validName = false;
					System.out.println("\nPlease enter a name containing \'only\' characters from the English alphabet. No numbers.");
					System.out.println("(*Hint: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z)");
					System.out.print("\nEnter here: ");
				}
			}
		}
		contactName = tempContactName;
		//System.out.println("contactName: " + contactName); // checking
		return validName;

	}
	
	private boolean checkContact(Scanner keyboard, int[] tempLnameContacts, int numLnameContacts) {
		String tempLname = "";
		// int j = 0; // for incrementing index of tempLnameContacts
		int tempNumLnameContacts = numLnameContacts;
		boolean invalidName = true; // to check if the user entered a valid contact last name
		while (invalidName) {
			tempLname = keyboard.nextLine();
			for (int i = 0; i < numContacts && invalidName; i++) {
				if (contacts[i].getLname().equals(tempLname)) {
					tempLnameContacts[++tempNumLnameContacts] = i;
					invalidName = false;
				} else {
					System.out.println("\nYou do not have a contact with that last name.");
					System.out.print("Please try again: ");
				}
			}
		}
		System.out.println("tempNumLnameContacts: " + tempNumLnameContacts);
		return invalidName;
	}
	
	// (3) Options After Finding Contact
	/*private void foundContact(Scanner keyboard) {
		String searchOptionNum = "";

		System.out.print("\nPlease enter the number corresponding to the specific contact you are searching for: ");
		// check

		System.out.println("Yay! You found your friend!");
		System.out.println(
				"On the rare chance that you would like to unfriend a contact and annihilate her/him from this addressbook memory, you have the following options:");
		System.out.println("(1) Close Addressbook and Keep Contact");
		System.out.println("(2) Delete Contact");
		System.out.print("Please enter (1) or (2): ");

		boolean invalidInput = true; // to check if user entered a valid option number: (1) or (2)
		while (invalidInput) {
			searchOptionNum = keyboard.nextLine();
			if (searchOptionNum.equals("1") || searchOptionNum.equals("2")) {
				invalidInput = false;
			} else {
				System.out.println(
						"\nPlease enter one of the following numbers: (1) Keep contact and close addressbook or (2) Delete a contact.");
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

	// --- check is to be deleted contact's last name is valid --- 
	private boolean deleteLnameCheck(Scanner keyboard, String deleteLname) {
		return false;
		
	}
	
	// --- check is to be deleted contact's last name is valid --- 
	private boolean deleteFnameCheck(Scanner keyboard, String deleteLname) {
		return false;
			
	}
	
	// (3A) Delete a Contact
	private void deleteContact(Scanner keyboard) {
		String deletedLname = "";
		String deletedFname = "";
		
		System.out.println("--- DELETE A CONTACT --- ");
		System.out.println("Okay then, um... the following is to delete a contact.");
		System.out.print("Please enter the LAST NAME: ");
		
		// to check if user entered valid characters for the contact's last name (no numbers)
		boolean invalidInput = true;
		while (invalidInput) {
			if (deleteLnameCheck(keyboard, deletedLname)) {
				invalidInput = false;
			} else {
				System.out.println("Please enter a last name containing only characters from the English alphabet.");
			}
		}

		System.out.print("Please enter the new contact's FIRST NAME: ");
		// to check if user entered valid characters for the contact's first name (no numbers)
		invalidInput = true;
		while (invalidInput) {
			if (deleteFnameCheck(keyboard, deletedFname)) {
				invalidInput = false;
		} else {
				System.out.println("Please enter a first name containing only characters from the English alphabet.");
			}
		}		
	}

	// checking method 
	public void print() {
		for (int i=0; i<numContacts; i++) {
			System.out.println("Last: " + contacts[i].getLname() + ", First: " + contacts[i].getFname() + ", Phone: " + contacts[i].getPhone());
		}
	}
	
	// sorting contacts in order: from smallest to greatest regarding ASCII 
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
	
	
}
