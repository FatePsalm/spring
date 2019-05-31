package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BMIService;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(action);
		//依据请求路径,调用对应的模型来处理
		if("/toBmi".equals(action)){
			request.getRequestDispatcher("/WEB-INF/bmi_form.jsp").forward(request, response);
		}else if("/bmi".equals(action)){
			BMIService bs=new BMIService();
			String height=request.getParameter("height");
			String weight=request.getParameter("weight");
			System.out.println("height="+height);
			System.out.println("weight="+weight);
			//这儿,应该要求对请求参数做合法性检查
			String status=bs.bmi(Double.parseDouble(height), Double.parseDouble(weight));
			//依据模型返回的结果,调用对应的视图来进行展现
			request.setAttribute("status", status);
			request.getRequestDispatcher("/WEB-INF/view.jsp").forward(request, response);
		}

	}

}
