package xxxpackage;

public class UserLogin {

	private UserDao u;

	public void setUserDao111(UserDao u) {
		System.out.println("setUserDao111(UserDao u)");
		this.u = u;
	}

	public void doPost() {
		System.out.println("UserLogin.doPost()");

		u.login();
	}

}
