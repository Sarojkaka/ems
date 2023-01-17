<%@page import="java.util.ArrayList"%>
<%@page import="ems.Employee"%>
<%@page import="ems.Department"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<style>
table {
	font-family: arial, sans-serif;
	width:100%
	}

td, th {
	
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
.center {
	background-color: #ffffff;
	border: 1px solid #e3e3e3;
	width:100%;
	height: 100%;
	margin-top: 100px;
	margin-right: 0px;
	float: right;
}
.btn-register{
border-radius: 4px;
color: #fff;
font-size: 20px;
background: #2697FF;
}
.btn-register:hover {
	background:#4d83ff;
}
button{
border-radius: 4px;
color: #fff;
font-size: 15px;
background: #ff0000;
border: none;
}
button:hover {
	background:#ff4d4d;
}
</style>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

</head>
<body>

<%-- 	
// 	//Used to display message from edit method, which is forwarded by request dispatcher
// 	String message = (String) request.getAttribute("message");
// 	if (message != null && message != "") {
// 		out.print("<span style='color:green;'>");
// 		out.print(message);
// 		out.print("</span><br/><br/><br/><br/>");
// 	}
--%>

<%-- 
// 	//Used to success message from delete method
// 	message = (String) request.getParameter("message");
// 	if (message != null && message != "") {
// 		out.print("<span style='color:green;'>");
// 		out.print(message);
// 		out.print("</span><br/><br/><br/><br/>");
// 	}
--%>
	 <sql:setDataSource var="con" password="root" driver="com.mysql.cj.jdbc.Driver" user="root" url="jdbc:mysql://localhost:3306/ems"/>
	 
	 <sql:query var="resultSet" dataSource="${con}">
	 	select * from employee;

	 	
	 </sql:query>
	 


	 
<%-- 	<c:forEach var="row" items="${resultSet.rows}"> --%>
<%-- 		<span>${row.first_name}</span> --%>
<%-- 		<span>${row.last_name}</span> --%>
<!-- 		<br> -->
<%-- 	</c:forEach>	  --%>
	 
	<c:if test="${message != null && message != ''}">
	
		<span style="color:green;">${message }</span><br/><br/><br/><br/>
	</c:if>
	<jsp:include page="admindash.jsp"></jsp:include> 
	<section class="home-section">
	<div class="center">
		<h1 style="text-align: center;">Employee List</h1>
		<%
		Date joinDate = new Date();
		pageContext.setAttribute("regDate", joinDate);
		
	%>
		<table>
			<a href="/ems/register"><button class="btn-register">Register</button></a>
			<br>
			<br>
			<br>

			<tr>
				<th>SN</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Username</th>
				<th>Employee Type</th>
				<th>Salary</th>
				<th>Join Date</th>
				<th>Department</th>
				<th></th>
				<th></th>
			</tr>

		<c:forEach var="emp" items="${employees}">
			<tr>
				<td>${emp.id}</td>
			
				<td>	<c:out value="${fn:toUpperCase(emp.firstName) }" /></td>
				<td>${emp.lastName}</td>
				<td>${emp.gender}</td>
				<td>${emp.username}</td>
				<td>${emp.employeeType}</td>
				<td><fmt:formatNumber currencySymbol="$" type="currency">10000000</fmt:formatNumber></td>
				<td><fmt:formatDate value="${regDate}" /></td>
				
				
				<!--displaying data from Administration -->
<%-- 			 <sql:query var="resultSet" dataSource="${con}"> --%>
<!-- 	 				select dep_name from department inner join employee on department.dep_id = employee.dep_id where emp; -->
	
<%-- 	 		</sql:query> --%>
<%-- 						<c:forEach var="row" items="${resultSet.rows}"> --%>
<%-- 								<td value="${dep_id}">${row.dep_name}</td> --%>
<%-- 								</c:forEach> --%>
<td>${emp.depname}</td>


				<td><a href="<c:url value='register?id=${emp.id}' /> " ><button style='background: #2697FF;'>Edit</button> </a></td>
<%-- 				<td><a href="/register?id=${emp.id} "> Edit </a></td> --%>
				<td>
					<form action='/ems/employee' method='post'>
						<input type='hidden' name='method' value='delete'> 
						<input type='hidden' name='id' value='${emp.id}' /> 
						<input type='submit' value='Delete' style="border-radius: 4px;color: #fff;font-size: 15px;background: #ff0000;border: none;">
					</form>
				</td>
			</tr>
		</c:forEach>

<%-- 			
// 			List<Employee> emps = (List<Employee>) request.getAttribute("employees");

// 			for (Employee emp : emps) {
// 				out.print("<tr>");
// 				out.print("<td>" + emp.getId() + "</td>");
// 				out.print("<td>" + emp.getFirstName() + "</td>");
// 				out.print("<td>" + emp.getLastName() + "</td>");
// 				out.print("<td>" + emp.getGender() + "</td>");
// 				out.print("<td>" + emp.getUsername() + "</td>");
// 				out.print("<td>" + emp.getEmployeeType() + "</td>");
// 				out.print("<td> <a href='/ems/register?id=" + emp.getId() + "'> <button style='background: #2697FF;'>Edit</button></td>");
// 				out.print(
// 				"<td> <form action='/ems/employee' method='post'><input style='' type='hidden' name='method' value='delete' > <input type='hidden' name='id' value='"
// 						+ emp.getId() + "'/> <button>Delete</button></form></td>");
// 				out.print("</tr>");
// 			}
--%>

		</table>
	</div>
	</section>
</body>
</html>