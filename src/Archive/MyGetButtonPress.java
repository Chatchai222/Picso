package Archive;

public class MyGetButtonPress implements Runnable{
    private MyFrameTest frame;

    public MyGetButtonPress(MyFrameTest aFrame){
        frame = aFrame;
    }

    public MyFrameTest getFrame() {
        return frame;
    }

    public void setFrame(MyFrameTest frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        synchronized (frame){
            while (!frame.getIsButtonPressed()){
                try {
                    System.out.println("I should wait for the button to be pressed");
                    frame.wait();
                    System.out.println("This message should be shown when I pressed the button");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
