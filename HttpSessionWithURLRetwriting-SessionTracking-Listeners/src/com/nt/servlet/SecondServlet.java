package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String  INSERT_SESSION_PERSON_QUERY="INSERT INTO SESSION_PERSON_INFO VALUES(PID_SES_SEQ.NEXTVAL,?,?,?,?,?) ";
	@Resource(name="DsJndi")
	private DataSource ds;
	

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		float income=0.0f,tax=0.0f;
		String pname=null,fname=null,gender=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		HttpSession ses=null;
		   //get PrintWriter 
		pw=res.getWriter();
		//set response contentn type
		res.setContentType("text/html");
		//read form2/req2 data
		income=Float.parseFloat(req.getParameter("income"));
		tax=Float.parseFloat(req.getParameter("tax"));
		//get Access to Session object
		ses=req.getSession(false);
		//read form1/req1 data from session attribute (session tracking)
		pname=(String)ses.getAttribute("name");
		fname=(String)ses.getAttribute("fname");
		gender=(String)ses.getAttribute("gender");
		
				
		//write form1/req1  data to Db table as record
		try {
			//get Pooled jdbc con object
			con=ds.getConnection();
			//create PrepraedStatement object
			ps=con.prepareStatement(INSERT_SESSION_PERSON_QUERY);
			//set values to query params
			ps.setString(1,pname);
			ps.setString(2,fname);
			ps.setString(3,gender);
			ps.setFloat(4, income);
			ps.setFloat(5, tax);
			//execute the query
			count=ps.executeUpdate();
			//process the result
			if(count==0)
				pw.println("<h1 style='color:red;text-align:center'>Registration failed </h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Registration succeded </h1>");
				
		
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		
		//display form1/req1  data and form2/req2 data  dynamically
	    pw.println("<br> <h3> form1 /req1 data :::"+pname +"....."+fname+"...."+gender+"</h3>");
	    pw.println("<br> <h3> form2 /req2 data :::"+income +"....."+tax+"</h3>");
	    pw.println("<br><br> session id:::"+ses.getId());
	    
		//invalidate the sesssion
		ses.invalidate();
		//add hyperlink 
		
	    pw.println("<br> <a href='input.html'>home </a>");
		
		//close stream
	    pw.close();
		
		
	}//doGet(-,-)


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
