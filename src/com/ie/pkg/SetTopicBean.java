package com.ie.pkg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetTopicBean {
	private String tid;
	private String topic;
	private String sample1;
	private String sample2;
	private String sample3;
	private String sample4;
	private String sample5;
	public SetTopicBean(String topic, String tid, String sample1, String sample2, String sample3, String sample4, String sample5)
	{
		this.tid=tid;
		this.topic=topic;
		this.sample1=sample1;
		this.sample2=sample2;
		this.sample3=sample3;
		this.sample4=sample4;
		this.sample5=sample5;
	}
	public void setTid(String tid)
	{
		this.tid=tid;
	}
	public String getTid()
	{
		return this.tid;
	}
	public void setTopic(String topic)
	{
		this.topic=topic;
	}
	public String getTopic()
	{
		return this.topic;
	}
	public void setSample1(String sample1)
	{
		this.sample1=sample1;
	}
	public String getSample1()
	{
		return this.sample1;
	}
	public void setSample2(String sample2)
	{
		this.sample2=sample2;
	}
	public String getSample2()
	{
		return this.sample2;
	}
	public void setSample3(String sample3)
	{
		this.sample3=sample3;
	}
	public String getSample3()
	{
		return this.sample3;
	}
	public void setSample4(String sample4)
	{
		this.sample4=sample4;
	}
	public String getSample4()
	{
		return this.sample4;
	}
	public void setSample5(String sample5)
	{
		this.sample5=sample5;
	}
	public String getSample5()
	{
		return this.sample5;
	}
	public int storeData()
	{
		int n=0;	
	 try
		{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="insert into sampleEssay values(?,?,?,?,?,?,?)";
		PreparedStatement pt = con.prepareStatement(query);
		System.out.println(tid);
		pt.setString(1,topic);
		pt.setString(2,tid);
		pt.setString(3,sample1);
		pt.setString(4,sample2);
		pt.setString(5,sample3);
		pt.setString(6,sample4);
		pt.setString(7,sample5);
		n=pt.executeUpdate();
		}
	    catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
	 return n;
	}
}