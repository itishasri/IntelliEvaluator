<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
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

body {
    background-image: url("Images/green.jpg");
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    width: 100%;
    height: 100%;
    
}
.button1:active {
  background-color: #33adff;
  box-shadow: 0 5px #666;                    
  transform: translateY(4px);
}
.button2 {
  display: inline-block;
  padding: 15px 25px;
  font-size: 15px;
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
</style>
<body>
<form action=logout.jsp method="post">
      <input class ="button2" type="submit" name="logout" value="Logout">
      </form>
<center>
<h2><font color=white> <u>Welcome Admin</u></font></h2>
</center>
<table cellspacing="100">
<tr>
<td></td>
<td></td>
<td></td>
<td>
<div>
<button class="button1" onclick="location.href='ViewTeacherListServlet'">
 Manage Teachers
</button>
</div>
</td>
<td>
<div>
<button class="button1" onclick="location.href='ViewStudentListServlet'">
 Manage Students
</button>
</div>
</td>
</tr>
</table>

</body>
</html>