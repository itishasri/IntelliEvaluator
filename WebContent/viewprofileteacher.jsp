<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Profile</title>

<style>
body {
    background-image: url("Images/green.jpg");
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    width: 100%;
    height: 100%;
}
.img-circle {
    border-radius: 100%;
    height:20%;
    width:20%;
}
.table
{
 font-size: 130%;
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
</style>
</head>
<body>
<form action=logout.jsp method="post">
      <input class="button1" type="submit" name="logout" value="Logout" style="width:100px;height:45px;">
      </form>
<center>
<form method="post">

<%@page import="com.ie.pkg.TeacherSignupBean"%>
<%
TeacherSignupBean tvb= (TeacherSignupBean)session.getAttribute("tvb1");
System.out.println(tvb.getTid());
%>
<h1><font color=white><u color=white>Personal Information</u></font></h1>
<img class="img-circle" src="<%= tvb.getImage() %>" alt="profile">
<br><br><br>

<table cellpadding=4  class="table">

<tr><td><font color=white><b>Teacher Id</b></font></td><td><font color=white><b> :  </b></font></td><td><font color=white><b><%=tvb.getTid() %></b></font></td></tr>
<tr><td><font color=white><b>First Name</b></font></td><td><font color=white><b> :  </b></font></td><td><font color=white><b><%=tvb.getFname() %></b></font></td></tr>
<tr><td><font color=white><b>Last Name</b></font></td><td><font color=white><b> :  </b></font></td><td><font color=white><b><%=tvb.getLname() %></b></font></td></tr>
<tr><td><font color=white><b>Email Id</b></font></td><td><font color=white><b> :  </b></font></td><td><font color=white><b><%=tvb.getEmail() %></b></font></td></tr>
<tr><td><font color=white><b>Date of Birth</b></font></td><td><font color=white><b> : </b></font></td><td><font color=white><b><%=tvb.getDob() %></b></font></td></tr>
</table>
</form>
</center>

</body>
</html>