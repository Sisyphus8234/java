//请看输出结果
public class aaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		b b1=new b();
		b.c c1=b1.f();
System.out.println(c1.getClass());
	}

}


class b{
	c f(){
		return new c();
	}
	
	class c{}
}