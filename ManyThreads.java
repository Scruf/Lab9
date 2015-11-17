import java.util.ArrayList;
public class ManyThreads {

  public static int size=0;
 public static ArrayList<Thread> threadList = new ArrayList<>(5);
 
 public void test(int num)throws InterruptedException{
    
   while(size<num){
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
    int number=0;
      if(args.length>1){
        System.out.println("ManyThreads:  Invalid number");
        System.exit(1);
      }
      if (args.length<1){
        System.out.println("Usage:  java ManyThreads number-of-threads");
          System.exit(1);
      }
    try{
        number = Integer.parseInt(args[0]);
    }catch(Exception ex){
        System.out.println("Usage: java ManyThread you entered not Integer");
        System.exit(1);
    }
    number = Integer.parseInt(args[0]);
    new ManyThreads().test(number);
}
}
