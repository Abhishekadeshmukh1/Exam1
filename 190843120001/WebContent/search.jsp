<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.Student.Daos.*,com.Student.bean.*,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String id=request.getParameter("prn");

int i=Integer.parseInt(id);


Student s=StudentDao.search(i);

List<Student> list=StudentDao.getAllRecords(i);
request.setAttribute("list",list);

int a=0;
a=s.getPrn();

if(a==0)
{
	response.sendRedirect("searchstudent.jsp");
}
else
{
	

%>

<%=s.getPrn() %>

<%=s.getCname() %>
<%=s.getModuleno() %>

<c:forEach items="${list}" var="u">
<tr>


<td>${u.getmoduleno()}</td>
<td>${u.getcname()}</td>
</tr>

</c:forEach>

<%
}
%>


</body>
</html>