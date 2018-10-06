<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.button1 {
  display: inline-block;
  padding: 15px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;	
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #33adff;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button1:hover {background-color: #3e8e41}

.button1:active {
  background-color: #33adff;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
.button2 {
  display: inline-block;
  padding: 15px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;	
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #33adff;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button2:hover {background-color: #3e8e41}

.button2:active {
  background-color: #33adff;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
.button3 {
  display: inline-block;
  padding: 15px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;	
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #33adff;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
  
}

.button3:hover {background-color: #3e8e41}

.button3:active {
  background-color: #33adff;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
body{
 background-image: url("Images/green.jpg");
}

</style>
</head>
<body style="height: 276px; " >
<br>
<center>
<h2><b><u>Login or Register</u></b></h2>
</center>
<center>
<table cellspacing="130">
<tr>
<td>
<button class="button1" onclick="location.href='teacherlog.jsp'">
Teacher Login
</button>
<br>
<a href="teachersignup.jsp" style="color: white;" onmouseover="this.style.color='blue';" onmouseout="this.style.color='blue';"><center><b><h3>Register Here</h3></b></center></a>
</td>
<td>
<button class="button2" onclick="location.href='studentlog.jsp'">
Student Login
</button>
<br>
<a href="studentsignup.jsp" style="color: white;" onmouseover="this.style.color='blue';" onmouseout="this.style.color='blue';" ><center><b><h3>Register Here</h3></b></center></a>
</td>
</tr>
</table>
<center>
<button class="button3" onclick="location.href='adminlogin.jsp'">
Admin Login
</button>
</center>
</body>
</html>
