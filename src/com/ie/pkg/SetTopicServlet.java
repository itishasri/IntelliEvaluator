package com.ie.pkg;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class SetTopicServlet
 */
@WebServlet("/SetTopicServlet")
@MultipartConfig
public class SetTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = 
            Logger.getLogger(SetTopicServlet.class.getCanonicalName());
	private String name;
	private String topic;
	private String sampleDestination[]=new String[5];
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out1=response.getWriter();
	    // Create path components to save the file
	    final String path = "D:/SampleEssay";
	    Part filePart[]=new Part[5];
	    filePart[0] = request.getPart("sample1");
	    filePart[1] = request.getPart("sample2");
	    filePart[2] = request.getPart("sample3");
	    filePart[3] = request.getPart("sample4");
	    filePart[4] = request.getPart("sample5");
	    String filepath[]=new String[5];
	    String fileName[]=new String[5];
	    HttpSession session = request.getSession(false);
	    if(session!=null)
	    {
	    	 name=(String)session.getAttribute("tid");
	    	 System.out.println("tid= "+name);
	    }
	     topic=request.getParameter("topic");
	     System.out.println("topic= "+topic);
	     final PrintWriter writer = response.getWriter();
	     OutputStream out = null;
		 InputStream filecontent = null;
	  try 
	  {
	    for(int i=0;i<5;i++)
	    {
	    Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyMMddHHmmssZ");
	    String d=ft.format(dNow);
	    String destination=path+"/"+name+"/"+d;
	    File f=new File(destination);
	    f.mkdirs();
	    filepath[i] = getFileName(filePart[i]);
	    fileName[i]=filepath[i].substring(filepath[i].lastIndexOf("\\") + 1);
	    
	    out = new FileOutputStream(new File(destination + File.separator + fileName[i]));
	    filecontent = filePart[i].getInputStream();
	        
	        sampleDestination[i]= destination + File.separator + fileName[i];
	        
	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) 
	        {
	            out.write(bytes, 0, read);
	        }
	    } 
	    SetTopicBean bean1= new SetTopicBean(topic,name,sampleDestination[0],sampleDestination[1],sampleDestination[2],sampleDestination[3],sampleDestination[4]);
		
		int n=bean1.storeData();
		if(n>0)
		{
			System.out.println("record inserted");
			RequestDispatcher rd=request.getRequestDispatcher("teacherhome.jsp");
			rd.forward(request, response);
		}
	    }catch (FileNotFoundException fne) 
	    {
	        writer.println("You either did not specify a file to upload or are "
	                + "trying to upload a file to a protected or nonexistent "
	                + "location.");
	        writer.println("<br/> ERROR: " + fne.getMessage());

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
	        if (writer != null)
	        {
	            writer.close();
	        }
	    }
	
	}
	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}

