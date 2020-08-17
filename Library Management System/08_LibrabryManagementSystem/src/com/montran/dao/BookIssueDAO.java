package com.montran.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.montran.pojo.BookMaster;
import com.montran.pojo.IssueMaster;
import com.montran.pojo.MemberMaster;
import com.montran.util.SessionFactoryUtil;

public class BookIssueDAO {
	
	private Session session;
	private Transaction transaction;
	private SessionFactory factory = SessionFactoryUtil.getFactory();

	public List<IssueMaster> getAllIssuedBookDetails() {
		session = factory.openSession();
		Query query = session.createQuery("from IssueMaster");
		List<IssueMaster> issuedBookList = query.list();
		session.close();
		return issuedBookList;
	}	
	
	public IssueMaster getIssuedBookById(String serial_no) {
		session=factory.openSession();
		IssueMaster issueMaster=session.find(IssueMaster.class,serial_no);
		session.close();
		return issueMaster;
	}
	
	public void issueNewBook(IssueMaster issueMaster) {
		session=factory.openSession();
		transaction=session.beginTransaction();
		session.save(issueMaster);
		transaction.commit();
		session.close();
	}
	
	public void deleteIssuedBook(String issue_id) {
		
		session=factory.openSession();
		transaction=session.beginTransaction();
		IssueMaster issueMaster=session.find(IssueMaster.class, issue_id);
		BookMaster bookMaster=session.find(BookMaster.class, issueMaster.getBookMaster().getBook_id());
		bookMaster.setBook_issued(0);
		MemberMaster memberMaster=session.find(MemberMaster.class,issueMaster.getMemberMaster().getMember_id());
		memberMaster.setTotal_book_issued(memberMaster.getTotal_book_issued()-1);
		session.update(bookMaster);
		session.update(memberMaster);
		session.delete(issueMaster);
		transaction.commit();
		session.close();
		
	}
	
	public void updateIssuedBook(IssueMaster issueMaster) {
		
		session=factory.openSession();
		transaction=session.beginTransaction();
		session.update(issueMaster);
		transaction.commit();
		session.close();
	}
	
}
