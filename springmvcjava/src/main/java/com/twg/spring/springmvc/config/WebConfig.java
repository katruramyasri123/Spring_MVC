package com.twg.spring.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(JavaConfig.class);
		DispatcherServlet ds=new DispatcherServlet(context);
		javax.servlet.ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher",ds);
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
