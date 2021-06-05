package kr.co.cookinglearn.user.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.cookinglearn.user.model.UserVO;

public class UserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		UserVO user = (UserVO)session.getAttribute("login");
		
		if(user == null) {
			response.sendRedirect("/?msg=login");
			return false;
		}
		
		return true;
	}
	
}
