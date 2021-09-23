package xxxpackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainclass {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext xxx1 = new ClassPathXmlApplicationContext("spring.xml");

		
		
		xxx1.close();
	}
}
