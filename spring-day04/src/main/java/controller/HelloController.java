package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * ������
 * 1:����ʵ��Controller�ӿ�
 * 2:������Ӷ������
 * 3:����������Ҫ��,�������Ϳ�����ModelAndView,Ҳ������String
 * 4:����ǰ��������@Requestmappingע��
 * ע:��ע�������൱��HandlerMapping
 * ����,��ע��Ҳ������ӵ���ǰ��
 * http://ip:port/spring-day04/hello.do
 * 5.����ǰ�����@Controller
 * ע:��ע���������ɨ��
 */
@Controller
public class HelloController {
	@RequestMapping("/bmi7.do")
	public String bmi7(BmiParam bp,HttpSession session){
		System.out.println("bmi7()");
		double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
		String status="����";
		if(bmi>25){
			status="����";
		}
		if(bmi<19){
			status="����";
		}
		//�����ݰ󶨵�session��������
		session.setAttribute("status", status);
		return "bmi";
		
	}
	@RequestMapping("/bmi6.do")
	public String bmi6(BmiParam bp,ModelMap mm){
		System.out.println("bmi6()");
		double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
		String status="����";
		if(bmi>25){
			status="����";
		}
		if(bmi<19){
			status="����";
		}
		//��������ӵ�ModelMap����
		mm.addAttribute("status",status);
		return "bmi";
		
	}
	@RequestMapping("/bmi5.do")
	public ModelAndView bmi5(BmiParam bp){
		System.out.println("bmi5()");
		double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
		String status="����";
		if(bmi>25){
			status="����";
		}
		if(bmi<19){
			status="����";
		}
		//�������ȷŵ�ModelAndView��������
		//�൱��request.setAttribute
		Map<String,Object> data=new HashMap<String, Object>(); 
		data.put("status", status);
		ModelAndView mav=new ModelAndView("bmi",data);
		return mav;
		
	}
	@RequestMapping("/bmi4.do")
	public String bmi4(BmiParam bp,HttpServletRequest request){
		System.out.println("BMI4()");
		double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
		String status="����";
		if(bmi>25){
			status="����";
		}
		if(bmi<19){
			status="����";
		}
		//�����ݰ�
		request.setAttribute("status", status);
		//DispatcherServletĬ�ϻ�ʹ��ת��
		return "bmi";
		
	}
	@RequestMapping("/bmi3.do")
	public String bmi3(BmiParam bp){
		System.out.println("BMI3()");
		System.out.println(bp.getHeight()+bp.getWeight());
		return null;
		
	}
	@RequestMapping("/bmi2.do")
	/*@RequestParam��Ӧ������������Ĺ�ϵ
	 * 
	 */
	public String bmi2(@RequestParam("height")String ht,String weight){
		System.out.println("bmi2()");
		System.out.println("height="+ht+","+"weight="+weight);
		return null;
		
	}
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		//����һ����ͼ��
		return "hello";
		
	}
	@RequestMapping("/tobmi.do")
	public String tobmi(){
		
		System.out.println("tobmi()");
		return "tobmi";
		
	}
	@RequestMapping("/bmi.do")
	/*
	 * (�˽�)
	 * DispatcherServlet�ڵ��ô������ķ���֮ǰ
	 * ������java�ķ�����������Ľṹ �������
	 * �Ὣrequest������Ϊ����������
	 */
	public String bmi(HttpServletRequest request,HttpServletResponse response){
		Double bmi = null;
		try{
			Double weight=Double.parseDouble(request.getParameter("weight"));
			Double height=Double.parseDouble(request.getParameter("height"));
			bmi=weight/height/height;
		}catch(Exception e){
			return "error";
		}
		String status="����";
		if(bmi>25){
			status="����";
		}
		if(bmi<19){
			status="����";
		}
		request.setAttribute("status", status);
		System.out.println("bmi()");
		return "bmi";
	}
}





































