package com.ie.pkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Result {
	String rollno;
	String topic;
	int spellerrors;
	int gramerrors;
	double relevance;
	int wordcount;
	char score;
	String remarks;
public Result(String rollno,String topic)
{
	this.rollno=rollno;
	this.topic=topic;
}
public void getScoreDetails()
{
	ResultSet rs=null;
	try{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="(select spellerrors,gramerrors,relevance,wordcount from score where rollno=? and essaytopic=?)";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1, rollno);
		pt.setString(2,topic);
		rs=pt.executeQuery();
		while(rs.next())
		{
		  spellerrors=rs.getInt(1);
		  gramerrors=rs.getInt(2);
		  relevance=rs.getDouble(3);
		  wordcount=rs.getInt(4);
		}
		}catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
	
}
public void getScore()
{
	if(spellerrors<=5 && gramerrors<=10 && Double.compare(relevance, 1.0)==0 && (wordcount>=350&&wordcount<=450))
	{
		score='A';
	}
	else if(spellerrors<=10 && gramerrors<=20 && Double.compare(relevance, 0.7)==0 && (wordcount>=300&&wordcount<=500))
	{
		score='B';
	}
	else if(spellerrors<=20 && gramerrors<=40 && Double.compare(relevance, 0.5)==0 && (wordcount>=250&&wordcount<=550))
	{
		score='C';
	}
	else
	{
		score='D';
	}
}
public void getRemarks()
{
	remarks="";
	if(spellerrors<=5)
	{
		remarks=remarks.concat("Your performance in English spelling is very good. ");
	}
	else if(spellerrors>5 && spellerrors<=10)
	{
		remarks=remarks.concat("Your performance in English spelling is above average. ");
	}
	else if(spellerrors>10 && spellerrors<=20)
	{
		remarks=remarks.concat("Your performance in English spelling is average. ");
	}
	else
	{
		remarks=remarks.concat("Your performance in English spelling is below average. ");
	}
	
	if(gramerrors<=10)
	{
		remarks=remarks.concat("You have shown very good command over English Grammar. ");
	}
	else if(gramerrors>10 && gramerrors<=20)
	{
		remarks=remarks.concat("Your performance in English Grammar is above average. ");
	}
	else if(gramerrors>20 && gramerrors<=40)
	{
		remarks=remarks.concat("Your performance in English Grammar is average. ");
	}
	else
	{
		remarks=remarks.concat("Your performance in English Grammar is below average. ");
	}
	if(Double.compare(relevance, 1.0)==0)
	{
		remarks=remarks.concat("Your essay is relevant to the topic. ");
	}
	else if(Double.compare(relevance, 0.7)==0)
	{
		remarks=remarks.concat("Your essay is almost relevant to the topic. ");
	}
	else if(Double.compare(relevance, 0.5)==0)
	{
		remarks=remarks.concat("Your essay is less relevant to the topic. ");
	}
	else
	{
		remarks=remarks.concat("Your essay is off topic. ");
	}
	if(wordcount<250)
	{
		remarks=remarks.concat("You essay is too short.");
	}
	else if(wordcount>=250 && wordcount<300)
	{
		remarks=remarks.concat("Your essay is short.");
	}
	else if(wordcount>=300 && wordcount<350)
	{
		remarks=remarks.concat("You should write little more for ideal length.");
	}
	else if(wordcount>=350 && wordcount<450)
	{
		remarks=remarks.concat("Your essay is of ideal length.");
	}
	else if(wordcount>=450 && wordcount<500)
	{
		remarks=remarks.concat("You should write little less for ideal length.");
	}
	else if(wordcount>=500 && wordcount<550)
	{
		remarks=remarks.concat("Your essay is long.");
	}
	else
	{
		remarks=remarks.concat("Your essay is very long.");
	}
}
public int storeResult()
{
	int n=0;
	try
	{
	DatabaseConnect db=new DatabaseConnect();
	Connection con= db.getDBConnection();
	String query="update score set score=?,remarks=? where rollno=? and essaytopic=?";
	PreparedStatement pt = con.prepareStatement(query);
	pt.setString(1, String.valueOf(score));
	pt.setString(2, remarks);
	pt.setString(3, rollno);
	pt.setString(4, topic);
	n=pt.executeUpdate();
	}catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
	 return n;
}
}
