package com.nt.listener;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApplicationMonitoringListener implements ServletContextListener {
	private long start=0,end=0;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc=null;
		System.out.println("WebApplicationMonitoringListener.contextInitialized()");
		start=System.currentTimeMillis();
		//get ServletContext object
		sc=sce.getServletContext();
		sc.log(sc.getContextPath()+" is deployed/restarted/reloaded at::"+new Date());
		
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc=null;
		System.out.println("WebApplicationMonitoringListener.contextDestroyed()");
		end=System.currentTimeMillis();
		//get ServletContext object
		sc=sce.getServletContext();
		sc.log(sc.getContextPath()+" is undeployed/stopped/reloaded::"+new Date());
		sc.log(sc.getContextPath()+" duration is ::"+(end-start)+" ms");
				
	}

}
