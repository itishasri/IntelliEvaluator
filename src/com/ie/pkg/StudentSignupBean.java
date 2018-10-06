package com.ie.pkg;
import java.sql.*;
import java.text.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentSignupBean {
	private String fname;
	private String lname;
	private String rollno;
	private String email;
	private String dobstr;
	private String gender;
	private String pass;
	private String image;
	public StudentSignupBean()
	{
	}
	
	public StudentSignupBean(String rollno)
	{
		this.rollno=rollno;
	}
	public StudentSignupBean(String fname, String lname, String rollno, String email, String dobstr,String gender, String pass )
	{
		this.fname=fname;
		this.lname=lname;
		this.rollno=rollno;
		this.email=email;
		this.dobstr=dobstr;
		this.gender=gender;
		this.pass=pass;
	}
	public void setFname(String fname)
	{
		this.fname=fname;
	}
	public String getFname()
	{
		return this.fname;
	}
	public void setLname(String lname)
	{
		this.lname=lname;
	}
	public String getLname()
	{
		return this.lname;
	}
	public void setRollno(String rollno)
	{
		this.rollno=rollno;
	}
	public String getRollno()
	{
		return this.rollno;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setDob(String dobstr)
	{
		this.dobstr=dobstr;
	}
	public String getDob()
	{
		return this.dobstr;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public String getGender()
	{
		return this.gender;
	}
	public void setPass(String pass)
	{
		this.pass=pass;
	}
	public String getPass()
	{
		return this.pass;
	}
	public void setImage(String image)
	{
		this.image=image;
	}
	public String getImage()
	{
		return this.image;
	}
	public ArrayList<String> getStudentList()
	{
		ResultSet rs=null;
		ArrayList<String> topiclist=new ArrayList<String>();
		try
		{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="select rollno from student ";
		Statement pt = con.createStatement();
		rs=pt.executeQuery(query);
		while(rs.next())
		{
		    topiclist.add(rs.getString(1));
		    
		}
		}catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
		return topiclist;
	}
	public int updateFname(String fname)
	{
		int n=0;
		try
		{
			DatabaseConnect db=new DatabaseConnect();
			Connection con= db.getDBConnection();
			String query="update student set sfname=? where rollno=?";
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1, fname);
			pt.setString(2, rollno);
			n=pt.executeUpdate();
		}
		catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
		return n;
	}
	public int updateLname(String lname)
	{
		int n=0;
		try
		{
			DatabaseConnect db=new DatabaseConnect();
			Connection con= db.getDBConnection();
			String query="update student set slname=? where rollno=?";
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1, lname);
			pt.setString(2, rollno);
			n=pt.executeUpdate();
		}
		catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
		return n;
	}
	public int updateEmail(String email)
	{
		int n=0;
		try
		{
			DatabaseConnect db=new DatabaseConnect();
			Connection con= db.getDBConnection();
			String query="update student set semail=? where rollno=?";
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1, email);
			pt.setString(2, rollno);
			n=pt.executeUpdate();
		}
		catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
		return n;
	}
	
	public int updatePassword(String pass)
	{
		int n=0;
		try
		{
			DatabaseConnect db=new DatabaseConnect();
			Connection con= db.getDBConnection();
			String query="update student set spass=? where rollno=?";
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1, pass);
			pt.setString(2, rollno);
			n=pt.executeUpdate();
		}
		catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
		return n;
	}
	public int updateImage(String image)
	{
		int n=0;
		try
		{
			DatabaseConnect db=new DatabaseConnect();
			Connection con= db.getDBConnection();
			String query="update student set image=? where rollno=?";
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1, image);
			pt.setString(2, rollno);
			n=pt.executeUpdate();
		}
		catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
		return n;
	}
	public int storeData()
	{
		int n=0;
	 try
		{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="insert into student values(?,?,?,?,?,?,?)";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1,rollno);
		pt.setString(2,fname);
		pt.setString(3,lname);
		pt.setString(4,gender);
		pt.setString(5,email);
		SimpleDateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		ParsePosition pos = new ParsePosition(0);
		java.util.Date dob1=df.parse(dobstr, pos);
		System.out.println(dob1);
		java.sql.Date dob= new java.sql.Date(dob1.getTime());
		pt.setDate(6,dob);
		pt.setString(7,pass);
		n=pt.executeUpdate();
		}
	    catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
	 return n;
	}
	 public void viewData()
	{
		ResultSet rs=null;
	 try
		{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="Select sfname,slname,semail,sdob, image from student where rollno=?";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1,rollno);
		rs=pt.executeQuery();
		while(rs.next())
		{
		       
			  fname=rs.getString(1);
			  lname=rs.getString(2);
		     email=rs.getString(3);
		     Date d=(rs.getDate(4));
			 dobstr=d.toString();
			 image=rs.getString(5);
		}
		}	
		 catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
		}
	 
	 public int deleteData()
	 {
		 int n=0;
		 try
			{
			DatabaseConnect db=new DatabaseConnect();
			Connection con= db.getDBConnection();
			String query="delete from student where rollno=?";
			PreparedStatement pt = con.prepareStatement(query);
			pt.setString(1,rollno);
			n= pt.executeUpdate();
			
			}	
			 catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
		 return n;
			}
	
	 
	}