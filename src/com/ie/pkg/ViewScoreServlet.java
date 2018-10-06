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
 * Servlet implementation class ViewScoreServlet
 */
@WebServlet("/ViewScoreServlet")
public class ViewScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewScoreServlet() {
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
		String scoretopic=request.getParameter("topic");
		HttpSession session=request.getSession(false);
		session.setAttribute("scoretopic", scoretopic);
		String rollno=(String)session.getAttribute("rollno");
		ViewScoreBean vsb=new ViewScoreBean(scoretopic,rollno);
		vsb=vsb.getResultList();
		int se=vsb.getSpellerror();
		int ge=vsb.getGrammerror();
		double r=vsb.getRelevance();
		int w=vsb.getWordcount();
		if(se<=5)
			se=4;
		else if(se>5 && se<=10)
			se=3;
		else if(se>10 && se<=20)
			se=2;
		else
			se=1;
		if(ge<=10)
			ge=4;
		else if(ge>10 && ge<=20)
			ge=3;
		else if(ge>20 && ge<=40)
			ge=2;
		else
			ge=1;
		int re=0;
	    if(Double.compare(r, 1.0)==0)
	    	re=4;
	    else if(Double.compare(r, 0.7)==0)
	    	re=3;
	    else if(Double.compare(r, 0.5)==0)
	    	re=2;
	    else
	    	 re=1;
	    if(w>=350 && w<450)
	    	w=4;
	    else if((w>=300&&w<350)||(w>=450 && w<500))
	    		w=3;
	    else if((w>=250&&w<300)||(w>=500 && w<550))
	    	w=2;
	    else
	    	w=1;
		session.setAttribute("vsb", vsb);
		session.setAttribute("se", se);
		session.setAttribute("ge", ge);
		session.setAttribute("re",re);
		session.setAttribute("w", w);
		RequestDispatcher rd= request.getRequestDispatcher("viewscore.jsp");
		rd.forward(request, response);
		
	}

}
