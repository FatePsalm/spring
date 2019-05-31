package basic;

public class ExampleBean {

	public ExampleBean() {
		System.out.println("ExampleBean()");
	}
	public void service(){
		System.out.println("service()");
	}
	public void init(){
		System.out.println("init()");
	}
	public void destroy(){
		System.out.println("destroy()");
	}
}
