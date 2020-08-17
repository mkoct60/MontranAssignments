<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.montran.pojo.MemberMaster"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
	
 <% LocalDateTime now=LocalDateTime.now(); %>
 <% DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue New Book</title>
<style type="text/css">
td{
	font-size:20px;
	padding:2px;
}
input{
font-size:20px;
}
</style>
</head>
<body style="text-align:center">
<h2>Issue New Book</h2>
<hr>	<br>
	<html:form action="bookIssueAction.do" method="post">
		<table style="margin:0px auto">
			<tr>
				<td>Member ID: </td>
				<td><html:text property="member_id" name="bookIssueform" maxlength="10" /></td>
				<td><input type="submit" name="submit_type" value="Get Member"></td>
			</tr>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td>Member Name: </td>
				<td><html:text name="bookIssueform" property="name" readonly="true"/></td>
			</tr>
			
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td>Book ID: </td>
				<td><html:text property="book_id" name="bookIssueform"/></td>
				<td><input type="submit" name="submit_type" value="Get Book Details"></td>
			</tr>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td>Book Title: </td>
				<td><html:text property="book_title" name="bookIssueform" readonly="true"/></td>
			</tr>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td>Book Author: </td>
				<td><html:text property="book_author" name="bookIssueform" readonly="true"/></td>
			</tr>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td>Date of Issue: </td>
				<td><input type="date" name="book_issue_date" style="width:100%" value="<%=dtf1.format(now) %>" /></td>
			</tr>
			<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
			<tr>
				<td></td>
				<td><input type="submit" name="submit_type" value="Issue Book"></td>

			</tr>
		</table>
	</html:form>
	<div style="color:red;margin:0px auto;font-size:18px;">
		<% if(request.getParameter("error")!=null) {
			out.print(request.getParameter("error"));
		}
		%>
		<html:errors/>
	</div>
</body>
</html>