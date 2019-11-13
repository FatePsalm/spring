package cn.tedu.ems.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * ������:
 * ����session��֤
 */
public class SessionInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//�Ȼ��session����
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("user");
		if(obj==null){
			//�����session�������Ҳ�����Ӧ������,˵��û�е�¼,�ض��򵽵�¼ҳ��
			response.sendRedirect("toLogin.do");
			return false;
			}
		System.out.println("preHandle()");
		//����Ѿ���¼��,�����������
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}