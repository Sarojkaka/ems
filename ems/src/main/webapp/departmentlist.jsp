<%@page import="java.util.ArrayList"%>
<%@page import="ems.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department List</title>
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
</head>
<body>
<%
	//Used to display message from edit method, which is forwarded by request dispatcher
	String message = (String) request.getAttribute("message");
	if (message != null && message != "") {
		out.print("<span style='color:green;'>");
		out.print(message);
		out.print("</span><br/><br/><br/><br/>");
	}
	%>

	<%
	//Used to success message from delete method
	message = (String) request.getParameter("message");
	if (message != null && message != "") {
		out.print("<span style='color:green;'>");
		out.print(message);
		out.print("</span><br/><br/><br/><br/>");
	}
	%>
		<jsp:include page="admindash.jsp"></jsp:include> 
	<section class="home-section">
	<div class="center">
	<h1 style="text-align: center;">Department List</h1>
		<table>
			<a href="/ems/depregister"><button class="btn-register">Add Department</button></a>
			<br>
			<br>
			<br>

			<tr>
				<th>SN</th>
				<th>Department Name</th>
				<th>Department List</th>

				<th></th>
				<th></th>
			</tr>
						<%
			List<Department> deps = (List<Department>) request.getAttribute("departments");

			for (Department dep : deps) {
				out.print("<tr>");
				out.print("<td>" + dep.getDepId() + "</td>");
				out.print("<td>" + dep.getDepartment() + "</td>");
				out.print("<td>" + dep.getDetails() + "</td>");

				out.print("<td> <a href='/ems/depregister?id=" + dep.getDepId() + "'> <button style='background: #2697FF;'>Edit</button></td>");
				out.print(
				"<td> <form action='/ems/department' method='post'><input style='' type='hidden' name='method' value='delete' > <input type='hidden' name='id' value='"
						+ dep.getDepId() + "'/> <button>Delete</button></form></td>");
				out.print("</tr>");
			}
			%>

		</table>
	</div>
	</section>

</body>
</html>