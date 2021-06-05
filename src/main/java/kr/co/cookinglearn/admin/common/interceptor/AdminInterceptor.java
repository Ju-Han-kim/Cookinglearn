package kr.co.cookinglearn.admin.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.cookinglearn.user.model.UserVO;


public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		//user.model.UserVO 이용
		UserVO user = (UserVO)session.getAttribute("login");
		
		if(user == null || user.getAdminLevel() <= 0) {
			response.sendRedirect("/?msg=noadmin");
		}
		
		return true;
	}
	
}
