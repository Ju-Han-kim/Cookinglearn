package kr.co.cookinglearn.admin.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ClassInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		String currentPage = request.getParameter("currentPage");
		
		if(currentPage == null)
			response.sendRedirect("/admin/");
		
		return true;
	}
	
}
