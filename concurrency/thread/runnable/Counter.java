
package thread.runnable;

public class Counter implements Runnable {
    private int currentValue = 0;

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        while(currentValue < 5){
            System.out.printf("%s: old:%s new;%s%n \n", threadName, this.currentValue, ++this.currentValue);
             try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println("Exiting " + threadName);
    } 

    public static void main(String... args) { 
        String threadName = Thread.currentThread().getName(); 
        System.out.println("Method main() runs in thread " + threadName);

        Counter counter = new Counter();

        Thread threadA = new Thread(counter, "Thread A");
        Thread threadB = new Thread(counter, "Thread B");

        System.out.println("Starting " + threadA.getName()); 
        threadA.start();

        System.out.println("Starting " + threadB.getName()); 
        threadB.start();

        System.out.println("Exiting Thread " + threadName);
    }    
}    