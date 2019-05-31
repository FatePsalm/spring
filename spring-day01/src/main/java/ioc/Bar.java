package ioc;

public class Bar {
	private Foo foo;
	
	public Bar() {
		System.out.println("Bar()");
	}

	public Bar(Foo foo) {
		System.out.println("Bar(foo)");
		this.foo=foo;
	}

	@Override
	public String toString() {
		return "Bar [foo=" + foo + "]";
	}
	
}
