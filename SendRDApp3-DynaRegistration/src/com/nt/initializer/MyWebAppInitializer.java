package com.nt.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.SearchServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {
	
	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer:: 0-param constructor");
	}

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		System.out.println("MyWebAppInitializer.onStartup()");
		SearchServlet servlet=null;
		ServletRegistration.Dynamic dyna=null;
		//create Servlet class object
		servlet=new SearchServlet();
		//register Servlet
		dyna=sc.addServlet("search",servlet);
		//provide url pattern
		dyna.addMapping("/searchurl");
		//enable Load-on-statup
		dyna.setLoadOnStartup(1);
	
	}

}
