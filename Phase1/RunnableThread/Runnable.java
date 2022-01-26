package RunnableThread;

public class Runnable {

	public static int myCount = 0;
    public Runnable(){
         
    }
    public void run() {
        while(Runnable.myCount <= 10){
            try{
                System.out.println("Expl Thread: "+(++Runnable.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
    } 
    public static void main(String a[]){
        System.out.println("Starting Main Thread...");
        Runnable mrt = new Runnable();
        Thread t = new Thread();
        t.start();
        while(Runnable.myCount <= 10){
            try{
                System.out.println("Main Thread: "+(++Runnable.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex){
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("End of Main Thread...");
    }
}


