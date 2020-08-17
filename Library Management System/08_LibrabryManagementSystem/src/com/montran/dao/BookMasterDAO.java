package com.montran.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.montran.pojo.BookMaster;
import com.montran.util.SessionFactoryUtil;

public class BookMasterDAO {
	
	private Session session;
	Transaction transaction;
	private SessionFactory factory = SessionFactoryUtil.getFactory();
	
	public BookMaster geBookDetailsById(String book_id) {
		session = factory.openSession();
		BookMaster bookMaster=session.find(BookMaster.class, book_id);
		session.close();
		return bookMaster;
	}
	
	public void updateBookDetails(BookMaster bookMaster) {
		session=factory.openSession();
		transaction=session.beginTransaction();
		session.update(bookMaster);
		transaction.commit();
		session.close();
	}
	
}
