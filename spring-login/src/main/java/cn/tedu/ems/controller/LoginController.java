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
		System.out.println("ϵͳ�쳣"+e.getMessage());
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
	//�����֤��ͼƬ
	public void checkcode(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		System.out.println("checkcode...");
		/*
		 * step1����ͼƬ0-255
		 */
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//��û���
		Graphics g=image.getGraphics();
		//����������ɫ
		g.setColor(new Color(255,255,255));
		//���û�����ɫ
		g.fillRect(0, 0, 80, 30);
		//���¸�����������ɫ
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.setFont(new Font(null,Font.BOLD,24));
		//����һ�������
		String number=r.nextInt(88888)+"";
		//����֤��󶨵�Session������
		session.setAttribute("number", number);
		//�������������
		g.drawString(number, 5, 25);
		for(int i=0;i<8;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(80), r.nextInt(30), r.nextInt(30));
			
		}
		//���������,���������ص���һ��ͼƬ
		response.setContentType("image/jpeg");
		//Ҫ����ֽ������
		OutputStream output=response.getOutputStream();
		//��ͼƬѹ������ָ���ĸ�ʽ(jpeg)�������
		/*
		 * step2ѹ��ͼƬ��
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
			request.setAttribute("number_error", "��֤�����!");
			System.out.println("��֤�����!");
			return "login";
		}
		System.out.println("username="+username);
		System.out.println("password="+password);
		//������ַ���ҵ���������
		User user=ls.checkLogin(username, password);
		System.out.println("ִ��checkLogin");
		//��¼�ɹ�,��user����󶨵�Session������
		session.setAttribute("user", user);
//		try{
//		}catch(Exception e){
//			e.printStackTrace();
//			//�����쳣����,�ֱ�����ͬ�Ĵ���
//			if(e instanceof ApplicationException){
//				//Ӧ���쳣,Ӧ��ȷ��ʾ�û�
//				request.setAttribute("login_failed", e.getMessage());
//				return "login";
//			}
//			//ϵͳ�쳣,��ʾ�û��Ժ�����
//			return "erorr";
//		}
		
		//��¼�ɹ�,�ض��� 
		return "redirect:toIndex.do";
		
	}
	@RequestMapping("/toIndex.do")
	public String toIndex(HttpServletRequest request){
		
		return "index";
		
	}
}
