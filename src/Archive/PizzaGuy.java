package Archive;

public class PizzaGuy implements Runnable{
    public PizzaGuy(){

    }
    @Override
    public void run() {
        int minutes = 10;
        MyPizza customer = MyPizza.getInstance();

        for (int i = 0; i < minutes; i++){
            try {
                System.out.println(i + "minutes has passed");
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try{
            System.out.println("Hey pizza is here! PizzaDude came to deliver pizza");
            Thread.sleep(1000);
            customer.getPizzaDelivery();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
