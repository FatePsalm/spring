package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mg")
public class Manager {
	//只是赋值,加到方法前面可以执行输出语句
	@Autowired
	@Qualifier("cp")
	private Computer cp;

	public Manager() {
		System.out.println("Manager()");
	}

	public Computer getCp() {
		return cp;
	}
//@Autowired
////cp是被注入的bean的ID 不加是按照对象查找
//	public void setCp(@Qualifier("cp")Computer cp) {
//		System.out.println("setCp(Computer cp)");
//		this.cp = cp;
//	}

//cp是被注入的bean的ID 不加是按照对象查找
public void setCp(Computer cp) {
	System.out.println("setCp(Computer cp)");
	this.cp = cp;
}

	@Override
	public String toString() {
		return "Manager [cp=" + cp + "]";
	}
	
}
