package thread.waitingnotifying;

public class MessageDisplay{

    private String message;
    public static int m = 0;

    public synchronized void displayMessage(){
        String threadName = Thread.currentThread().getName();
        while(this.message == null){
           try{ 
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println(threadName+": "+this.message);
        this.message = null;
        notifyAll();
    }

    public synchronized void setMessage(String message){
        String threadName = Thread.currentThread().getName();
        while(this.message != null){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.message = message;
        System.out.println(threadName+": Message set is "+this.message);
        this.m ++;
        notifyAll();
    }
}