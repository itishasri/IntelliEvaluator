package com.ie.pkg;
import java.sql.*;
import java.util.ArrayList;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TeacherSignupBean {
private String fname;
private String lname;
private String tid;
private String email;
private String dobstr;
private String gender;
private String pass;
private String image;
public TeacherSignupBean(){}
public TeacherSignupBean(String tid)
{
	this.tid=tid;
}
public TeacherSignupBean(String fname, String lname, String tid, String email, String dobstr,String gender, String pass )
{
	this.fname=fname;
	this.lname=lname;
	this.tid=tid;
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
public void setTid(String tid)
{
	this.tid=tid;
}
public String getTid()
{
	return this.tid;
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
public int updateFname(String fname)
{
	int n=0;
	try
	{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="update teacher set tfname=? where teacherid=?";
		PreparedStatement pt=con.prepareStatement(query);
		pt.setString(1, fname);
		pt.setString(2, tid);
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
		String query="update teacher set tlname=? where teacherid=?";
		PreparedStatement pt=con.prepareStatement(query);
		pt.setString(1, lname);
		pt.setString(2, tid);
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
		String query="update teacher set temail=? where teacherid=?";
		PreparedStatement pt=con.prepareStatement(query);
		pt.setString(1, email);
		pt.setString(2, tid);
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
		String query="update teacher set tpass=? where teacherid=?";
		PreparedStatement pt=con.prepareStatement(query);
		pt.setString(1, pass);
		pt.setString(2, tid);
		n=pt.executeUpdate();
	}
	catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
	return n;
}
public int updateImage(String image)
{
	System.out.println(image);
	int n=0;
	try
	{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="update teacher set image=? where teacherid=?";
		PreparedStatement pt=con.prepareStatement(query);
		pt.setString(1, image);
		pt.setString(2, tid);
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
	String query="insert into teacher values(?,?,?,?,?,?,?)";
	PreparedStatement pt = con.prepareStatement(query);
	pt.setString(1,tid);
	pt.setString(2,fname);
	pt.setString(3,lname);
	pt.setString(4,gender);
	pt.setString(5,email);
	SimpleDateFormat df = new SimpleDateFormat("mm/dd/yyyy");
	ParsePosition pos = new ParsePosition(0);
	java.util.Date dob1=df.parse(dobstr, pos);
	java.sql.Date dob= new java.sql.Date(dob1.getTime());
	pt.setDate(6,dob);
	pt.setString(7,pass);
	n=pt.executeUpdate();
	}
    catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
 return n;
}
public ArrayList<String> getTeacherList()
{
	ResultSet rs=null;
	ArrayList<String> topiclist=new ArrayList<String>();
	try
	{
	DatabaseConnect db=new DatabaseConnect();
	Connection con= db.getDBConnection();
	String query="select teacherid from teacher ";
	Statement pt = con.createStatement();
	rs=pt.executeQuery(query);
	while(rs.next())
	{
	    topiclist.add(rs.getString(1));
	    
	}
	}catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
	return topiclist;
}

public void viewData()
	{
		ResultSet rs=null;
	 try
		{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="Select tfname,tlname,temail,tdob, image from teacher where teacherid=?";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1,tid);
		rs=pt.executeQuery();
		while(rs.next())
		{
		       
			  fname=rs.getString(1);
			  lname=rs.getString(2);
		     email=rs.getString(3);
		     Date d=(rs.getDate(4));
			 dobstr=d.toString();
			 setImage(rs.getString(5));
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
		String query="delete from teacher where teacherid=?";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1,tid);
		n= pt.executeUpdate();
		
		}	
		 catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
	 return n;
		}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

}
