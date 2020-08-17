<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.montran.dao.BookIssueDAO"%>
<%@page import="com.montran.pojo.IssueMaster"%>
<%@page import="com.montran.form.BookIssueForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%
	IssueMaster issueMaster = new BookIssueDAO().getIssuedBookById(request.getParameter("id"));
	String date=new SimpleDateFormat("yyyy-MM-dd").format(issueMaster.getBook_issue_date());
	request.setAttribute("id",issueMaster.getIssue_serial_no());

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
<style type="text/css">
td {
	font-size: 20px;
	padding: 2px;
}

input {
	font-size: 20px;
}
</style>
</head>
<body style="text-align: center">
	<h2>Update Details</h2>
	<hr>
	<br>
	<html:form action="updateBook.do?id=${id}"    method="post">
		<table style="margin: 0px auto">
			<tr>
				<td>Member ID:</td>
				<td><html:text property="member_id"
						value="<%=issueMaster.getMemberMaster().getMember_id()%>"
						name="bookIssueform" maxlength="10" readonly="true" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Member Name:</td>
				<td><html:text name="bookIssueform" property="name"
						value="<%=issueMaster.getMemberMaster().getName()%>"
						readonly="true" /></td>
			</tr>

			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Book ID:</td>
				<td><html:text property="book_id" name="bookIssueform"
						value="<%=issueMaster.getBookMaster().getBook_id()%>"
						readonly="true" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Book Title:</td>
				<td><html:text property="book_title" name="bookIssueform"
						value="<%=issueMaster.getBookMaster().getBook_title()%>"
						readonly="true" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Book Author:</td>
				<td><html:text property="book_author" name="bookIssueform"
						value="<%=issueMaster.getBookMaster().getBook_author()%>"
						readonly="true" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>Date of Issue:</td>
				<td><input type="date" name="book_issue_date"
					value="<%=date%>" style="width: 100%" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><input type="submit" name="submit_type" value="Update"></td>

			</tr>
		</table>
	</html:form>
</body>
</html>