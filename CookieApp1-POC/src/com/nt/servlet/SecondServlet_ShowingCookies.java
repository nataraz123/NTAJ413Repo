package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showurl")
public class SecondServlet_ShowingCookies extends HttpServlet {


public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=null;	
	 Cookie cookies[]=null;
	//get PrintWriter
	 pw=res.getWriter();
	 //set Content type
	   res.setContentType("text/html");
	//read cookies
	   cookies=req.getCookies();
	   //display cookies
	   pw.println("<b> Displaying cookies</b>");
	  
	   if(cookies!=null) {
		   pw.println("<table border='1' bgcolor='cyan' >");
		   pw.println("<tr><th>Cookie name</th><th>Cookie value </th></tr>");
		   for(Cookie ck:cookies) {
			   pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
		   }
		   pw.println("</table>");
	   }
	   else {
		   pw.println("<b> no cookies present </b>");
	   }
	  
	    
	 //close stream
	   pw.close();
	   
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doGet(req,res);
	}

}
