<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

<title>View Score</title>
<style>  
#chartdiv {
	width		: 60%;
	height		: 300px;
	font-size	: 11px;
}						
</style>
<%@page import="com.ie.pkg.StudentSignupBean,com.ie.pkg.ViewScoreBean"%>
<%
String rollno=(String)session.getAttribute("rollno");
StudentSignupBean ssb=new StudentSignupBean(rollno);
ssb.viewData();
String topic=(String)session.getAttribute("scoretopic");
ViewScoreBean vsbean=(ViewScoreBean)session.getAttribute("vsb");
int se=(int)session.getAttribute("se");
int ge=(int)session.getAttribute("ge");
int re=(int)session.getAttribute("re");
int w=(int)session.getAttribute("w");
%>
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script type="text/javascript">
            //load the Google Visualization API and the chart
            google.load('visualization', '1', {'packages': ['columnchart']});
 
            //set callback
            google.setOnLoadCallback (createChart);
 
            //callback function
            function createChart() {
 
                //create data table object
                var dataTable = new google.visualization.DataTable();
 
                //define columns
                dataTable.addColumn('string','Criteria');
                dataTable.addColumn('number', 'Grade');
 
                //define rows of data
                dataTable.addRows([['Spelling',<%=se%>], ['Grammar',<%=ge%>],['Relevance',<%=re%>],['Word Count', <%=w%>]]);
 
                //instantiate our chart object
                var chart = new google.visualization.ColumnChart (document.getElementById('chart'));
 
                //define options for visualization
                var options = {width: 600, height: 350, is3D: true, title:'Score' };
                
                //draw our chart
                chart.draw(dataTable, options);
 
            }
        </script>

</head>
<body>
<center>
<h1><font color=black><u >Your Score</u></font></h1>
</center>
<br>
<br>

<form method="post">

<table>
<tr><td></td><td></td><td><font color=black><b>Roll Number :  </b></font></td><td><font color=blue><b><%=rollno%></b></font></td></tr>
<tr><td></td><td></td><td><font color=black><b>Name :</b></font></td><td><font color=blue><b><%=ssb.getFname()+" "+ssb.getLname() %></b></font></td></tr>
<tr><td></td><td></td><td><font color=black><b>Email Id :  </b></font></td><td><font color=blue><b><%=ssb.getEmail() %></b></font></td></tr>
<tr><td></td><td></td><td><font color=black><b>Date of Birth :  </b></font></td><td><font color=blue><b><%=ssb.getDob() %></b></font></td></tr> 
<tr><td></td><td></td><td><font color=black><b>Topic : </b></font></td><td><font color=blue><b><%=topic %></b></font></td></tr>
</table>
</form>
<div id="chart"></div>
<table>
<tr><td></td><td><font color=black><b>Total Score :  </b></font></td><td><font color=blue><b><%=vsbean.getScore() %></b></font></td></tr><br>
<tr><td></td><td><font color=black><b>Remarks: :</b></font></td><td><font color=blue><b><%=vsbean.getRemark() %></b></font></td></tr><br>
</table>


								
</body>
</html>