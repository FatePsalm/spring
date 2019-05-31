package cn.tedu.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.CheckUsername;

@Controller
public class LoginController {
	@Resource(name="checkUsername")
	private CheckUsername cu;
	@RequestMapping("/*.do")
	public String toLogin(HttpServletRequest request){
		System.out.println("µÇÂ¼Ìø×ª()");
		System.out.println(request.getRequestURI());
		return "login";
		
	}
	@RequestMapping("/loginchecking.do")
	public String login(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ÑéÖ¤ÃÜÂë()");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+","+password);
		boolean flag=cu.checkPassword(username, password);
		return "redirect:emplist.do";
		
		
	}
	@RequestMapping("/checkUsername.do")
	public void checkUsername(HttpServletRequest request,HttpServletResponse response){
		System.out.println("checkUsername.do");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username=request.getParameter("username");
		System.out.println(username);
		String user=cu.check(username);
		out.print(user);
	}
	@RequestMapping("/emplist.do")
	public String emplist(){
		return "emplist";
		
	}
}





















