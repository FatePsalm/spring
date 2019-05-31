package ioc;

public class UserDAO implements IUserDAO{

	public UserDAO() {
		System.out.println("UserDAO()");
	}
	public void f1(){
		System.out.println("UserDAO's f1()");
	}
}
