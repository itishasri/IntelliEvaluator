package com.ie.pkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentEditorBean {
private String topic;
private String rollno;
private String essay;
public StudentEditorBean(String rollno)
{
	this.rollno=rollno;
}
public StudentEditorBean(String topic,String rollno,String essay)
{
	this.topic=topic;
	this.rollno=rollno;
	this.essay=essay;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}
public String getRollno() {
	return rollno;
}
public void setRollno(String rollno) {
	this.rollno = rollno;
}
public String getEssay() {
	return essay;
}
public void setEssay(String essay) {
	this.essay = essay;
}
public ArrayList<String> getTopicList()
{
	ResultSet rs=null;
	ArrayList<String> topiclist=new ArrayList<String>();
	try
	{
	DatabaseConnect db=new DatabaseConnect();
	Connection con= db.getDBConnection();
	String query="(select essaytopic from sampleessay) minus (select essaytopic from studentessay where rollno=?) ";
	PreparedStatement pt = con.prepareStatement(query);
	pt.setString(1, rollno);
	rs=pt.executeQuery();
	while(rs.next())
	{
	    topiclist.add(rs.getString(1));
	}
	}catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
	return topiclist;
}
public int storeData()
{
	int n=0;	
	 try
		{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="insert into studentessay values(?,?,?)";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1,topic);
		pt.setString(2,rollno);
		pt.setString(3,essay);
		n=pt.executeUpdate();
		}
	    catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
	 return n;
}
}
