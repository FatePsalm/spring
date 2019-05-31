package ioc;

public class LoginService {
	private IUserDAO iuser;

	public IUserDAO getIuser() {
		return iuser;
	}
	public void setIuser(IUserDAO iuser) {
		this.iuser = iuser;
	}
	public LoginService() {
		System.out.println("LoginService()");
	}
	public void service(){
		System.out.println("service()");
		iuser.f1();
	}
	
}
