package com.ie.pkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class AdminViewTeacherServlet
 */
@WebServlet("/AdminViewTeacherServlet")
public class AdminViewTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewTeacherServlet() {
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
		//PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(false);
		String tid=(String)request.getParameter("tid");
		String manage=(String)request.getParameter("manage");
		int n=0;
			if(manage.equals("view"))
			{
				TeacherSignupBean tvb=new TeacherSignupBean(tid);
		      tvb.viewData();
	    	RequestDispatcher rd= request.getRequestDispatcher("viewprofileteacher.jsp");
	        session.setAttribute("tvb1", tvb);	
	    	rd.forward(request, response);
			}
			if(manage.equals("Delete"))
			{
				TeacherSignupBean tvb=new TeacherSignupBean(tid);
				n=tvb.deleteData();
				if(n>0)
				{
					RequestDispatcher rd= request.getRequestDispatcher("ViewTeacherListServlet");
			    	rd.forward(request, response);
				}
				
			}

	}

}
