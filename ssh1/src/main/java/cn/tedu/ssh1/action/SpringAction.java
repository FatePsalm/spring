package cn.tedu.ssh1.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller 
//Spring 管理的Bean, ID: springAction
@Scope("prototype") 
public class SpringAction {
	
	public String execute(){
		System.out.println("From Spring");
		return "success";
	}
}







