package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.BookPOJO;
import com.montran.util.BookUtil;

public class BookMain {

	public static void main(String[] args) {
		int choice;
		Scanner scanner = new Scanner(System.in);
		BookUtil bookUtil = new BookUtil(10);
		BookPOJO bookPOJO;
		BookPOJO[] arrayBookPOJOs;
		int book_id;
		double price;
		String yesorno, bookname;
		boolean result;

		do {
			arrayBookPOJOs = bookUtil.showAllBooks();
			for (BookPOJO bookPOJO2 : arrayBookPOJOs) {
				if (bookPOJO2 != null)
					System.out.println(bookPOJO2);
			}
			System.out.println("1. Add Single Book.");
			System.out.println("2. Add Multiple Book.");
			System.out.println("3. Update Existing Book.");
			System.out.println("4. Delete Existing Book.");
			System.out.println("5. Print Single Book Detail.");
			System.out.println("6. Exit.");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				scanner.nextLine();
				System.out.print("Enter book name: ");
				bookname = scanner.nextLine();
				System.out.print("Enter book price: ");
				price = scanner.nextDouble();
				bookPOJO = new BookPOJO(0, bookname, price);
				result = bookUtil.addNewBooks(bookPOJO);
				if (result)
					System.out.println("Book Added!");
				else {
					System.out.println("Failed");
				}
				break;

			case 2:
				System.out.print("How Many Books do you want to Enter: ");
				int book_num = scanner.nextInt();
				if (bookUtil.getNextIndex() + book_num <= bookUtil.getMaxIndex()) {
					arrayBookPOJOs = new BookPOJO[book_num];
					for (int i = 0; i < book_num; i++) {
						scanner.nextLine();
						System.out.print("Enter book name: ");
						bookname = scanner.nextLine();
						System.out.print("Enter book price: ");
						double book_price = scanner.nextDouble();
						bookPOJO = new BookPOJO(0, bookname, book_price);
						arrayBookPOJOs[i] = bookPOJO;
					}
					result = bookUtil.addAllBook(arrayBookPOJOs);
					if (result)
						System.out.println("Book Added Successfully!.");
					else {
						System.out.println("Failed!");
					}
				} else
					System.out.println("Maximum Limit Reached");
				break;
			case 3:
				System.out.print("Enter the book id: ");
				book_id = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter new Book name");
				bookname = scanner.nextLine();
				System.out.print("Enter new Price: ");
				price = scanner.nextDouble();
				result = bookUtil.updateBook(book_id, bookname, price);
				if (result)
					System.out.println("Book Updated Successfully");
				else {
					System.out.println("Book ID not found.");
				}
				break;

			case 4:
				System.out.print("Enter book id: ");
				book_id = scanner.nextInt();
				result = bookUtil.deleteBook(book_id);
				if (result)
					System.out.println("Book Deleted Successfully");
				else {
					System.out.println("Book ID not found");
				}
				break;
			case 5:
				System.out.print("Enter book id: ");
				book_id = scanner.nextInt();
				bookPOJO = bookUtil.getBookByBookId(book_id);
				System.out.println(bookPOJO);
				break;
			case 6:
				System.out.print("Thank You!!!");
				System.exit(0);
				break;
			default:
				break;
			}
			System.out.print("Do you want to continue(Yes/no)?: ");
			yesorno = scanner.next();
		} while (yesorno.toLowerCase().equals("yes"));

		scanner.close();
	}

}
