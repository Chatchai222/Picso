package Archive;

public class MyPizza implements Runnable{
    private boolean pizzaArrived = false;
    private static MyPizza instance = new MyPizza();
    private MyPizza(){
        pizzaArrived = false;
    }

    public static MyPizza getInstance(){
        return instance;
    }

    public void eatPizza() throws InterruptedException {
        System.out.println("Ordered pizza so I'll have to wait for some time before before I eat?");
        try{
            Thread.sleep(2000);
            System.out.println("I thought he said he would in arrive in 2 mintues? what is taking him so long");
            Thread.sleep(1000);
            System.out.println("Ah what ever I guess I'll wait");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        synchronized (this){
            while(!pizzaArrived){
                System.out.println("In the mean time I'll watch TV");
                this.wait();

            }
        }
        System.out.println("Time to eat pizza");
    }

    public void getPizzaDelivery() throws InterruptedException {
        synchronized (this){
            this.pizzaArrived = true;
            System.out.println("Thanks for the pizza dude, I got the pizza");
            Thread.sleep(1000);
            this.notifyAll();
        }
    }

    @Override
    public void run() {
        try {
            eatPizza();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
