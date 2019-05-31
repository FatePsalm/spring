package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@ExceptionHandler
	public String handle(Exception e,HttpServletRequest request){
		/*异常处理方法
		 *当处理器的方法发生了异常,
		 *就会调用异常处理方法来处理!
		 *依据异常类型,做不同的处理
		 *
		 */
		if(e instanceof NumberFormatException){
			request.setAttribute("msg", "亲,请输入合法的数字"); 
			return "error3";
		}else if(e instanceof StringIndexOutOfBoundsException){
			request.setAttribute("msg", "下标越界");
			return "error3";
		}
		return "error";
		
	}
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		Integer.parseInt("123abc");
		return "hello";
		
	}
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2()");
		String str="abcd";
		str.charAt(10);
		return "hello";
		
	}
}
