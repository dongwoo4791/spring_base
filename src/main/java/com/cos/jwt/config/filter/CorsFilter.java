package com.cos.jwt.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter{

	public static final String TAG = "MyFilter1 : ";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CORS 필터 작동");
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Headers", "*");
		//해당헤더가 없으면 기본적인 헤드정보밖에 추출 못함.
		resp.setHeader("Access-Control-Expose-Headers", "*");
		chain.doFilter(request, response);
	}

}
