package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String PERSON_INFO_QUERY="INSERT INTO PERSON_INFO VALUES(PID_SEQ.NEXTVAL,?,?,?,?,?)";
	@Resource(name="DsJndi")
	private  DataSource ds;

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null,ms=null;
		String f2val1=null,f2val2=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//get PrintWriter 
		pw=res.getWriter();
		res.setContentType("text/html");
		//read  form1/req1 data  from the hidden boxes of form2
		pname=req.getParameter("hname");
		fname=req.getParameter("hfname");
		ms=req.getParameter("hms");
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		//write both form1/req1 data and form2/req2  data to db table as record
		try {
			//get Pooled JDBC connection object
			con=ds.getConnection();
			//create PreparedStatement object
			ps=con.prepareStatement(PERSON_INFO_QUERY);
			//set query param values
			ps.setString(1,pname);
			ps.setString(2,fname);
			ps.setString(3,ms);
			ps.setString(4,f2val1);
			ps.setString(5,f2val2);
			//execut the query
			result=ps.executeUpdate();
			//process the result
			if(result==0)
				pw.println("<br> <b> Person Registration failed </b>");
			else
				pw.println("<br> <b> Person Registration succeded </b>");
			
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
		
		//display dynamic webpage having both form1/req1 data and form2/req2 data..
		pw.println("<h1 style='color:red;text-align:center'> Result  page </h1>");
		pw.println("<br> form1/req1  data::"+pname+"....."+fname+"......."+ms);
		pw.println("<br> form2/req2  data::"+f2val1+"....."+f2val2);
		//add hyperlink
		pw.println("<br><br> <a href='input.html'>home </a>");
		
		//close stream
		pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}

}
