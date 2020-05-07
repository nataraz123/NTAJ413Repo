package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionDurationAnalyzerListener implements HttpSessionListener {
	private long start=0,end=0;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext sc=null;
		HttpSession ses=null;
		System.out.println("SessionDurationAnalyzerListener.sessionCreated()");
		start=System.currentTimeMillis();
		//get SErvletcontext object
		sc=se.getSession().getServletContext();
		//get Session object
		ses=se.getSession();
		sc.log("session id::"+ses.getId()+" session started at"+new Date());
		
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext sc=null;
		HttpSession ses=null;
		System.out.println("SessionDurationAnalyzerListener.sessionDestroyed()");
		end=System.currentTimeMillis();
		//get SErvletcontext object
				sc=se.getSession().getServletContext();
				//get Session object
				ses=se.getSession();
		sc.log("session id::"+ses.getId()+" session ended at"+new Date());	
		sc.log("session id::"+ses.getId()+" session duration is ::"+(end-start)+" ms");
		
		
	}

}
