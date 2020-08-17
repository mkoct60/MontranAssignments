package com.montran.pojo;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "issue_master")
public class IssueMaster {
	
	@Id
	@Check(constraints = "LIKE 'S%'")
	String issue_serial_no;
	
	@OneToOne(targetEntity = MemberMaster.class)
	@JoinColumn(name = "member_id")
	private MemberMaster memberMaster;
	
	@OneToOne(targetEntity = BookMaster.class)
	@JoinColumn(name = "book_id")
	private BookMaster bookMaster;
	
	private Date book_issue_date;
	
	private Date book_return_date;
	
	public IssueMaster() {
		// TODO Auto-generated constructor stub
	}

	public IssueMaster(String issue_serial_no, MemberMaster memberMaster, BookMaster bookMaster, Date book_issue_date,
			Date book_return_date) {
		super();
		this.issue_serial_no = issue_serial_no;
		this.memberMaster = memberMaster;
		this.bookMaster = bookMaster;
		this.book_issue_date = book_issue_date;
		this.book_return_date = book_return_date;
	}

	public String getIssue_serial_no() {
		return issue_serial_no;
	}

	public void setIssue_serial_no(String issue_serial_no) {
		this.issue_serial_no = issue_serial_no;
	}

	public MemberMaster getMemberMaster() {
		return memberMaster;
	}

	public void setMemberMaster(MemberMaster memberMaster) {
		this.memberMaster = memberMaster;
	}

	public BookMaster getBookMaster() {
		return bookMaster;
	}

	public void setBookMaster(BookMaster bookMaster) {
		this.bookMaster = bookMaster;
	}

	public Date getBook_issue_date() {
		return book_issue_date;
	}

	public void setBook_issue_date(Date book_issue_date) {
		this.book_issue_date = book_issue_date;
	}

	public Date getBook_return_date() {
		return book_return_date;
	}

	public void setBook_return_date(Date book_return_date) {
		this.book_return_date = book_return_date;
	}

	@Override
	public String toString() {
		return "IssueMaster [issue_serial_no=" + issue_serial_no + ", memberMaster=" + memberMaster + ", bookMaster="
				+ bookMaster + ", book_issue_date=" + book_issue_date + ", book_return_date=" + book_return_date + "]";
	}

}
