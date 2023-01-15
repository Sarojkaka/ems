<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.center-div {
	background-color: #ffffff;
	border: 1px solid #e3e3e3;
	width: 100%;
	height: 100%;
	margin-top: 100px;
	margin-right: 0px;
	float: right;
}

.container {
	max-width: 700px;
	width: 100%;
	background-color: #ffffff;
	padding: 25px 40px 80px 40px;
	border-radius: 5px;
	background-color: white;
}

form .user-details .input-box {
	margin-bottom: 15px;
	width: calc(100%/ 2 - 20px);
}

form .input-box span.details {
	display: block;
	font-weight: 500;
	margin-bottom: 5px;
}

.user-details .input-box input {
	height: 45px;
	width: 100%;
	outline: none;
	font-size: 16px;
	border-radius: 5px;
	padding-left: 15px;
	border: 1px solid #ccc;
	border-bottom-width: 2px;
	transition: all 0.3s ease;
}

.category select {
	height: 45px;
	width: 290px;
	outline: none;
	font-size: 16px;
	border-radius: 5px;
	padding-left: 15px;
	border: 1px solid #ccc;
	border-bottom-width: 2px;
	transition: all 0.3s ease;
	color: #8c8c8c;
}

.registerbtn {
	height: 45px;
	width: 290px;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 16px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: #2697FF;
}

.registerbtn:hover {
	/* transform: scale(0.99); */
	background: #1e88e5;
}
</style>
</head>
<body>
	<%
	String internalError = (String) request.getAttribute("internalError");
	if (internalError != null && internalError != "") {
		out.print("<span style='color:red;'>");
		out.print(internalError);
		out.print("</span><br/>");
	}
	%>

	<jsp:include page="admindash.jsp"></jsp:include>
	<section class="home-section">
		<div class="center-div">
			<form action="/ems/DepartmentRegistrationServlet" method="post">

				<%
				if (request.getAttribute("id") != null && request.getAttribute("id") != "") {
					out.print("<h1>Update Department</h1>");
				} else {
					out.print("<h1>Department Registration</h1>");
				}
				%>

				<div class="container">
					</br>
					<div class="user-details">


						<div class="input-box">
						<input type="hidden" name="id" value="${id}">
							<%
							if (request.getAttribute("id") == null || request.getAttribute("id") == "") {
								out.print("<span class='details' for='department'>Department Name</span>"
								+ "<input type='text' placeholder='Enter Department Name' name='department' id='department' value="
								+ request.getAttribute("department") + " required><br>");

							}
							%>
						</div>

						<%
						String errorMessage = (String) request.getAttribute("error");
						if (errorMessage != null && errorMessage != "") {
							out.print("<span style='color:red;'>");
							out.print(errorMessage);
							out.print("</span><br/>");
						}
						%>

						<div class="input-box">
							<span class="details" for="details">Department Details</span> <input
								type="text" placeholder="Enter Department Details" name="details"
								id="details" value="${details}" required>
						</div>


						<div class="button">
							<%
							if (request.getAttribute("id") != null && request.getAttribute("id") != "") {
								out.print(" <button type='submit' class='registerbtn'>Update</button>");
							} else {
								out.print(" <button type='submit' class='registerbtn'>Register</button>");
							}
							%>

						</div>
					</div>
				</div>
			</form>

		</div>
	</section>
</body>
</html>