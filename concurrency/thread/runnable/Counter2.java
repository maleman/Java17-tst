
package thread.runnable;

public class Counter2 extends Thread {
    public int currentValue;

    public Counter2(){
        this.currentValue = 0;
    } 

    @Override
    public void run(){
        while(currentValue < 5){
            System.out.printf("%s: %s%n \n", super.getName(), this.currentValue++);
             try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(super.getName() + " interrupted.");
            }
        }
        System.out.println("Exiting " + super.getName());
    } 

    public static void main(String... args) { 
        String threadName = Thread.currentThread().getName(); 
        System.out.println("Method main() runs in thread " + threadName);

        var counterA = new Counter2();
        var counterB = new Counter2();

        counterA.setName("Counter A");
        counterB.setName("Counter B");

        //counterA.setDaemon(true);
        //counterB.setDaemon(true);


        System.out.println("Starting " + counterA.getName()); 
        counterA.start();

        System.out.println("Starting " + counterB.getName()); 
        counterB.start();

        System.out.println("Exiting Thread " + threadName);
    }    
}    