package com.rk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cgsturl")
public class CentralGSTServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		float cost=0.0f;
		float cgst=0.0f;
		String ptype=null;
		PrintWriter pw=null;
		//get Printwriter
		pw=res.getWriter();
		//set contenttype
		res.setContentType("text/html");
		//read project cost and project type request obj
		cost=Float.parseFloat(req.getParameter("cost"));
		ptype=req.getParameter("ptype");
		//calculate central gst
		if(ptype.equalsIgnoreCase("product"))
			cgst=cost*0.18f;
		else if(ptype.equalsIgnoreCase("service"))
			cgst=cost*0.15f;
		else if(ptype.equalsIgnoreCase("startup"))
			cgst=cost*0.1f;
		//display details
		pw.println("<br><b>Central GST::"+cgst+"</b>");
		//do not close printwriter obj
		//pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
