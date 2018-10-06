package com.ie.pkg;
import java.sql.*;

public class StudentLoginBean {
	private String user;
	private String pass;
	public String sname;
	StudentLoginBean(String user,String pass)
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
		String sid= null;
		try
		{
	DatabaseConnect dc = new DatabaseConnect();
	Connection conn= dc.getDBConnection();
	PreparedStatement pt= conn.prepareStatement("select rollno,sfname,slname from student where rollno=? and spass=?");
	pt.setString(1, user);
	pt.setString(2, pass);
	ResultSet rs= pt.executeQuery();

	
	while(rs.next())
	{
		 sid=rs.getString(1);
		 sname=(rs.getString(2))+" "+(rs.getString(3));
		 		 
	}
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		if(user.equals(sid))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}