package com.bayviewglen.contactList;

import java.util.Arrays;
import java.util.Scanner;

public class ContactListDriver {

	public static void main(String[] args) {
		ContactList contact = new ContactList();
		Scanner keyboard = new Scanner(System.in);
		
		boolean closeBook = false; // to check when user is done and can close address book 
		
		System.out.println("Welcome to your faithful addressbook!");
		
		while (!closeBook) {
			contact.welcomeMenu(keyboard, contact);	
			
			closeBook = contact.finished(keyboard, contact);
		}
		
		contact.closingMessage();
		
	}

}
