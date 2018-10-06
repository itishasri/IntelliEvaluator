package com.ie.pkg;
import java.sql.*;

public class TeacherLoginBean {
	private String user;
	private String pass;
	public String tname;
	TeacherLoginBean(String user,String pass)
	{
		this.user=user;
		this.pass=pass;
	}
	public void setUser(String user)
	{
		this.user=user;
	}
	public void setPassword(String pass)
	{
		this.pass=pass;
	}
	public String getUser()
	{
		return this.user;
	}
	public String getPassword()
	{
		return this.pass;
	}
	public boolean loginValidate()
	{
		String tid= null;
		try
		{
	DatabaseConnect dc = new DatabaseConnect();
	Connection conn= dc.getDBConnection();
	PreparedStatement pt= conn.prepareStatement("select teacherid,tfname,tlname from teacher where teacherid=? and tpass=?");
	pt.setString(1, user);
	pt.setString(2, pass);
	ResultSet rs= pt.executeQuery();
	while(rs.next())
	{
		 tid=rs.getString(1);
		 tname=(rs.getString(2))+" "+(rs.getString(3));
	}
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		if(user.equals(tid))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}