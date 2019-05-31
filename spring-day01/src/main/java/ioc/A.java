package ioc;

public class A {
	private IB b;
	
	
	public IB getB() {
		return b;
	}
	public void setB(IB b) {
		this.b = b;
	}
	public A() {
		System.out.println("A");
	}
	public void service(){
		System.out.println("A's service");
		b.f1();
	}
	
}
