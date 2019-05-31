package ioc;

public class Restaurant {
	private Waiter waiter;

	public Restaurant() {
		System.out.println("Restaurant()");
		// TODO Auto-generated constructor stub
	}

	public Restaurant(Waiter waiter) {
		System.out.println("Restaurant(waiter)");
		this.waiter = waiter;
	}

	@Override
	public String toString() {
		return "Restaurant [waiter=" + waiter + "]";
	}
		

}
