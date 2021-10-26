package xxxpackage;


import java.lang.reflect.Method;

public class mainA {

	public static void main(String[] args) {


		//如果注解是在方法或者属性上，此时就不是获取Class对象，而是Method对象，Field对象
		Class<TestA>  TestAclass= TestA.class;

		if(TestAclass.isAnnotationPresent(Pro.class)){
			//其实是在内存中生成了一个注解接口的实现类，并且创建对象
			//实现类覆写方法String Name()，返回值是"qqqqqq"
			Pro p1= TestAclass.getAnnotation(Pro.class);

			//调用注解中的抽象方法
			String s1=p1.Name();

			System.out.println(s1);
		}

		//方法上的注解
		Method[] methods = TestAclass.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Pro.class)) {
				Pro p2 = method.getAnnotation(Pro.class);
				String s2=p2.Name();
				System.out.println(s2);
			}
		}







	}
}
