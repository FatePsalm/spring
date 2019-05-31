package annotations;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("stu")
public class Student {
	@Resource(name="cp")
	private Computer cp;
	
	public Student() {
		System.out.println("Student()");
	}

	public Computer getCp() {
		return cp;
	}
//	@Resource(name="cp")
//	public void setCp(Computer cp) {
//		System.out.println("Student's setCp()");
//		this.cp = cp;
//	}
	public void setCp(Computer cp) {
		System.out.println("Student's setCp()");
		this.cp = cp;
	}
	@Override
	public String toString() {
		return "Student [cp=" + cp + "]";
	}
	
}
