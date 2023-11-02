package thread.state;

public class ThreadStates{

    private static Thread t1 = new Thread("T1"){
        @Override
        public void run(){
            try{
                sleep(1);
                for(int i=0; i<10001; i++)
                ;
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    };

    public static void main(String[] args){
        System.out.println(t1.getState());
        t1.start();
        while(true){
            Thread.State state = t1.getState();
            System.out.println(state);
            if(state == Thread.State.TERMINATED)
                break;
        }
    }
}