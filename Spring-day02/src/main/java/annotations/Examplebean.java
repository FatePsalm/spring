package annotations;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ex")
@Scope("singleton")
@Lazy(false)
public class Examplebean {

	public Examplebean() {
		System.out.println("Examplebean()");
	}
	@Autowired
	public void init(){
		System.out.println("Examplebean's init()");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("Examplebean's destroy()");
	}
	
	
}
