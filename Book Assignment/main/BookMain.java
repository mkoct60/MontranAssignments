package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Book book = new Book();
		book.setBook_no(12005);
		book.setBook_title("Java Programming");
		book.setPrice(150.70);

		System.out.println("What do you want?:");
		System.out.println("1. Purchase Book.");
		System.out.println("2. Read Book Details.");
		System.out.println("3. Exit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("How many copies you want to purchase?");
			int no_of_copies = scanner.nextInt();
			System.out.println("TotAL price of " + no_of_copies + " books is " + book.purchase_book(no_of_copies));
			break;
		case 2:
			System.out.println(book.input());
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("No Option Selected");
			break;
		}
	}

}
