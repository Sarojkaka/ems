<%@page import="ems.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="admincss.css">
    <style>

#week-schedule {
  margin: auto;
  width: 1100px;
  display: grid;
  grid-template-columns: repeat(7, 1fr);
  grid-template-rows: 1fr repeat(5, auto) ;
  gap: 3px;
  font-family: 'Raleway', sans-serif;
}
.schedule-day {
  text-align: center;
  background-color: lightgrey; 
  border-radius: 7px;
}

.schedule-day h1 {
  margin-block-start: 3px;
  margin-block-end: 3px;
  font-weight: 400;
  font-size: 30px;
}
.all-shifts {
  padding-top: 7px;
  text-align: center;
}
.employee-shift {
  border-radius: 7px;
  margin-top:5px;
}
.employee-shift h2 {
  margin-block-start: 3px;
  margin-block-end: 3px;
  font-size: 20px;
  font-weight: 700;
}
.employee-shift p {
  margin-block-start: 3px;
  margin-block-end: 3px;
}
.blue {
  background-color: #6DD3CE;
  color: ;
}
.red {
  background-color: #A13D63;
  color: #fff;
}
.green {
  background-color: #C8E9A0;
}
.orange {
  background-color: #F7A278;
}
.purple {
  background-color: #351E29;
  color: #fff;
}
.empty {
  border-style: dotted;
  border-width: 3px;
  background-color: #fff;
  color: red;
}
</style>
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="sidebar">
    <div class="logo-details">
      <img src="logo.png">EMS SYSTEM
    </div>
    <ul class="nav-links">
			<li><a href="admindash.jsp" class="active"> <i class='bx bx-grid-alt'></i>
					<span class="links_name">Dashboard</span>
			</a></li>
			<li><a href="/ems/employee"> <i class='bx bx-user'></i> <span
					class="links_name">Employee</span>
			</a></li>
			<li><a href="/ems/department"> <i class='bx bx-list-ul'></i> <span
					class="links_name">Department</span>
			</a></li>
			<li><a href="/ems/schedulelist"> <i class='bx bx-pie-chart-alt-2'></i> <span
					class="links_name">Schedule</span>
			</a></li>
			<li><a href="#"> <i class='bx bx-coin-stack'></i> <span
					class="links_name">Payroll</span>
			</a></li>
			<li><a href="#"> <i class='bx bx-cog'></i> <span
					class="links_name">Setting</span>
			</a></li>
			<li class="log_out"><a href="./login/login.jsp"> <i class='bx bx-log-out'></i>
					<span class="links_name">Log out</span>
			</a></li>
		</ul>
  </div>
  <section class="home-section">
    <nav>
      <div class="sidebar-button">
        <i class='bx bx-menu sidebarBtn'></i>
        <span class="dashboard">Dashboard</span>
      </div>
      <div class="search-box">
        <input type="text" placeholder="Search...">
        <i class='bx bx-search' ></i>
      </div>
<!--       <div class="profile-details"> -->
<!--         <img src="images/profile.jpg" alt=""> -->
<%--         <span class="admin_name"><% --%>
//  Employee emp = (Employee) request.getSession().getAttribute("user");
<%--  out.print(emp.getFirstName() + " " + emp.getLastName());%></span> --%>
<!--         <i class='bx bx-chevron-down' ></i> -->
<!--       </div> -->
    </nav>
  </section>

  <script>
   let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".sidebarBtn");
sidebarBtn.onclick = function() {
  sidebar.classList.toggle("active");
  if(sidebar.classList.contains("active")){
  sidebarBtn.classList.replace("bx-menu" ,"bx-menu-alt-right");
}else
  sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
}
 </script>

</body>
</html>
