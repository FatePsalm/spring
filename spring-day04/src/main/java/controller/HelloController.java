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
 * 处理器
 * 1:不用实现Controller接口
 * 2:可以添加多个方法
 * 3:方法名不作要求,返回类型可以是ModelAndView,也可以是String
 * 4:方法前面可以添加@Requestmapping注解
 * 注:该注解作用相当于HandlerMapping
 * 另外,该注解也可以添加到类前面
 * http://ip:port/spring-day04/hello.do
 * 5.在类前面添加@Controller
 * 注:该注解用于组件扫描
 */
@Controller
public class HelloController {
	@RequestMapping("/bmi7.do")
	public String bmi7(BmiParam bp,HttpSession session){
		System.out.println("bmi7()");
		double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
		String status="正常";
		if(bmi>25){
			status="过重";
		}
		if(bmi<19){
			status="过轻";
		}
		//将数据绑定到session对象上面
		session.setAttribute("status", status);
		return "bmi";
		
	}
	@RequestMapping("/bmi6.do")
	public String bmi6(BmiParam bp,ModelMap mm){
		System.out.println("bmi6()");
		double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
		String status="正常";
		if(bmi>25){
			status="过重";
		}
		if(bmi<19){
			status="过轻";
		}
		//将数据添加到ModelMap对象
		mm.addAttribute("status",status);
		return "bmi";
		
	}
	@RequestMapping("/bmi5.do")
	public ModelAndView bmi5(BmiParam bp){
		System.out.println("bmi5()");
		double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
		String status="正常";
		if(bmi>25){
			status="过重";
		}
		if(bmi<19){
			status="过轻";
		}
		//将数据先放到ModelAndView对象里面
		//相当于request.setAttribute
		Map<String,Object> data=new HashMap<String, Object>(); 
		data.put("status", status);
		ModelAndView mav=new ModelAndView("bmi",data);
		return mav;
		
	}
	@RequestMapping("/bmi4.do")
	public String bmi4(BmiParam bp,HttpServletRequest request){
		System.out.println("BMI4()");
		double bmi=bp.getWeight()/bp.getHeight()/bp.getHeight();
		String status="正常";
		if(bmi>25){
			status="过重";
		}
		if(bmi<19){
			status="过轻";
		}
		//将数据绑定
		request.setAttribute("status", status);
		//DispatcherServlet默认会使用转发
		return "bmi";
		
	}
	@RequestMapping("/bmi3.do")
	public String bmi3(BmiParam bp){
		System.out.println("BMI3()");
		System.out.println(bp.getHeight()+bp.getWeight());
		return null;
		
	}
	@RequestMapping("/bmi2.do")
	/*@RequestParam对应参数名与参数的关系
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
		//返回一个视图名
		return "hello";
		
	}
	@RequestMapping("/tobmi.do")
	public String tobmi(){
		
		System.out.println("tobmi()");
		return "tobmi";
		
	}
	@RequestMapping("/bmi.do")
	/*
	 * (了解)
	 * DispatcherServlet在调用处理器的方法之前
	 * 会利用java的反射分析方法的结构 比如这儿
	 * 会将request对象作为参数传进来
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
		String status="正常";
		if(bmi>25){
			status="过重";
		}
		if(bmi<19){
			status="过轻";
		}
		request.setAttribute("status", status);
		System.out.println("bmi()");
		return "bmi";
	}
}





































