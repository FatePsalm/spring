package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor{
	/*
	 * DispatcherServlet在收到请求之后会先调用拦截器的preHandle方法
	 * 如果该方法的返回值为true,表示继续向后调用,否则,中断请求(不在向后调用)
	 * 注释
	 * handler:处理器方法对象,可以通过该对象获得处理器的方法名,参数类型,返回值类型等
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle()");
		return true;
	}
	/*
	 * 处理器(Controller)的方法已经执行完毕,正准备将处理结果(ModerAndView)返回给DispatcgerServlet之前执行
	 * postHandle方法
	 * 可以在该方法里面修改
	 * ModelAndView
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("PostpreHandle()");
		
	}
	/*
	 * 最后执行的方法
	 * ex是处理器方法抛出的异常
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion()");
		// TODO Auto-generated method stub
		
	}
	
}
