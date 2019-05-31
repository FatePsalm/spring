package basic;

public class MessageBean {

	public MessageBean() {
		System.out.println("无参构造器");
	}
	public void destroy(){
		System.out.println("销毁方法");
	}
	public void init(){
		System.out.println("init()");
	}
}
