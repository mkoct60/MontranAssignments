package com.montran.pojo;

public class Book {

	private int book_no;
	private String book_title;
	private double price;

	public String input() {
		return "Book [book_no=" + book_no + ", book_title=" + book_title + ", price=" + price + "]";
	}

	public int getBook_no() {
		return book_no;
	}

	public String getBook_title() {
		return book_title;
	}

	public double getPrice() {
		return price;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private double total_cost(int no_of_copies) {
		return this.price * no_of_copies;
	}

	
	public double purchase_book(int no_of_copies) {
		return this.total_cost(no_of_copies);
	}

}
