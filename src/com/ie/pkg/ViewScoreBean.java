package com.ie.pkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewScoreBean {
	
	private String topic;
	private String rollno;
	private int spellerror;
	private int grammerror;
	private double relevance;
	private int wordcount;
	private char score;
	private String remark;
	
	public ViewScoreBean(String rollno)
	{
		this.rollno=rollno;
	}
	
	public ViewScoreBean(String topic,String rollno)
	{
		this.rollno=rollno;
		this.topic=topic;
	}
	public ViewScoreBean(String topic,String rollno,int spellerror,int gramerror,double relevance,int wordcount,char score,String remark)
	{
		this.rollno=rollno;
		this.topic=topic;
		this.spellerror=spellerror;
		this.grammerror=gramerror;
		this.relevance=relevance;
		this.wordcount=wordcount;
		this.score=score;
		this.remark=remark;
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

	public int getSpellerror() {
		return spellerror;
	}

	public void setSpellerror(int spellerror) {
		this.spellerror = spellerror;
	}

	public int getGrammerror() {
		return grammerror;
	}

	public void setGrammerror(int grammerror) {
		this.grammerror = grammerror;
	}

	public double getRelevance() {
		return relevance;
	}

	public void setRelevance(double relevance) {
		this.relevance = relevance;
	}

	public int getWordcount() {
		return wordcount;
	}

	public void setWordcount(int wordcount) {
		this.wordcount = wordcount;
	}

	public char getScore() {
		return score;
	}

	public void setScore(char score) {
		this.score = score;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public ArrayList<String> getTopicList()
	{
		ResultSet rs=null;
		ArrayList<String> topiclist=new ArrayList<String>();
		try
		{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="select essaytopic from score where rollno=? ";
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
	
	public ViewScoreBean getResultList()
	{
		ResultSet rs=null;
		ViewScoreBean sb=null;
		try
		{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="select spellerrors,gramerrors,relevance,wordcount,score,remarks from score where rollno=? and essaytopic=?";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1, rollno);
		pt.setString(2, topic);
		rs=pt.executeQuery();
        
		while(rs.next())
		{
			 spellerror=rs.getInt(1);
			 grammerror=rs.getInt(2);
			 relevance=rs.getDouble(3);
			 wordcount=rs.getInt(4);
			 char[] score1=(rs.getString(5)).toCharArray();
			 score=score1[0];
			 remark=rs.getString(6);
			
		    
		}
            sb=new ViewScoreBean(topic,rollno,spellerror,grammerror,relevance,wordcount,score,remark);
            
		
		}catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
		return sb;
	}
	
}

