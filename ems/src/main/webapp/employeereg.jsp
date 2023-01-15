<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
if (request.getAttribute("id") != null && request.getAttribute("id") != "") {
	out.print(" <title>Employee Update</title>");
} else {
	out.print("<title>Employee Registration</title>");
}
%>
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

.container{
  max-width: 700px;
  width: 100%;
  background-color: #ffffff;
  padding: 25px 40px 80px 40px;
  border-radius: 5px;
  background-color: white;

}



form .user-details .input-box{
  margin-bottom: 15px;
  width: calc(100% / 2 - 20px);
}
form .input-box span.details{
  display: block;
  font-weight: 500;
  margin-bottom: 5px;
}
.user-details .input-box input{
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

.category select{
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
.registerbtn{
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
.registerbtn:hover{
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
			<form action="/ems/EmployeeRegistration" method="post">
    
    <%
		if (request.getAttribute("id") != null && request.getAttribute("id") != "") {
			out.print("<h1>Update Employee</h1>");
		} else {
			out.print("<h1>Register</h1>");
		}
	%>

				<div class="container">
					<h1>Employee Registration</h1>
					</br>
					<div class="user-details">
						<div class="input-box">
						<input type="hidden" name="id"  value="${id}" >
							<span class="details" for="firstname">First Name</span> <input
								type="text" placeholder="Enter First Name" name="firstName"
								id="firstName" value="${firstName}" required>
						</div>
						<div class="input-box">
							<span class="details" for="lastName">Last Name</span> <input
								type="text" placeholder="Enter lastName" name="lastName"
								value="${lastName}" id="lastName" required>
						</div>
						<div for="gender">
							<span class="gender-title" for="gender">Gender</span>
							<div class="category">
								<select name="gender" value="${gender}">
									<option value="">Select Gender</option>
									<option value="MALE">MALE</option>
									<option value="FEMALE">FEMALE</option>
									<option value="OTHERS">OTHERS</option>
								</select>
							</div>
						</div>
						
						<div class="input-box">
<!-- 							 <input -->
<!-- 								type="text" placeholder="Enter username" name="username" -->
<%-- 								id="username" value="${username}" required> --%>
						
						<%
		if (request.getAttribute("id") == null || request.getAttribute("id") == "") {
			out.print("<span class='details' for='username'>Username</span>" +
				    "<input type='text' placeholder='Enter username' name='username' id='username' value=" +
				    		request.getAttribute("username") +" required><br>");
			
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
							<span class="details" for="password">Password</span> <input
								type="password" placeholder="Enter password" name="password"
								id="password" value="${password}" required>
						</div>
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


			</form>

		</div>
	</section>
</body>
</html>

