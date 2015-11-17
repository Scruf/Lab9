
public class ManyThreads implements Runnable{



  public static void main(String []args){
    ManyThreads many = new ManyThreads();
    Thread thread = new Thread(many);

      thread.start();
    
  }
  @Override
  public void run(){
  for(int i=0;i<10;i++)
    System.out.println("Hello world from a thread "+Thread.currentThread().getId());
  }
}
