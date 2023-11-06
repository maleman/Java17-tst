package thread.interrupt;

public class InterruptHandling{

    private static Runnable task = () ->{
        Thread ct = Thread.currentThread();
        String threadName = ct.getName();
        while(true){
            System.out.println(threadName+" performing task");
            if(ct.isInterrupted()){
                System.out.println(threadName+": interrupted f1"+ct.isInterrupted());
                System.out.println(threadName+" terminating");
                return;
            }
            try{
                Thread.sleep(2);
            }catch(InterruptedException e){
                System.out.println(threadName+" caught "+e);
                System.out.println(threadName+": interrupted f1"+ct.isInterrupted());
                System.out.println(threadName+" terminating");
                return;
            }
        }
    };

    public static void main(String... args)throws InterruptedException{
        Thread worker = new Thread(task,"worker");
        worker.start();
        while(true){
            if((int)(Math.random()*100) %2 == 0){
                worker.interrupt();
                break;
            }
            Thread.sleep(2);
        }
    }
}