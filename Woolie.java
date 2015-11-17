public class Woolie extends java.lang.Thread implements Runnable{
    //@param woolieName will hold a name of the Woolie
    private String woolieName;
    //@param crossingTime will hold the ammount of time need in order to cross the bridge
    private int crossingTime;
    //@param destination  will hold a name of the final destination
    private String destination;
    public Woolie(java.lang.String myName,int myCrossingTime,java.lang.String myDestination){
        this.woolieName = myName;
        this.crossingTime=myCrossingTime;
        this.destination = myDestination;
    }
    /*
        method getWoolieName will return Name of the Woolie
    */
    public java.lang.String getWoolieName(){return this.woolieName;}
    /*
        method getCrossingTime will return a time needed for a Woolie to cross a bridge
    */
    public int getCrossingTime(){return this.crossingTime;}
    /*
        method getDestination will return a destination  where Woolie will go
    */
    public java.lang.String getDestination(){return this.destination;}
    public void run(){
        System.out.println(getWoolieName()+" has arrived at the bridge");
        System.out.print(getWoolieName()+" is starting to cross");
        
    }
    public static void main(String []args){
        new Woolie("Bob",1,"Mordor").start();
    }
}