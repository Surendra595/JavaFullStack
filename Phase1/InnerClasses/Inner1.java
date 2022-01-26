package InnerClasses;



public class Inner1 {
 private String msg="Welcome to Java"; 
	 
	 class Inner{  
	  void hello(){System.out.println(msg+", Let us start learning Inner Classes");}  
	 }  


	public static void main(String[] args) {

		Inner1 obj=new Inner1();
		Inner1.Inner in=obj.new Inner();  
		in.hello();  
	}
}




