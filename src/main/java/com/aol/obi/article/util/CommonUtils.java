package com.aol.obi.article.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class CommonUtils {

	
	public static String getAppHostName(HttpServletRequest request) {
		String hostName = null;
		try {
			String requestURL = request.getRequestURL().toString();
			String host = requestURL.substring(0, requestURL.indexOf(request.getContextPath()));
			host = host + (request.getContextPath().startsWith("/") ? request.getContextPath() : "/" + request.getContextPath()) + "/";
			hostName = host.endsWith("/") ? host : (host + "/");
			return hostName;
		} catch (Exception e) {
			return null;
		}
	}
}
