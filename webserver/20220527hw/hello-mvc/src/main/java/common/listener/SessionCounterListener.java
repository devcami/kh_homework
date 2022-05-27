package common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCounterListener
 *
 */
//@WebListener
public class SessionCounterListener implements HttpSessionListener {
	
	private static int activeSessions; //접속하고 있는 사용자 수
    /**
     * Default constructor. 
     */
    public SessionCounterListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	//세션이 생성되면 
    	activeSessions++;
    	System.out.println("> 세션생성 . 접속 사용자 수 : " + activeSessions);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//개발 시에만 0보다 큰 조건 -> 가끔 음수됨
    	if(activeSessions > 0) activeSessions--;
    	System.out.println("> 세션폐기 . 접속 사용자 수 : " + activeSessions);
    }
	
}
