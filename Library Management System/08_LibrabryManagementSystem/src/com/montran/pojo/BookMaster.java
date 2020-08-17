package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "book_master")
public class BookMaster {

	@Id
	@Column(length = 20)
	@Check(constraints = "LIKE 'B%'")
	private String book_id;
	
	@Column(length = 30)
	private String book_title;
	
	@Column(length = 30)
	private String book_author;
	
	@Column(precision = 10, scale = 2)
	private double price;
	@Column
	private int book_issuable = 1;
	@Column
	private int book_issued = 0;

	public BookMaster() {
		// TODO Auto-generated constructor stub
	}

	public BookMaster(String book_id, String book_title, String book_author, double price, int book_issuable,
			int book_issued) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_author = book_author;
		this.price = price;
		this.book_issuable = book_issuable;
		this.book_issued = book_issued;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBook_issuable() {
		return book_issuable;
	}

	public void setBook_issuable(int book_issuable) {
		this.book_issuable = book_issuable;
	}

	public int getBook_issued() {
		return book_issued;
	}

	public void setBook_issued(int book_issued) {
		this.book_issued = book_issued;
	}

	@Override
	public String toString() {
		return "BookMaster [book_id=" + book_id + ", book_title=" + book_title + ", book_author=" + book_author
				+ ", price=" + price + ", book_issuable=" + book_issuable + ", book_issued=" + book_issued + "]";
	}

}
