package zbc1;

class A {
	int x=1;
	int y=2;
	
	public void f() {
		System.out.println("这是父类,"+x+","+y);
	}	
}

 
public class B extends A{
	int y=3;
	
	@Override
	public void f() {		
		super.f();
		System.out.println("子类");
		System.out.println(y);
		System.out.println(super.y);
	}
	
	public static void main(String[] args) {		
		B b=new B();
		b.f();	
	}
}
