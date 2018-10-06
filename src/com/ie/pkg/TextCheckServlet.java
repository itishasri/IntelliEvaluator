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
 * Servlet implementation class TextCheckServlet
 */
@WebServlet("/TextCheckServlet")
public class TextCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
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
		HttpSession session = request.getSession(false);
		String rollno=(String)session.getAttribute("rollno");
		String topic=(String)session.getAttribute("topic");
		int wordcount=(int)session.getAttribute("wordcount");
		TextCheck tc=new TextCheck(rollno,topic,wordcount);
        tc.getEssay();
        tc.spellcheck();
        tc.grammarcheck();
        int n=tc.storeError();
        if(n>0)
        {
		RequestDispatcher rd=request.getRequestDispatcher("RelevanceCheckServlet");
		rd.forward(request, response);
        }
	}

}
