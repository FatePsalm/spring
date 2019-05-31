package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor{
	/*
	 * DispatcherServlet���յ�����֮����ȵ�����������preHandle����
	 * ����÷����ķ���ֵΪtrue,��ʾ����������,����,�ж�����(����������)
	 * ע��
	 * handler:��������������,����ͨ���ö����ô������ķ�����,��������,����ֵ���͵�
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle()");
		return true;
	}
	/*
	 * ������(Controller)�ķ����Ѿ�ִ�����,��׼����������(ModerAndView)���ظ�DispatcgerServlet֮ǰִ��
	 * postHandle����
	 * �����ڸ÷��������޸�
	 * ModelAndView
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("PostpreHandle()");
		
	}
	/*
	 * ���ִ�еķ���
	 * ex�Ǵ����������׳����쳣
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion()");
		// TODO Auto-generated method stub
		
	}
	
}
