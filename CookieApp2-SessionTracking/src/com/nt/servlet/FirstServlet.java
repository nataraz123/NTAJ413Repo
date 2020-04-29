package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    String name=null,fname=null,gender=null;
	    Cookie cookie1=null,cookie2=null,cookie3=null;
		//get PrintWriter
	    pw=res.getWriter();
	    //set response content type
	    res.setContentType("text/html");
	    //read form1/req1 data
	    name=req.getParameter("pname");
	    fname=req.getParameter("fname");
	    gender=req.getParameter("gender");
	    //create InMemory Cookies having form1/req1 data
	    cookie1=new Cookie("pname",name);
	    cookie2=new Cookie("fname",fname);
	    cookie3=new Cookie("gender",gender);
	    //add cookies to response
	    res.addCookie(cookie1); res.addCookie(cookie2); res.addCookie(cookie3);
	    
	    //generate form2 dynamically here
	    pw.println("<h1 style='color:red;text-align:center'>Provide Income Details </h1>");
	    pw.println("<form action='secondurl' method='POST'>");
	    pw.println("<table border='0' bgcolor='cyan' align='center'>");
	    pw.println("<tr><td> Income of this year </td> <td> <input type='text' name='income'></td></tr>");
	    pw.println("<tr><td> Tax </td> <td> <input type='text' name='tax'></td></tr>");
	    pw.println("<tr><td> <input type='submit' value='submit'> </td> <td> <input type='reset'  value='cancel'></td></tr>");
	    pw.println("</table> </form>");
	    //close stream
	    pw.close();
	}  //method


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//method

}//class
