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
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
	    if((name.equals("admin"))&&( pass.equals("admin")))
	    {
	    	RequestDispatcher rd= request.getRequestDispatcher("adminhome.jsp");
	    	@SuppressWarnings("unused")
			HttpSession session=request.getSession();
	    	rd.forward(request, response);
	    }
	    else
	    {
	    	RequestDispatcher rd= request.getRequestDispatcher("adminlogin.jsp");
	    	out.println("<br><br><br><h2><font color='white'>Invalid rollno or password!</font></h2>");
	    	out.println("</body></html>");
	    	rd.include(request, response);
	    	//out.println(alert("invalid user"));
	    }

	}

}
