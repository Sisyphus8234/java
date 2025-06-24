package xxxpackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainclass {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext xxx1 = new ClassPathXmlApplicationContext("spring.xml");

		User u1 = xxx1.getBean("user", User.class);
		
		u1.doPost();
		
		xxx1.close();
	}
}
