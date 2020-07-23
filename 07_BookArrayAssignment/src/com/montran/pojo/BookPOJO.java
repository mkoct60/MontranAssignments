package com.montran.pojo;

public class BookPOJO {

	private int book_id;
	private static int temp_bookid=101;
	private String book_name;
	private double book_price;
	
	public BookPOJO() {
		// TODO Auto-generated constructor stub
	}

	public BookPOJO(int book_id, String book_name, double book_price) {
		super();
		this.book_id = temp_bookid++;
		this.book_name = book_name;
		this.book_price = book_price;
	}

	public int getBook_id() {
		return book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public double getBook_price() {
		return book_price;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}

	@Override
	public String toString() {
		return "BookPOJO [book_id=" + book_id + ", book_name=" + book_name + ", book_price=" + book_price + "]";
	}
	
	
}
