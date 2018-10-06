package com.ie.pkg;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	    //System.out.println(name+pass);
	    StudentLoginBean slb= new StudentLoginBean(name,pass);
	    boolean status= slb.loginValidate();
	    //System.out.println(status);
	    if(status==true)
	    {
	    	RequestDispatcher rd= request.getRequestDispatcher("studenthome.jsp");
	    	HttpSession session=request.getSession();
	    	session.setAttribute("rollno", name);
	    	session.setAttribute("LoginBean", slb);
	    	rd.forward(request, response);
	    }
	    else
	    {
	    	RequestDispatcher rd= request.getRequestDispatcher("studentlog.jsp");
	    	out.println("<br><br><br><h2><font color='white'>Invalid rollno or password!</font></h2>");
	    	out.println("</body></html>");
	    	rd.include(request, response);
	    }
		

		
	}

}
