package br.com.pa.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class FilterController extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		/*String uri = request.getRequestURI();
		HttpSession sessao = request.getSession();
		
		if(uri.endsWith("login") || uri.contains("resources")){
			return true;
		}
		else if(sessao.getAttribute("usuarioLogado") != null){
			return true;
		}
		
		response.sendRedirect("login");
		return false;*/
		
		return true;
	}
}
