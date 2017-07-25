package com.ykkj.weiyi.filter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener {  
private static int activeSessions =0;

@Override
public void sessionCreated(HttpSessionEvent arg0) {
	System.out.println("sessionCreated id==="+arg0.getSession().getId());
	
}

@Override
public void sessionDestroyed(HttpSessionEvent arg0) {
	// TODO Auto-generated method stub
	System.out.println("sessionCreated id==="+arg0.getSession().getId());
	
}  
}  
