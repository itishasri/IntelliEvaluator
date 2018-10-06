package com.ie.pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class EditProfileTeacherServlet
 */
@WebServlet("/EditProfileTeacherServlet")
@MultipartConfig
public class EditProfileTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = 
            Logger.getLogger(SetTopicServlet.class.getCanonicalName());   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileTeacherServlet() {
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
        HttpSession session=request.getSession(false);
        String fname=request.getParameter("FirstName");
        String lname=request.getParameter("LastName");
        String email=request.getParameter("FromEmailAddress");
        String pass=request.getParameter("pass1");
        Part imagepart=request.getPart("image");
		String imagedestination="";
       	OutputStream out = null;
		 InputStream filecontent = null;
		 final String destination = "C:\\Users\\Itisha\\workspace\\IntelliEvaluator\\WebContent\\TeacherProfilePicture";
	 
		String tid=(String)session.getAttribute("tid");
		String imagename="";
		System.out.println(tid);
		TeacherSignupBean tvb=new TeacherSignupBean(tid);
		if(imagepart!=null)
		{
		 try 
		  {
			  File f=new File(destination);
			  f.mkdirs();
			    imagename=tid+".jpg";
			    out = new FileOutputStream(new File(destination + File.separator + imagename));
			    filecontent = imagepart.getInputStream();
			        
			        imagedestination= destination + File.separator + imagename;
			        
			        int read = 0;
			        final byte[] bytes = new byte[1024];

			        while ((read = filecontent.read(bytes)) != -1) 
			        {
			            out.write(bytes, 0, read);
			        }
			        String dest="TeacherProfilePicture/"+imagename;
			        System.out.println(dest);
			        tvb.updateImage(dest);
		  }catch (FileNotFoundException fne){
			  LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
		                new Object[]{fne.getMessage()});
		  }
		 finally 
		    {
		        if (out != null) 
		        {
		            out.close();
		        }
		        if (filecontent != null)
		        {
		            filecontent.close();
		        }
		    }
		}
		
		if(fname!=null && !fname.equals(""))
		{
		  tvb.updateFname(fname);
		  System.out.println(fname);
		}
		if(lname!=null && !lname.equals("")){
		tvb.updateLname(lname);
		System.out.println(lname);}
		if(email!=null && !email.equals("")){
		tvb.updateEmail(email);
		System.out.println(email);}
		if(pass!=null &&!pass.equals("")){
		tvb.updatePassword(pass);}
	    	RequestDispatcher rd= request.getRequestDispatcher("teacherhome.jsp");
	        //session.setAttribute("tvb1", tvb);	
	    	rd.forward(request, response);
		
        

	}

}
