package Archive;

import java.util.List;

public class Consumer implements Runnable{
    private final List<Integer> taskQueue;

    public Consumer(List<Integer> sharedQueue){
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true){
            try{
                consume();

            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException{
        synchronized (taskQueue){
            while (taskQueue.isEmpty()){
                System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting");
                taskQueue.wait();
            }
            int i = (Integer) taskQueue.remove(0);
            System.out.println("Consumed: " + i);
            taskQueue.notifyAll();
        }
        Thread.sleep(500);
    }
}
