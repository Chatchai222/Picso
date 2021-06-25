package Archive;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameTest extends JFrame implements ActionListener, Runnable {
    private JButton button;
    private boolean buttonIsPressed;
    private MyLockObject lockObject;

    MyFrameTest(MyLockObject lockObj){
        lockObject = lockObj;
        button = new JButton();
        button.setText("Press me before moving on!");
        button.addActionListener(this);
        this.add(button);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200,200,400,600);


        buttonIsPressed = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("CLicked button");
            buttonIsPressed = true;
        }

    }

    public boolean getIsButtonPressed(){
        return buttonIsPressed;
    }

    @Override
    public void run() {
        this.setVisible(true);
    }
}
