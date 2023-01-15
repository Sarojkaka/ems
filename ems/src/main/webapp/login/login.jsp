<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="loginstyle.css">
</head>
<body>

	<form method="post" action="/ems/login">
		<main>
			<div class="row">
				<div class="colm-form">
					<div class="form-container">
					<span style="color: red;">${error}</span>
						<div class="brand-logo">
							<img src="logo.png" alt="logo">
						</div>
						<h4>Welcome to EMS</h4>
						<h6 class="font-weight-light">Sign in to continue.</h6>
						<input type="text" placeholder="Enter Username" name="username"
							required="required"> <input type="password"
							name="password" placeholder="Enter Password" required="required">
							
							
						<button class="btn-login">Sign In</button>


					</div>
				</div>
			</div>
			
		</main>
	</form>

</body>
</html>




				