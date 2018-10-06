package com.ie.pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;

public class TextCheck {
	int cs;
	int cg;
	String essay;
	String rollno;
	String topic;
	int wordcount;
public TextCheck(String rollno,String topic,int wordcount)
{
	this.rollno=rollno;
	this.topic=topic;
	this.wordcount=wordcount;
}
	public void getEssay()
	{
		ResultSet rs=null;
		 String studentessay="";
		 try
		 {
			 DatabaseConnect db=new DatabaseConnect();
			 Connection con= db.getDBConnection();
			 String query="select essay from studentessay where rollno=? and essaytopic=?";
			 PreparedStatement pt = con.prepareStatement(query);
			 pt.setString(1, rollno);
			 pt.setString(2, topic);
			 rs=pt.executeQuery();
				while(rs.next())
				{
					studentessay=rs.getString(1);
				}
		 }catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
		 File f = new File(studentessay);
		 try {
			InputStream file = new FileInputStream(f);
			int size = file.available();

		      for(int i=0; i< size; i++){
		    	  char ch=(char)file.read();
		    	  essay=essay+ch;
		      }
		      file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void spellcheck()
	{
		JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
		for (Rule rule : langTool.getAllRules()) {
			  if (!rule.isDictionaryBasedSpellingRule()) {
			    langTool.disableRule(rule.getId());
			  }
		}
		List<RuleMatch> matches1=null;
		try {
			matches1 = langTool.check(essay);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cs=matches1.size();	
		System.out.println(cs);
	}
	public void grammarcheck()
	{
	    JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
	    List<RuleMatch> matches = null;
		try {
			matches = langTool.check(essay);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		cg=matches.size();
		cg-=cs;
		System.out.println(cg);
	 }
	public int storeError()
	{
		
	    int n=0;
		try
		{
		DatabaseConnect db=new DatabaseConnect();
		Connection con= db.getDBConnection();
		String query="insert into score (essaytopic,rollno,spellerrors,gramerrors,wordcount) values(?,?,?,?,?)";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setString(1, topic);
		pt.setString(2, rollno);
		pt.setInt(3, cs);
		pt.setInt(4, cg);
		pt.setInt(5, wordcount);
		n=pt.executeUpdate();
		System.out.println(n);
		}catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
		 return n;
	}
}
