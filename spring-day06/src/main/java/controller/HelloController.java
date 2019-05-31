package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@ExceptionHandler
	public String handle(Exception e,HttpServletRequest request){
		/*�쳣������
		 *���������ķ����������쳣,
		 *�ͻ�����쳣������������!
		 *�����쳣����,����ͬ�Ĵ���
		 *
		 */
		if(e instanceof NumberFormatException){
			request.setAttribute("msg", "��,������Ϸ�������"); 
			return "error3";
		}else if(e instanceof StringIndexOutOfBoundsException){
			request.setAttribute("msg", "�±�Խ��");
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
