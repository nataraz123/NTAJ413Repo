package com.nt.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestPerformenceAnalyzerListener implements ServletRequestListener {
	private long start=0,end=0;
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestPerformenceAnalyzerListener.requestInitialized()");
		start=System.currentTimeMillis();
	}
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestPerformenceAnalyzerListener.requestDestroyed()");
		HttpServletRequest req=null;
		ServletContext sc=null;
	  end=System.currentTimeMillis();
	  //get request object
	  req=(HttpServletRequest)sre.getServletRequest();
	  //get servletContext object
	  sc=req.getServletContext();
	  sc.log(req.getRequestURI()+" has taken"+(end-start)+" ms  time to process the request");
	  
	  
	}

}
