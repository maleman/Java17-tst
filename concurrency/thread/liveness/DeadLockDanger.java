package thread.liveness;

public class DeadLockDanger{

    public static void main(String... args){

        String o1 = "o1";
        String o2 = "o2";

        Thread t1 = (new Thread("t1"){
                @Override
                public void run(){
                    String threadName = Thread.currentThread().getName();
                    while(true){
                        synchronized(o1){
                            System.out.println(threadName+" Acquired "+o1);
                            synchronized(o2){
                                System.out.println(threadName+" : "+o1+" : "+ o2);
                            }
                        }
                    } 
                }
            }
        );

        Thread t2 = (new Thread("t2"){
                @Override
                public void run(){
                    String threadName = Thread.currentThread().getName();
                    while(true){
                        synchronized(o2){
                            System.out.println(threadName+" Acquired "+o1);
                            synchronized(o1){
                                System.out.println(threadName+" : "+o1+" : "+ o2);
                            }
                        }
                    } 
                }
            }
        );

        t1.start(); 
        t2.start();
        System.out.println("Exiting main.");
    }

}