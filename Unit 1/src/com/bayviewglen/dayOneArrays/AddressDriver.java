package com.bayviewglen.dayOneArrays;

import java.util.Scanner;

public class AddressDriver {

	public static void main(String[] args) {
	
		AddressBook contact = new AddressBook();
		
		Scanner keyboard = new Scanner(System.in);
		
		contact.welcomeMenu(keyboard);
		
		contact.addContact(keyboard);
		
		contact.displayAll();
		
		contact.search();
		
	}

}
