package xxxpackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainclass {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext xxx1 = new ClassPathXmlApplicationContext("spring.xml");

		Car c1=xxx1.getBean("car",Car.class);
		
		UserDao u1 = xxx1.getBean("userDao", UserDao.class);
		
		SampleBean s1 = xxx1.getBean("sampleBean", SampleBean.class);
		
		
		User u2 = xxx1.getBean("user", User.class);
		
		SampleBean1 s2 = xxx1.getBean("sampleBean1", SampleBean1.class);
		System.out.println(s2.name);
		
		xxx1.close();
	}
}
