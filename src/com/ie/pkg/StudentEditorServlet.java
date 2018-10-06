package com.ie.pkg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentHomeServlet
 */
@WebServlet("/StudentEditorServlet")
public class StudentEditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String rollno;
	private String topic;
	private String essay;
	private String essaydestination;
	private int wordcount;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		HttpSession session = request.getSession(false);
	    if(session!=null)
	    {
	    	 rollno=(String)session.getAttribute("rollno");
	    }
	     topic=request.getParameter("essaytopic");
		 essay=request.getParameter("message1");
		 wordcount=Integer.parseInt(request.getParameter("len"));
		 System.out.println(topic+" "+essay);
		 Date dNow = new Date( );
		 SimpleDateFormat ft = new SimpleDateFormat ("yyMMddHHmmssZ");
		 String d=ft.format(dNow);
		 String dest="D:/StudentEssay/"+rollno+"/"+topic;
		 File f=new File(dest);
		 f.mkdirs();
		 essaydestination=dest+"/"+d+".txt";
		 try {
		 File file = new File(essaydestination);
		 if (!file.exists()) {
				file.createNewFile();
			}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(essay);
		bw.close();	 
		 } catch (IOException e) {
				e.printStackTrace();
	}
     StudentEditorBean bean= new StudentEditorBean(topic,rollno,essaydestination);
			int n=bean.storeData();
			if(n>0)
			{
				System.out.println("record inserted");
				RequestDispatcher rd=request.getRequestDispatcher("TextCheckServlet");
				session.setAttribute("topic", topic);
				session.setAttribute("wordcount", wordcount);
				rd.forward(request, response);
				
			}
}
}
