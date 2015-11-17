import java.util.ArrayList;
public class ManyThreads {

  public static int size=0;
 public static ArrayList<Thread> threadList = new ArrayList<>(5);
 public void test()throws InterruptedException{
   while(size<5){
     synchronized(threadList){
       threadList.add(new Thread(){
         @Override public void run(){
           System.out.println("Hello world from "+Thread.currentThread().getId());
         }
       });
     }
     size++;
   }
   for(Thread t : threadList){
     t.start();
   }
 }
  public static void main(String []args)throws InterruptedException{
    new ManyThreads().test();
}
}
