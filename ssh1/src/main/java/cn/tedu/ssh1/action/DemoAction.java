package cn.tedu.ssh1.action;

/**
 * Struts 2 的子控制器 
 */
public class DemoAction {

	//控制器中, 处理Web请求的方法
	//默认情况下方法名为 execute
	//方法的返回值是 字符串,值是目标视图的名称
	public String execute(){
		
		//调用业务模型, 调用业务层...
		System.out.println("Hello World!"); 
		
		return "success"; //反馈给用户的视图名
	}
}



