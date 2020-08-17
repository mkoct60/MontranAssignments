package com.montran.action;

import java.util.List;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookIssueDAO;
import com.montran.pojo.IssueMaster;

public class IssuedBookAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) throws Exception {
	
		BookIssueDAO libraryDAO=new BookIssueDAO();
		List<IssueMaster> issuedbooklist=libraryDAO.getAllIssuedBookDetails();
		request.setAttribute("issuedbooklist", issuedbooklist);
		return mapping.findForward("success");
	}
}
