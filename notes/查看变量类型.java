package d1;

public class hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 100000;
		
		System.out.println(getType(a));	

	}
	private static String getType(Object a) {
        return a.getClass().toString();}
	
}
