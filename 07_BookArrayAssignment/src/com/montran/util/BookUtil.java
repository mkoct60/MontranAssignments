package com.montran.util;

import com.montran.pojo.BookPOJO;

public class BookUtil {

	private BookPOJO[] bookPOJOs;
	private int nextIndex = 0;
	private int maxIndex = 0;
//	private static int size=0;

	public BookUtil(int size) {
		// TODO Auto-generated constructor stub
		bookPOJOs = new BookPOJO[size];
		maxIndex = size;
	}

	public boolean addNewBooks(BookPOJO book) {
		if (maxIndex >= 0 && nextIndex < maxIndex) {
			bookPOJOs[nextIndex] = book;
			nextIndex++;
			return true;
		}
		return false;
	}
	

	public int getNextIndex() {
		return nextIndex;
	}

	public int getMaxIndex() {
		return maxIndex;
	}

	public boolean addAllBook(BookPOJO[] book) {
		for (BookPOJO book2 : book) {
			addNewBooks(book2);
		}
		return true;
	}

	public boolean updateBook(int bookid, String newName, double newPrice) {
		for (BookPOJO book : bookPOJOs) {
			if (book.getBook_id() == bookid) {
				book.setBook_name(newName);
				book.setBook_price(newPrice);
				return true;
			}
		}
		return false;
	}

	public boolean deleteBook(int bookid) {
		for (int i = 0; i < bookPOJOs.length; i++) {
			if (bookPOJOs[i].getBook_id() == bookid) {
				bookPOJOs[i]=null;
				return true;
			}
		}
		return false;
	}

	public BookPOJO getBookByBookId(int bookid) {
		for (int i = 0; i < bookPOJOs.length; i++) {
			if (bookPOJOs[i].getBook_id() == bookid) {
				return bookPOJOs[i];
			}
		}
		return null;
	}

	public BookPOJO[] showAllBooks() {
		return this.bookPOJOs;
	}

}
