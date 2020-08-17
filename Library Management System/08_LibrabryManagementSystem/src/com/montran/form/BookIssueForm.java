package com.montran.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class BookIssueForm extends ActionForm {

	private String issue_serial_no;
	private String member_id;
	private String name;
	private String book_id;
	private String book_title;
	private String book_author;
	private String book_issue_date;
	private String book_return_date;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors actionErrors = new ActionErrors();
		if (getMember_id() == null || getMember_id().equals("")) {
			actionErrors.add("common.name.err", new ActionMessage("error.common.mcode.required"));
		} else if (getName() != "") {
			if (getBook_id() == null || getBook_id().replaceAll("\\s","").equals("")) {
				actionErrors.add("common.name.err", new ActionMessage("error.common.bid.required"));
			}else if(getMember_id()!="" && getName()!="" && getBook_id()!="" && getBook_title()!="" && getBook_author()!="" && getBook_return_date()!="") {
				if(getBook_issue_date()==null || getBook_issue_date().equals("")) {
					actionErrors.add("common.name.err", new ActionMessage("error.common.dof.required"));
				}
			}
		}
		return actionErrors;

	}

	public BookIssueForm() {
		// TODO Auto-generated constructor stub
	}

	public BookIssueForm(String issue_serial_no, String member_id, String name, String book_id,
			String book_title, String book_author, String book_issue_date, String book_return_date) {
		super();
		this.issue_serial_no = issue_serial_no;
		this.member_id = member_id;
		this.name = name;
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_issue_date = book_issue_date;
		this.book_return_date = book_return_date;
	}

	public String getIssue_serial_no() {
		return issue_serial_no;
	}

	public void setIssue_serial_no(String issue_serial_no) {
		this.issue_serial_no = issue_serial_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBook_issue_date() {
		return book_issue_date;
	}

	public void setBook_issue_date(String book_issue_date) {
		this.book_issue_date = book_issue_date;
	}

	public String getBook_return_date() {
		return book_return_date;
	}

	public void setBook_return_date(String book_return_date) {
		this.book_return_date = book_return_date;
	}

	@Override
	public String toString() {
		return "BookIssueForm [issue_serial_no=" + issue_serial_no + ", member_id=" + member_id + ", name=" + name
				+ ", book_id=" + book_id + ", book_title=" + book_title + ", book_author=" + book_author
				+ ", book_issue_date=" + book_issue_date + ", book_return_date=" + book_return_date + "]";
	}

}
