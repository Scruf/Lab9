import java.util.Queue;
import java.util.LinkedList;

public class Bridge extends java.lang.Object {
    public int numberOfTrols;
    public Queue<Woolie> trollList;
    public Bridge(int num){
        this.numberOfTrols = num;
        this.trollList = new LinkedList<Woolie>();
    }
    public synchronized void enterBridge(Woolie wol){
        trollList.add(wol);
        while(!trollList.isEmpty()){
          
            try{
                wait();
            }
            catch(InterruptedException ie){
                
            }
            trollList.remove(wol);
        }
    }
    public synchronized void leaveBridge(){
        notify();
    }
    public static void main(String []args){
        Bridge bridge = new Bridge(2);
        Thread init = Thread.currentThread();
          Thread peds[] = {
            new Woolie( "Al",    3, "Mordord",bridge ),
            new Woolie( "Bob",   4, "Rohan",bridge ),
        }; 
          for ( int j = 0; j < peds.length; ++j ) {
            // Run them by calling their start() method.
            try {
                peds[j].start();
                init.sleep( 4000 );
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
        // Now, the test must give the woolies time to finish their crossings.
        for ( int j = 0; j < peds.length; ++j ) {
            try {
                peds[j].join();
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
    }
}