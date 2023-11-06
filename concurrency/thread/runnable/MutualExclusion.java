package thread.runnable;

public class MutualExclusion{

    private int counter = 0;

    public synchronized void increment(){
        System.out.printf("%s : old:%s new:%s \n", Thread.currentThread().getName(), this.counter, ++this.counter);
    }

    public void increment2(){
        synchronized(this){
            System.out.printf("%s : old:%s new:%s \n", Thread.currentThread().getName(), this.counter, ++this.counter);
        }
        
    }

    public static void main(String[] args){
        MutualExclusion me = new MutualExclusion();
        Runnable r1 = () -> {
            for(int i = 0; i<5; i++){
                me.increment2();
            }
             System.out.printf("Exiting thread %s \n", Thread.currentThread().getName());
        };

        new Thread(r1).start();
        new Thread(r1).start();

         System.out.printf("Exiting thread %s \n", Thread.currentThread().getName());
    }
}