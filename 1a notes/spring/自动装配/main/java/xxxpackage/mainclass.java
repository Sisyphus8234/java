package xxxpackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainclass {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext xxx1 = new ClassPathXmlApplicationContext("spring.xml");

		UserLogin u1 = xxx1.getBean("userLogin111", UserLogin.class);
		u1.doPost();
		
		WangLogin w1 = xxx1.getBean("wangLogin", WangLogin.class);
		w1.doPost();
		
		
		xxx1.close();
	}

}
