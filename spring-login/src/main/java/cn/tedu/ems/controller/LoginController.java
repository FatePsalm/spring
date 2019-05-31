package cn.tedu.ems.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.ApplicationException;
import cn.tedu.ems.service.LoginService;
@Controller
public class LoginController {
	@ExceptionHandler
	public String handler(Exception e,HttpServletRequest request){
		if(e instanceof ApplicationException){
			request.setAttribute("login_failed", e.getMessage());
			return "login";
		}
		System.out.println("系统异常"+e.getMessage());
		return "error";
		
	}
	@Resource(name="loginService")
	private LoginService ls;
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	@RequestMapping("/checkcode.do")
	//输出验证码图片
	public void checkcode(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		System.out.println("checkcode...");
		/*
		 * step1生成图片0-255
		 */
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics g=image.getGraphics();
		//给笔设置颜色
		g.setColor(new Color(255,255,255));
		//设置画布颜色
		g.fillRect(0, 0, 80, 30);
		//重新给画笔设置颜色
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.setFont(new Font(null,Font.BOLD,24));
		//生成一个随机数
		String number=r.nextInt(88888)+"";
		//将验证码绑定到Session对象上
		session.setAttribute("number", number);
		//将随机数画出来
		g.drawString(number, 5, 25);
		for(int i=0;i<8;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(80), r.nextInt(30), r.nextInt(30));
			
		}
		//告诉浏览器,服务器返回的是一个图片
		response.setContentType("image/jpeg");
		//要获得字节流输出
		OutputStream output=response.getOutputStream();
		//将图片压缩按照指定的格式(jpeg)进行输出
		/*
		 * step2压缩图片并
		 */
		javax.imageio.ImageIO.write(image, "jpeg", output);
		output.close();
	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session,HttpServletResponse response){
		System.out.println("login()");
		String username=request.getParameter("username");
		String password=request.getParameter("pwd");
		String number=request.getParameter("number");
		String action=(String) session.getAttribute("number");
		
		if(!ls.checkNumber(number, action)){
			request.setAttribute("number_error", "验证码错误!");
			System.out.println("验证码错误!");
			return "login";
		}
		System.out.println("username="+username);
		System.out.println("password="+password);
		//将请求分发给业务层来处理
		User user=ls.checkLogin(username, password);
		System.out.println("执行checkLogin");
		//登录成功,将user对象绑定到Session对象上
		session.setAttribute("user", user);
//		try{
//		}catch(Exception e){
//			e.printStackTrace();
//			//依据异常类型,分别做不同的处理
//			if(e instanceof ApplicationException){
//				//应用异常,应明确提示用户
//				request.setAttribute("login_failed", e.getMessage());
//				return "login";
//			}
//			//系统异常,提示用户稍后重试
//			return "erorr";
//		}
		
		//登录成功,重定向 
		return "redirect:toIndex.do";
		
	}
	@RequestMapping("/toIndex.do")
	public String toIndex(HttpServletRequest request){
		
		return "index";
		
	}
}
