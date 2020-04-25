package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null,ms=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form1/req1 data
		pname=req.getParameter("pname");
		fname=req.getParameter("fname");
		ms=req.getParameter("ms");
		//Generate dynamic form page based marital status
		if(ms.equalsIgnoreCase("single")) {
			pw.println("<h1 style='color:red;text-align:center'> Provide Bachelor Life Realted Data  </h1>");
			pw.println("<form action='secondurl' method='POST'> ");
			pw.println("<table bgcolor='orange' align='center'>");
			pw.println("<tr><td> When do u want to marry </td><td><input type='text' name='f2t1'> </td> </tr>");
			pw.println("<tr><td> Why do u want to marry </td><td><input type='text' name='f2t2'> </td> </tr>");
			pw.println("<input type='hidden' name='hname'  value='"+pname+"'>" );
			pw.println("<input type='hidden' name='hfname'  value='"+fname+"'>" );
			pw.println("<input type='hidden' name='hms'  value='"+ms+"'>" );
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'> Provide Marriage  Life Realted Data  </h1>");
			pw.println("<form action='secondurl' method='POST'> ");
			pw.println("<table bgcolor='pink' align='center'>");
			pw.println("<tr><td> spouse name:: </td><td><input type='text' name='f2t1'> </td> </tr>");
			pw.println("<tr><td> No.of Chidren:: </td><td><input type='text' name='f2t2'> </td> </tr>");
			pw.println("<input type='hidden' name='hname'  value='"+pname+"'>" );
			pw.println("<input type='hidden' name='hfname'  value='"+fname+"'>" );
			pw.println("<input type='hidden' name='hms'  value='"+ms+"'>" );
			pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		
		//close stream
		pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		doGet(req, res);
	}

}
