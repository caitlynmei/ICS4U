package com.bayviewglen.dayOneArrays;

import java.util.Arrays;
import java.util.Scanner;

public class AddressDriver {

	public static void main(String[] args) {
		AddressBook contact = new AddressBook();
		Scanner keyboard = new Scanner(System.in);
		
		boolean closeBook = false;
		
		System.out.println("Welcome to your faithful addressbook!");
		
		while (!closeBook) {
			contact.welcomeMenu(keyboard, contact);	
			
			closeBook = contact.finished(keyboard, contact);
		}
		
		contact.closingMessage();
		
	}

}
