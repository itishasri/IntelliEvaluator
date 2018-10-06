<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Student List</title>
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
      <input type="submit" class="button2" name="logout" value="logout">
      </form>
<center>

<form action="TeacherViewStudentServlet" method="post" onsubmit="return validateForm(this);" >
<script type="text/javascript">
 function validateForm(frm) {
 if (frm.rollno.value == "view") {alert('rollno is required.');return false;}
return true;
 }
 </script>
 
 <%@page import="java.util.*" %>
 <%
 ArrayList<String> tl=new ArrayList<String>();
 tl=(ArrayList<String>)session.getAttribute("studentlist");
 %>
 
<h1><font color=white><b>Roll Number of Students</b></font></h1>
<h2><table>

 <% 
  for(String topic: tl)
  {
	  
	 out.println(" <tr><td><input type='radio' name='rollno' value="+topic+"></td><td><label for='ID'>"+topic+" </label></td></tr>");
	 
  }
  %>
 </table></h2>
<b> 
<table cellspacing=20>   
<tr> <td><button class="button1" type="submit" name="manage" value="view">View</button></td>
<td> <button class="button1" type="submit" name="manage" value="Delete">Delete</button></td>
 <td><button class="button1" type="submit" name="manage" value="Getscore">GetScore</button></td></tr>
   </table></b>
    
</form>
</center>
</body>
</html>