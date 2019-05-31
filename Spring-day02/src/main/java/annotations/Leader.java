package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("ld")
public class Leader {
	private Computer cp;
	@Autowired
	public Leader(@Qualifier("cp")Computer cp) {
		System.out.println("Leader(Computer cp)");
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Leader [cp=" + cp + "]";
	}
	
}
