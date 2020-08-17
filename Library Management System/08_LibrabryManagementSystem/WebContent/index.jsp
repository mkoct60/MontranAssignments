<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
th {
	padding-left: 15px;
	padding-right: 15px;
	padding-top: 5px;
	padding-bottom: 5px;
}

td {
	padding-left: 15px;
	padding-right: 15px;
	padding-top: 5px;
	padding-bottom: 5px;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	border-radius: 5px;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}
</style>
</head>
<body style="text-align: center;">
	<h3>Library Book Details</h3>
	<hr>
	<table border="1" style="text-align: center; margin: 0px auto;">
	
		<%
			if (request.getAttribute("issuedbooklist") != null && !request.getAttribute("issuedbooklist").toString().equals("[]")) {
		%>
		<tr>
			<th>Issue Serial No</th>
			<th>Member Code</th>
			<th>Member Name</th>
			<th>Member Type</th>
			<th>Book Code</th>
			<th>Book Name</th>
			<th>Date of Issue</th>
			<th>Date of Return</th>
		</tr>
		<logic:iterate name="issuedbooklist" id="allIssuedBook">
			<tr>
				<td><bean:write name="allIssuedBook" property="issue_serial_no" /></td>
				<td><bean:write name="allIssuedBook"
						property="memberMaster.member_id" /></td>
				<td><bean:write name="allIssuedBook"
						property="memberMaster.name" /></td>
				<td><bean:write name="allIssuedBook"
						property="memberMaster.memberType.member_type" /></td>
				<td><bean:write name="allIssuedBook"
						property="bookMaster.book_id" /></td>
				<td><bean:write name="allIssuedBook"
						property="bookMaster.book_title" /></td>
				<td><bean:write name="allIssuedBook" property="book_issue_date" /></td>
				<td><bean:write name="allIssuedBook"
						property="book_return_date" /></td>
				<td><html:link href="deleteIssuedBook.do" paramId="id"
						paramName="allIssuedBook" paramProperty="issue_serial_no"
						onclick="return confirm('Do You really want to delete this record?')">Delete</html:link></td>
				<td><html:link href="updateBook.jsp" paramId="id"
						paramName="allIssuedBook" paramProperty="issue_serial_no">Update</html:link></td>
			</tr>
		</logic:iterate>
		<%
			}else{
				out.print("No Record Found.! ");
			}
		%>
	</table>
	<br>
	<div style="margin: 0px auto;">
		<a class="button" href="newBookIssue.jsp">Issue New Book</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
</body>
</html>
