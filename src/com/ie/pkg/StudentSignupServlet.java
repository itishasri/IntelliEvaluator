package com.ie.pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentSignupServlet
 */
@WebServlet("/StudentSignupServlet")
public class StudentSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException
	{  
		PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        String fname =request.getParameter("FirstName");
        String lname =request.getParameter("LastName");
        String rollno = request.getParameter("RollNo");
        String email =request.getParameter("FromEmailAddress");
        String dobstr =request.getParameter("Dob");
        String gender = request.getParameter("gender");
        String pass = request.getParameter("pass1");
        StudentSignupBean bean=new StudentSignupBean(fname,lname,rollno,email,dobstr,gender,pass);
        int n=bean.storeData();
        if(n>0){  
            RequestDispatcher rd=request.getRequestDispatcher("studentlog.jsp");  
            out.println("<br><br><br><h2><b><font color='white'>Signed up successfully!</font> </b></h2>");
            out.println("</body></html>");
            rd.include(request, response);   
        }  
        else{  
            RequestDispatcher rd=request.getRequestDispatcher("studentsignup.jsp");  
            out.println("<br><br><br><h2><b><font color='white'>RollNo already exists!</font></b></h2>");
            out.println("</body></html>");
            rd.include(request, response);
        }  
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);  
	}

}
