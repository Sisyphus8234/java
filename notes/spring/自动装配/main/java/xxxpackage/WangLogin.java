package xxxpackage;

public class WangLogin {

	private WangDao222 w;

	public void set111(WangDao222 w) {
		System.out.println("setWangDao(WangDao w)");
		this.w = w;
	}

	public void doPost() {
		System.out.println("WangLogin.doPost()");

		w.login();
	}

}
