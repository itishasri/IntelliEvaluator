package com.ie.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class TeacherLoginServlet
 */
@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
	    String pass=request.getParameter("password");
	    TeacherLoginBean tlb= new TeacherLoginBean(name,pass);
	    
	    boolean status= tlb.loginValidate();
	    System.out.println(status);
	    if(status==true)
	    {
	    	RequestDispatcher rd= request.getRequestDispatcher("teacherhome.jsp");
	    	HttpSession session=request.getSession();
	    	session.setAttribute("tid", name);
	    	session.setAttribute("LoginBean", tlb);
	    	rd.forward(request, response);
	    }
	    else
	    {
	    	RequestDispatcher rd= request.getRequestDispatcher("teacherlog.jsp");
	    	out.println("<br><br><br><h2><font color='white'>Invalid teacherid or password</font></h2>");
	    	out.println("</body></html>");
	    	rd.include(request, response);
	    	
	    }
		
	}

}
