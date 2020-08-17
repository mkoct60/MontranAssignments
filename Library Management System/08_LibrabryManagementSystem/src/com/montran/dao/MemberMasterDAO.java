package com.montran.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.montran.pojo.MemberMaster;
import com.montran.util.SessionFactoryUtil;

public class MemberMasterDAO {
	
	private Session session;
	Transaction transaction;
	private SessionFactory factory = SessionFactoryUtil.getFactory();
	
	public MemberMaster getMemberNameById(String student_faculty_id) {
		session = factory.openSession();
		MemberMaster memberMaster=session.find(MemberMaster.class, student_faculty_id);
		session.close();
		return memberMaster;
	}
	
	public void updateMemberDetails(MemberMaster memberMaster) {
		session=factory.openSession();
		transaction=session.beginTransaction();
		session.update(memberMaster);
		transaction.commit();
		session.close();
	}
	
}
