package com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("MyWebAppInitializer start ------------");
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();  
        rootContext.register(AppConfig.class, SecurityConfig.class);
		
        servletContext.addListener(new ContextLoaderListener(rootContext));  
        
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();  
        webContext.register(WebCofig.class);  
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));  
        registration.setLoadOnStartup(1);  
        registration.addMapping("/");  

	}

}
