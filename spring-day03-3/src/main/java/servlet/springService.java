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
		String status="����";
		
		//����bmiָ�� 
		double bmi=weight/height/height;
		//����bmiָ��,�ж�����״��
		if(bmi>25){
			status="����";
			
//			System.out.println(status);
		}
		if(bmi<19){
			status="����";
//			System.out.println(status);
		}
		map.put("status", status);
//		arg0.setAttribute("status", status);
		System.out.println(map);
		return new ModelAndView("bmi",map);
	}

}









