public class Demo {
    public static void main(String[] args) {
    	
    	
    use(new Add(){public void addnum(int x,int y){System.out.println(x+y);}},
    		300,500);
    
    
    }
    
    public static void use(Add add,int x,int y) {
    	add.addnum(x, y);
    	}
}

interface Add{
	public void addnum(int x,int y);	
	}