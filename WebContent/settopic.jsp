<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set Topic</title>
<script type="text/javascript">
document.getElementById("uploadBtn").onchange = function () {
   
	document.getElementById("uploadFile").value = this.value;
};
</script>
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
</style>
</head>
<body>
<form action="SetTopicServlet" method="post" enctype="multipart/form-data">
<br><br><br>
<center>
<div>
<b><font size="5" color=white>SET TOPIC</font> </b>
<br><br>
<input id="topic" name="topic" type="text" maxlength="50" style="width:250px; height:30px; border:1px solid #999999" /></center>
</div>
<br>
<br>
<center>
<table cellspacing="20">
<tr>
<td>
<div class="fileUpload btn btn-primary">
    <span><font color= white>Upload Sample 1</font></span>
    <input id="uploadBtn" type="file" class="upload sample 1" name="sample1"/>
</div>
<br>
<div class="fileUpload btn btn-primary">
    <span><font color= white>Upload Sample 2</font></span>
    <input id="uploadBtn" type="file" class="upload sample 2" name="sample2"/>
</div>
<br>
<div class="fileUpload btn btn-primary">
    <span><font color= white>Upload Sample 3</font></span>
    <input id="uploadBtn" type="file" class="upload sample 3" name="sample3" />
</div>
<br>
<div class="fileUpload btn btn-primary">
    <span><font color= white>Upload Sample 4</font></span>
    <input id="uploadBtn" type="file" class="upload sample 4" name="sample4" />
</div>
<br>
<div class="fileUpload btn btn-primary">
    <span><font color= white>Upload Sample 5</font></span>
    <input id="uploadBtn" type="file" class="upload sample 5" name="sample5" />
</div>
</td>

</tr>
</table>
</center>
<br>
<br><br>
<center>
<b><input class="button1" id="skip_Submit" name="skip_Submit" type="submit" value="Submit"/></b>
 </center>
 </form>
</body>
</html>

