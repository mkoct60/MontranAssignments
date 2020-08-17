package com.montran.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.montran.dao.BookIssueDAO;
import com.montran.dao.BookMasterDAO;
import com.montran.dao.MemberMasterDAO;
import com.montran.form.BookIssueForm;
import com.montran.pojo.BookMaster;
import com.montran.pojo.IssueMaster;
import com.montran.pojo.MemberMaster;

public class BookIssueAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IssueMaster issueMaster = new IssueMaster();
		BookIssueForm bookIssueForm = (BookIssueForm) form;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		String issuedate;
		Random random = new Random();
		String issue_serial_no = "S" + String.valueOf(random.nextInt(99999999) + 10000000);
		MemberMaster memberMaster=null;
		BookMaster bookMaster=null;
		
		if(request.getParameter("submit_type").equals("Get Member")) {
			try {
				memberMaster = new MemberMasterDAO()
						.getMemberNameById(bookIssueForm.getMember_id().toUpperCase().replaceAll("\\s", ""));
				bookIssueForm.setIssue_serial_no(issue_serial_no);
				bookIssueForm.setName(memberMaster.getName());
				bookIssueForm.setMember_id(memberMaster.getMember_id());
				return mapping.findForward("working");
			} catch (NullPointerException e) {
				ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
				redirect.addParameter("error", "No Member found.");
				bookIssueForm.setName("");
				return redirect;
			}
		}
		if(request.getParameter("submit_type").equals("Get Book Details")) {
			if(bookIssueForm.getBook_id()=="") {
				ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
				redirect.addParameter("error", "Book ID is required.");
				return redirect;
			}
			try {
				bookMaster = new BookMasterDAO().geBookDetailsById(bookIssueForm.getBook_id().toUpperCase());
				bookIssueForm.setBook_title(bookMaster.getBook_title());
				bookIssueForm.setBook_author(bookMaster.getBook_author());
				return mapping.findForward("working");
			} catch (NullPointerException e) {
				ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
				redirect.addParameter("error", "No Book Found.");
				bookIssueForm.setBook_title("");
				bookIssueForm.setBook_author("");
				return redirect;
			}
		}
		if(request.getParameter("submit_type").equals("Issue Book")) {
			if(bookIssueForm.getName()=="") {
				ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
				redirect.addParameter("error", "Member Details Are Required.");
				return redirect;
			}
			if(bookIssueForm.getBook_author()=="" || bookIssueForm.getBook_title()=="") {
				ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
				redirect.addParameter("error", "Book Details Are Required.");
				return redirect;
			}
			try {
				memberMaster = new MemberMasterDAO()
					.getMemberNameById(bookIssueForm.getMember_id().toUpperCase());
				bookMaster = new BookMasterDAO().geBookDetailsById(bookIssueForm.getBook_id().toUpperCase());
			if (memberMaster.getTotal_book_issued() >= memberMaster.getBook_limit()) {
				ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
				redirect.addParameter("error", "Member's maximum book limit reached.");
				return redirect;
			} else if (bookMaster.getBook_issuable() == 0) {
				ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
				redirect.addParameter("error", "Book is not issuable.");
				return redirect;
			} else if (bookMaster.getBook_issued() == 1) {
				ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
				redirect.addParameter("error", "Book has already been issued to other member.");
				return redirect;
			}
			if (memberMaster.getMemberType().getMembertype_id() == 1) {
				{
					date = formatter.parse(bookIssueForm.getBook_issue_date());
					calendar.setTime(date);
					int day = calendar.get(Calendar.DATE);
					int month = calendar.get(Calendar.MONTH);
					calendar.set(Calendar.MONTH, month + 4);
					month = calendar.get(Calendar.MONTH);
					int year = calendar.get(Calendar.YEAR);
					issuedate = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
					bookIssueForm.setBook_return_date(issuedate);
				}
			} else {
				date = formatter.parse(bookIssueForm.getBook_issue_date());
				calendar.setTime(date);
				int day = calendar.get(Calendar.DATE);
				calendar.set(Calendar.DATE, day);
				day = calendar.get(Calendar.DATE) + 10;
				int month = calendar.get(Calendar.MONTH);
				int year = calendar.get(Calendar.YEAR);
				issuedate = String.valueOf(day) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
				bookIssueForm.setBook_return_date(formatter.format(issuedate));
			}
			memberMaster.setMember_id(bookIssueForm.getMember_id().toUpperCase());
			memberMaster.setTotal_book_issued(memberMaster.getTotal_book_issued() + 1);

			bookMaster.setBook_id(bookIssueForm.getBook_id().toUpperCase());
			bookMaster.setBook_issued(1);

			issueMaster.setMemberMaster(memberMaster);
			issueMaster.setBookMaster(bookMaster);
			issueMaster.setIssue_serial_no(bookIssueForm.getIssue_serial_no());
			issueMaster.setBook_issue_date(formatter.parse(bookIssueForm.getBook_issue_date()));
			System.out.println(bookIssueForm.getBook_issue_date());
			issueMaster.setBook_return_date(formatter.parse(bookIssueForm.getBook_return_date()));
			System.out.println(bookIssueForm.getBook_return_date());

			new MemberMasterDAO().updateMemberDetails(memberMaster);
			new BookMasterDAO().updateBookDetails(bookMaster);
			new BookIssueDAO().issueNewBook(issueMaster);
			
			bookIssueForm.setIssue_serial_no("");
			bookIssueForm.setMember_id("");
			bookIssueForm.setName("");
			bookIssueForm.setBook_id("");
			bookIssueForm.setBook_title("");
			bookIssueForm.setBook_author("");
			bookIssueForm.setBook_issue_date("");
			
			return mapping.findForward("success");
		} catch (NullPointerException e) {
				if(memberMaster==null) {
					ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
					redirect.addParameter("error", "Member ID is invalid.");
					return redirect;
				}
				if(bookMaster==null) {
					ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
					redirect.addParameter("error", "Book ID is Invalid.");
					return redirect;
				}
			}
		}
		
		ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
		redirect.addParameter("error", "Something Went Wrong.");
		return redirect;
	}
}
