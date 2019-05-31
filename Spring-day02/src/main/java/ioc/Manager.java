package ioc;

public class Manager {
	private Computer cp;

	public void setCp(Computer cp) {
		System.out.println("setCp()");
		this.cp = cp;
	}



	public Manager() {
		System.out.println("Manager()");
	}



	@Override
	public String toString() {
		return "Manager [cp=" + cp + "]";
	}
	
}
