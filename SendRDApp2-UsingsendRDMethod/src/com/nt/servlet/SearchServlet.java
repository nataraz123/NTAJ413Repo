package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String ss=null;
		String engine=null;
		String url=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response cotent type
		res.setContentType("text/html");
		//read form data
		ss=req.getParameter("ss");
		engine=req.getParameter("engine");
		//prepare url based on the selected search engine
		
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("yahoo"))
			url="https://in.search.yahoo.com/search?p="+ss;
		
		//perform sendRedirection
		System.out.println("before res.sendRedirect(-) method");
		pw.println("<b> before  ....</b>");
		res.sendRedirect(url);
		RequestDispatcher rd=req.getRequestDispatcher("/xyz.html");
		rd.include(req,res);
		System.out.println("after res.sendRedirect(-) method");
		
		pw.println("<b> after  ....</b>");
		
			
		//close stream
		pw.close();
		
	}

	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
