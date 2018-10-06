<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Essay Test</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
.btn-group
{
margin-left:1050px;
}
</style>
<script>
var sUserAgent = navigator.userAgent;
var isOpera = sUserAgent.indexOf("Opera")>-1;
var isIE = sUserAgent.indexOf("compatible")>1 && sUserAgent.indexOf("MSIE")>1 && !isOpera;
function textCounter(){
 var area = document.getElementById('wordCountCalc');
 var formcontent;
 if(area.message1.value.length != 0){
  var reg;
  reg = /^\s/gi;
  formcontent = area.message1.value.replace(reg,'');  // remove white space at start or string
  reg = /\t+/g;
  formcontent = formcontent.replace(reg,' '); // remove any tab characters
  reg = /\s+/g;
  formcontent = formcontent.split(reg); // split string by spaces
  if ( isIE ) {
   area.len.value = formcontent.length;
  } else {
   if ( area.message1.value.charAt(area.message1.value.length-1)==' ' ||     area.message1.value.charAt(area.message1.value.length-1)=='\n' ) {
    area.len.value = formcontent.length-1;
   } else {
    area.len.value = formcontent.length;
   };
  };
 }else{
  area.len.value = 0;
 };
};
</script>
</head>
<body>

<br><br><br><br>

 <form action="StudentEditorServlet" method="post" id="wordCountCalc">
 <%@page import="java.util.*" %>
 <%
 ArrayList<String> tl=new ArrayList<String>();
 tl=(ArrayList<String>)session.getAttribute("topiclist");
 %>
 <div class="btn-group" >
  <button data-toggle="dropdown" class="btn btn-default dropdown-toggle" >Topic <span class="caret"></span></button>
    <ul class="dropdown-menu noclose" > 
  <%
  for(String topic:tl)
  {
  %>
    <li><input type="radio" id="ID" name="essaytopic" value="<%= topic%>"><label for="ID"><%= topic %></label></li>
   <%} %> </ul>
</div>
<center><textarea name="message1" rows="20" cols="68" onkeydown="textCounter()" onkeyup="textCounter()" style="border:solid 3px orange;"></textarea></center>
<center><font color=white><h4>Word Count:</h4></font><input readonly="readonly" size="15" type="text" name="len" maxlength="10" value="0" /></center>
<br>
<center>
<button class="button1" type="submit">
Submit Essay
</button>
</center>
</form>
</body>
</html>