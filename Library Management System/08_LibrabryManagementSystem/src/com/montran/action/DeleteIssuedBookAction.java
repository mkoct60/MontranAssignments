package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookIssueDAO;

public class DeleteIssuedBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		BookIssueDAO bookIssueDAO=new BookIssueDAO();
		String issue_id=request.getParameter("id");
		bookIssueDAO.deleteIssuedBook(issue_id);
		return mapping.findForward("success");
	}
}
