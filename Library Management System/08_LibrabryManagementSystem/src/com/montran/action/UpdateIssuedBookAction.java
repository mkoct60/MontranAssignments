package com.montran.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.montran.dao.BookIssueDAO;
import com.montran.form.BookIssueForm;
import com.montran.pojo.IssueMaster;

public class UpdateIssuedBookAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		BookIssueForm bookIssueForm=(BookIssueForm)form;
		String serial_no=request.getParameter("id");
		try {
			IssueMaster issueMaster=new BookIssueDAO().getIssuedBookById(serial_no);
			Date issue_date=formatter.parse(bookIssueForm.getBook_issue_date());
			if (issueMaster.getMemberMaster().getMemberType().getMembertype_id() == 1) {
				{
		
					calendar.setTime(issue_date);
					int day = calendar.get(Calendar.DATE);
					int month = calendar.get(Calendar.MONTH);
					calendar.set(Calendar.MONTH, month + 4);
					month = calendar.get(Calendar.MONTH);
					int year = calendar.get(Calendar.YEAR);
					String issuedate = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
					bookIssueForm.setBook_return_date(issuedate);
				}
			} else {
				
				calendar.setTime(issue_date);
				int day = calendar.get(Calendar.DATE);
				calendar.set(Calendar.DATE, day);
				day = calendar.get(Calendar.DATE) + 10;
				int month = calendar.get(Calendar.MONTH);
				int year = calendar.get(Calendar.YEAR);
				String issuedate = String.valueOf(day) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
				bookIssueForm.setBook_return_date(formatter.format(issuedate));
			}
			issueMaster.setBook_return_date(formatter.parse(bookIssueForm.getBook_return_date()));
			issueMaster.setBook_issue_date(issue_date);
			new BookIssueDAO().updateIssuedBook(issueMaster);
			return mapping.findForward("success");
			
		}catch (NullPointerException e) {
			ActionRedirect redirect = new ActionRedirect(mapping.findForward("working"));
			redirect.addParameter("error", "Something Went Wrong.");
			return redirect;
		}
	}
}
