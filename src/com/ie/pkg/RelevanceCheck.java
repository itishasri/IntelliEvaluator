package com.ie.pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class RelevanceCheck {
	String rollno;
	String topic;
	double relevance;
	public RelevanceCheck(String rollno,String topic)
	{
		this.rollno=rollno;
		this.topic=topic;
	}
public String[] getSampleEssay()
{
	ResultSet rs=null;
	String sampleessay[]=new String[5];
	 try
	 {
		 DatabaseConnect db=new DatabaseConnect();
		 Connection con= db.getDBConnection();
		 String query="select sample1,sample2,sample3,sample4,sample5 from sampleessay where essaytopic=?";
		 PreparedStatement pt = con.prepareStatement(query);
		 pt.setString(1, topic);
		 rs=pt.executeQuery();
			while(rs.next())
			{
				sampleessay[0]=rs.getString(1);
				sampleessay[1]=rs.getString(2);
				sampleessay[2]=rs.getString(3);
				sampleessay[3]=rs.getString(4);
				sampleessay[4]=rs.getString(5);
			}
	 }catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);}
return sampleessay;
}
public String getStudentEssay()
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
return studentessay;
}
public String fileToString(String path)
{
	String essay=null;
	File f = new File(path);
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
	 System.out.println(essay);
	 return essay;
}
@SuppressWarnings("deprecation")
public ArrayList<String> getKeywords()
{
	POSModel model = new POSModelLoader()	
			.load(new File("C:/Users/Itisha/workspace/IntelliEvaluator/WebContent/WEB-INF/lib/en-pos-maxent.bin"));
		PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
		POSTaggerME tagger = new POSTaggerME(model);
	    String stEssay=getStudentEssay();
		String input = fileToString(stEssay);
		ObjectStream<String> lineStream = new PlainTextByLineStream(
				new StringReader(input));
		ArrayList<String> al_StudentEssay=new ArrayList<String>();
		perfMon.start();
		String line;
		
		try {
			while ((line = lineStream.read()) != null) {
 
				String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE
						.tokenize(line);
				String[] tags = tagger.tag(whitespaceTokenizerLine);
 
				POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
				String s=sample.toString();
				s=s.replace(".", "");
				s=s.replace("?", "");
				s=s.replace("!", "");
				System.out.println(s);
				StringTokenizer st=new StringTokenizer(s," ");
				while(st.hasMoreTokens())
				{ 
					al_StudentEssay.add(st.nextToken());
				}
		int l=al_StudentEssay.size();
		for(int i=0;i<l;i++)
		{
    			if((al_StudentEssay.get(i)).endsWith("_NN"))
    			{
    				al_StudentEssay.set(i,(al_StudentEssay.get(i)).replace("_NN","") );
    			}
    			else if((al_StudentEssay.get(i)).endsWith("_NNS"))
    			{
    				al_StudentEssay.set(i,(al_StudentEssay.get(i)).replace("_NNS","") );
    			}
    			else if((al_StudentEssay.get(i)).endsWith("_NNP"))
    			{
    				al_StudentEssay.set(i,(al_StudentEssay.get(i)).replace("_NNP","") );
    			}
    			else if((al_StudentEssay.get(i)).endsWith("_NNPS"))
    			{
    				al_StudentEssay.set(i,(al_StudentEssay.get(i)).replace("_NNPS","") );
    			}
    			else
				{
			      al_StudentEssay.remove(i);
			      i--;
			      l--;
				}
		}
		System.out.println(al_StudentEssay);
		perfMon.incrementCounter();
        }
} 
 catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	perfMon.stopAndPrintFinalResult();
	return al_StudentEssay;
}
public void checkRelevance()
{
	String sme[]=new String[5];
	sme=getSampleEssay();
	for(int i=0;i<5;i++)
	{
		System.out.println(sme[i]);
		sme[i]=fileToString(sme[i]);
	}
	double percent_match[]=new double[5];
	int match[]=new int[5];
	ArrayList<String> al_st=new ArrayList<String>();
	al_st=getKeywords();
	int l=al_st.size();
	int c=l;
	System.out.println(c);
	for(int i=0;i<5;i++)
	{
		percent_match[i]=0.0;
		match[i]=0;
		for(int j=0;j<l;j++)
		{
			StringTokenizer st=new StringTokenizer(sme[i]," ");
			ArrayList<String> al_temp=new ArrayList<String>();
			while(st.hasMoreTokens())
			{
				al_temp.add(st.nextToken());
			}
			int l_temp=al_temp.size();
			for(int k=0;k<l_temp;k++)
			{
				if((al_st.get(j)).equals(al_temp.get(k)))
				{
					match[i]+=1;
					al_temp.remove(k);
					k--;
					l_temp--;
					
				}
			}
		}
		percent_match[i]=(match[i]/c)*100;
	}
	double total_pm=0.0;
	for(int i=0;i<5;i++)
	{
		total_pm+=percent_match[i];
	}
	total_pm/=5;
	if(total_pm>=80)
		relevance=1.0;
	else if((total_pm<80)&&(total_pm>=65))
	    relevance=0.7;
	else if((total_pm<65)&&(total_pm>=40))
		relevance=0.5;	
	else
		relevance=0.0;
}
public int storeRelevance()
{
	int n=0;
	try
	{
	DatabaseConnect db=new DatabaseConnect();
	Connection con= db.getDBConnection();
	String query="update score set relevance=? where rollno=? and essaytopic=?";
	PreparedStatement pt = con.prepareStatement(query);
	pt.setDouble(1, relevance);
	pt.setString(2, rollno);
	pt.setString(3, topic);
	n=pt.executeUpdate();
	}catch(SQLException ex){Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);} 
	 return n;
}
}