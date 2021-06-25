package Archive;

public class Looper{
    private Boolean buttonPressed;

    public Looper(Boolean inBoolean) {
        buttonPressed = inBoolean;
    }

    public void run() {
        for(int i = 0; i < 100; i++)
        {
            synchronized(buttonPressed){
                while(!buttonPressed)
                {
                    System.out.println("Checked if button is pressed");
                    try {
                        buttonPressed.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buttonPressed = false;
                System.out.println("Button is pressed printing the next number " + i);
                buttonPressed.notifyAll();
            }

        }


    }
}
