package Archive;

public class Bar implements Runnable{
    @Override
    public void run(){
        for (int i = 10; i > 0; i--){
            System.out.println("Thread " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread 2? is done");
    }
}
