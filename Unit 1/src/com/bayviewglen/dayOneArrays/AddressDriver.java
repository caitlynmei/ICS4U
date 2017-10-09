package com.bayviewglen.dayOneArrays;

import java.util.Arrays;
import java.util.Scanner;

public class AddressDriver {

	public static void main(String[] args) {
		//String optionNum = "";
		
		
		Scanner keyboard = new Scanner(System.in);
		
		AddressBook contact = new AddressBook();
		
		contact.welcomeMenu(keyboard, contact);
		
		/*
		contact.addContact(keyboard, contact);
		
		contact.displayAll();
		
		contact.search(keyboard, contact);
		*/
		
	}

}
