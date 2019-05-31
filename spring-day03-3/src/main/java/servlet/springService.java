package servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class springService implements Controller{

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		Double height=Double.parseDouble(arg0.getParameter("height"));
		Double weight=Double.parseDouble(arg0.getParameter("weight"));
		Map<String, String> map=new HashMap<String, String>();
		String status="正常";
		
		//计算bmi指数 
		double bmi=weight/height/height;
		//依据bmi指数,判断身体状况
		if(bmi>25){
			status="过重";
			
//			System.out.println(status);
		}
		if(bmi<19){
			status="过轻";
//			System.out.println(status);
		}
		map.put("status", status);
//		arg0.setAttribute("status", status);
		System.out.println(map);
		return new ModelAndView("bmi",map);
	}

}









