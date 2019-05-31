package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mg")
public class Manager {
	//ֻ�Ǹ�ֵ,�ӵ�����ǰ�����ִ��������
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
////cp�Ǳ�ע���bean��ID �����ǰ��ն������
//	public void setCp(@Qualifier("cp")Computer cp) {
//		System.out.println("setCp(Computer cp)");
//		this.cp = cp;
//	}

//cp�Ǳ�ע���bean��ID �����ǰ��ն������
public void setCp(Computer cp) {
	System.out.println("setCp(Computer cp)");
	this.cp = cp;
}

	@Override
	public String toString() {
		return "Manager [cp=" + cp + "]";
	}
	
}
