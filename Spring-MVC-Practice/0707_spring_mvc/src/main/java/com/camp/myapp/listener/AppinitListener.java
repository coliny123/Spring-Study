package com.camp.myapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//web.xml에 ???
@WebListener
public class AppinitListener implements ServletContextListener {

    public AppinitListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext ctx = sce.getServletContext();
         ctx.setAttribute("root", ctx.getContextPath());
    }
	
}
