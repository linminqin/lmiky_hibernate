package com.lmiky.jdp.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 *
 */
public class CookieUtils {
	
	/**
	 * 获取cookie值
	 * @author lmiky
	 * @date 2013-6-1
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
    	for(int i = (cookies==null ? -1 : cookies.length-1); i>=0; i--) {
    		if(cookies[i].getName().equals(name)) {
    			return cookies[i].getValue();
    		}
    	}
		return null;
	}
	
	/**
	 * 添加cookie值
	 * @author lmiky
	 * @date 2013-6-3
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void addCookie(HttpServletResponse response, String name, String value) {
		addCookie(response, name, value, Integer.MAX_VALUE, "/", null, null);
	}
	
	/**
	 * 添加cookie值
	 * @author lmiky
	 * @date 2013-6-1
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 * @param path
	 * @param domain
	 * @param comment
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge, String path, String domain, String comment) {
		Cookie cookie = new Cookie(name, value);
    	cookie.setPath(path);
    	cookie.setMaxAge(maxAge);
    	if(domain!=null) {
    		cookie.setDomain(domain);
    	}
    	if(comment!=null) {
    		cookie.setComment(comment);
    	}
    	response.addCookie(cookie);
	}
	
	/**
	 * 删除cookie值
	 * @author lmiky
	 * @date 2013-6-3
	 * @param response
	 * @param name
	 */
	public static void removeCookie(HttpServletResponse response, String name) {
		removeCookie(response, name, "/", null);
		removeCookie(response, name, "", null);	//chrome浏览器
	}
	
	/**
	 * 删除cookie值
	 * @author lmiky
	 * @date 2013-6-1
	 * @param response
	 * @param name
	 * @param path
	 * @param domain
	 */
	public static void removeCookie(HttpServletResponse response, String name, String path, String domain) {
		addCookie(response, name, "", 0, path, domain, null);
	}
	
	/**
	 * 删除所有cookie值
	 * @author lmiky
	 * @date 2014-1-19
	 * @param request
	 * @param response
	 */
	public static void removeAllCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
    	for(int i = (cookies==null ? -1 : cookies.length-1); i>=0; i--) {
    		removeCookie(response, cookies[i].getName());
    	}
	}
}