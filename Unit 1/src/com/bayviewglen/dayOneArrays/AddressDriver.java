package com.bayviewglen.dayOneArrays;

import java.util.Scanner;

public class AddressDriver {

	public static void main(String[] args) {
			
		Scanner keyboard = new Scanner(System.in);
		
		AddressBook contact = new AddressBook();
		
		contact.welcomeMenu(keyboard);
		
		contact.addContact(keyboard);
		
		//contact.displayAll();
		
		//contact.search();
		
	}

}
