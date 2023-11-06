package thread.termination;

public class Worker implements Runnable{
    private Thread theThread;

    public void kickStart(){
        if(theThread == null){
            theThread = new Thread(this);
            theThread.start();
        }
    }

    public void terminate(){
        theThread = null;
    }

    @Override
    public void run(){
        while(theThread == Thread.currentThread()){
            System.out.println("Going arround in loops");
        }
    }

    public static void main(String... args){
        Worker worker = new Worker();
        System.out.println("Start the worker.");
        worker.kickStart();
        try{
            Thread.sleep(2);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println("Stop the worker."); 
        worker.terminate();
    }
}