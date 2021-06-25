package Archive;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIComponent implements ActionListener, Runnable{
    private Boolean buttonPressed;
    private JFrame frame;
    private JButton button;
    private Looper looper;

    public GUIComponent(Looper looper10){
        looper = looper10;
        frame = new JFrame();
        button = new JButton();
        buttonPressed = false;

        button.setText("Click me before moving on!");
        button.addActionListener(this);

        frame.setBounds(200,200,200,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(button);
    }

    public Boolean getButtonPressed() {
        return buttonPressed;
    }

    public void setButtonPressed(boolean inbuttonPressed) {
        this.buttonPressed = inbuttonPressed;
    }

    public void notifyBoolean(){
        buttonPressed.notifyAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("I just clicked a button and setting button pressed to true");
            synchronized(looper){
                buttonPressed = true;
                System.out.println("Button has been set to true");
                looper.notifyAll();
            }
        }
    }

    @Override
    public void run() {
        frame.setVisible(true);
    }
}
