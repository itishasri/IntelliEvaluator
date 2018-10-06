<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Home</title>
<style>
body {
    background-image: url("Images/green.jpg");
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    width: 100%;
    height: 100%;
}
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
</head>
<body>
<form action=logout.jsp method="post">
      <input class="button2" type="submit" name="logout" value="logout">
      </form>
<%@page import="com.ie.pkg.TeacherLoginBean"%> 
<%  
TeacherLoginBean bean=(TeacherLoginBean)session.getAttribute("LoginBean");
out.println("<h1><center><font color='white'>");
out.println("Welcome! "+bean.tname);
out.println("</font></h1></center>");
%>  
<center>
 <img src="Images/giphy.gif">
 </center>
 <center>
 <table cellspacing="80">
 <tr>
 <td>
 <button class="button1" onclick="location.href='settopic.jsp'">
Set Essay Topic
</button>
 </td>
 <td>
 <button class="button1" onclick="location.href='editprofileteacher.jsp'">
Edit Details
</button>
 </td>
 </tr>
 <tr>
 <td>
 <button class="button1" onclick="location.href='ViewStudentListServlet'">
Manage Student
</button>
 </td>
 <td>
<button class="button1" onclick="location.href='ViewProfileTeacherServlet'">
View Profile
</button>
 </td>
 </tr>
 </table>
 </center>
 </table>
</body>
</html>