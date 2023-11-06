package thread.join;

import thread.runnable.Counter2;

public class AnotherCounterClient{
    public static void main(String... args){
        Counter2 counterA = new Counter2();
        Counter2 counterB = new Counter2();

        counterA.setName("CounterA");
        counterB.setName("CounterB");
        
        counterA.start();
        counterB.start();

        try{
            System.out.println("Wait for the child threads!");
            counterA.join();

            if(!counterA.isAlive())
                System.out.println("Counter A not alive.");
            
            counterB.join();
            if(!counterA.isAlive())
                System.out.println("Counter B not alive.");

        }catch(InterruptedException ie){
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Exiting from main thread.");
    }
}