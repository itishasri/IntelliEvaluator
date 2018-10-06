package com.ie.pkg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class StudentScoreTopicList
 */
@WebServlet("/StudentScoreTopicList")
public class StudentScoreTopicListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentScoreTopicListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		String rollno=(String)session.getAttribute("rollno");
		System.out.println(rollno);
		 ViewScoreBean bean= new ViewScoreBean(rollno);
		 ArrayList<String> topiclist=new ArrayList<String>();
		 topiclist=bean.getTopicList();
		 session.setAttribute("topiclist1",topiclist);
		 RequestDispatcher rd=request.getRequestDispatcher("studentscoretopiclist.jsp");
		 rd.forward(request, response);

	}

}
