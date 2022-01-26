package InnerClasses;

public class Inner2 {

	private String msg="Inner Classes";

	 void display(){  
		 class Inner{  
			 void msg(){
				 System.out.println(msg);
			 }  
	  }  
	  
	  Inner l=new Inner();  
	  l.msg();  
	 }  

	 
	public static void main(String[] args) {
		Inner2  ob=new Inner2 ();  
		ob.display();  
		}
	}


	//anonymous inner class
	abstract class AnonymousInnerClass {
		   public abstract void display();
		}





