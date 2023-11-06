package thread.waitingnotifying;

public class WaitNotifyScenario{
    public static void main(String... args) throws InterruptedException{
        MessageDisplay md = new MessageDisplay();
        Thread t1 = new Thread(
            ()-> {
                while(MessageDisplay.m < 10)
                    md.setMessage("Hi!");
            }, "T1" );
        //t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(
            ()-> {
                while(MessageDisplay.m < 10)
                    md.setMessage("Howdy!");
            }, "T2" );
        //t2.setDaemon(true);
        t2.start();  

        Thread t3 = new Thread(
            ()-> {
                while(MessageDisplay.m < 10)
                    md.displayMessage();
            }, "T3" );
        //t3.setDaemon(true);
        t3.start(); 

        Thread t4 = new Thread(
            ()-> {
                while(MessageDisplay.m < 10)
                    md.displayMessage();
            }, "T4" );
       //t4.setDaemon(true);
       t4.start();   

        Thread.sleep(5); 
        System.out.println("Exit from main.");
    }
}