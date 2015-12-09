
public class ThreadA {
    public static void main(String[] args){
    	int request = 5;
        ThreadB b = new ThreadB(request);
        b.start();
 
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            int result = b.get();
            System.out.println("Total is: " + result);
            b.notify();
        }
    }
}