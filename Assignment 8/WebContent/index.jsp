<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!  Set<String> productSet=new LinkedHashSet<String>(); %>

<form action="" method="post">
Product: <input type="text" name="product">
<input type="submit" value="Print">
</form>
<hr>
Suggestions:
<% 
if(request.getParameter("product")!=null ||application.getAttribute("product")!=null){
	//application.removeAttribute("product");
	if(application.getAttribute("product")==null){
		productSet.add(request.getParameter("product"));
		application.setAttribute("product", productSet);
	}else if(request.getParameter("product")!=null){
		productSet.add(request.getParameter("product"));
		application.setAttribute("product", productSet);
	}
	LinkedHashSet<String> productList=(LinkedHashSet<String>)application.getAttribute("product");
	int size=productList.size();
	int count=1;
	for(String product:productList){
		if(count==size){
			out.print(product);
		}
		else{
			out.print(product+", ");
		}
		count++;
	}
}
%>
</body>
</html>