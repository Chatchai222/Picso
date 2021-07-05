package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SortedPage {
    private ArrayList<String> imagePaths;

    // Frame
    private JFrame frame;

    private int FRAME_WIDTH = 1000;
    private int FRAME_HEIGHT = 700;

    // Image displaying part
    private JPanel displayPanel;
    private JScrollPane displayScroll;
    private ArrayList<JLabel> displayLabels;
    private ArrayList<ImageIcon> images;

    private final int DISPLAY_ROWS = 2; // Amount of rows the client can "see" without using scroll bar
                                        //

    private final int DISPLAY_COLUMNS = 2; // Amount of expected column to be shown
    private final int DISPLAY_VGAP = 10; // Amount of vertical gap between images
    private final int DISPLAY_HGAP = 10; // Amount of horizontal gap between images

    // Buttons part
    private JPanel buttonPanel;
    private JButton exportCSVButton;
    private JButton resortButton;




    SortedPage(){
        // Frame
        frame = new JFrame();
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //-----Start displaying part-----//

        //####START TEST STUFF WILL REMOVE LATER ON####//
        imagePaths = new ArrayList<String>();
        imagePaths.add("0.png");
        imagePaths.add("1.png");
        imagePaths.add("2.png");
        imagePaths.add("3.png");
        imagePaths.add("4.png");
        imagePaths.add("5.png");
        imagePaths.add("6.png");
        imagePaths.add("7.png");
        imagePaths.add("8.png");
        imagePaths.add("9.png");
        imagePaths.add("bigImg.png");

        //####TEST STUFF END####//

        //-----Start of Display part-----//
        // DisplayPanel
        displayPanel = new JPanel();
        displayPanel.setBackground(Color.BLUE);
        displayPanel.setOpaque(true);
        displayPanel.setSize(frame.getWidth(), frame.getHeight());
        //displayPanel.setLayout(new FlowLayout());
        displayPanel.setLayout(new GridLayout(0,DISPLAY_COLUMNS, DISPLAY_HGAP, DISPLAY_VGAP)); // The zero for rows meant "as many rows as you need"
        //displayPanel.setLayout(new GridLayout((int)(imagePaths.size() / 5), 1));


        // Adding images into the displayPanel
        for (String imagePath : imagePaths) {
            // Creating image icon and resizing them
            ImageIcon currentImage = new ImageIcon(imagePath);
            resizeImage(currentImage);

            // Create new label to hold the image
            JLabel currentLabel = new JLabel();
            currentLabel.setBackground(Color.GREEN);
            currentLabel.setOpaque(true);

            currentLabel.setIcon(currentImage);

            displayPanel.add(currentLabel);
        }

        // DisplayScroll (this makes the panel scrollable)
        displayScroll = new JScrollPane(displayPanel);

        frame.add(displayScroll, BorderLayout.CENTER);
        //frame.add(displayPanel, BorderLayout.CENTER);
        //-----End of display part-----//

        //-----Start of button part-----//
        // ButtonPanel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.YELLOW);
        buttonPanel.setPreferredSize(new Dimension(100,100));
        buttonPanel.setLayout(new GridLayout());
        buttonPanel.setOpaque(true);

        // Export CSV Button
        exportCSVButton = new JButton();
        exportCSVButton.setText("Export CSV button");

        buttonPanel.add(exportCSVButton);

        // Resort button
        resortButton = new JButton();
        resortButton.setText("Resort");

        buttonPanel.add(resortButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        //-----End of button part -----//

        frame.setVisible(true);
    }

    private void resizeImage(ImageIcon inImg){
        // Calculate size of image resizing
        int newImgWidth = (int)((displayPanel.getWidth() - ((DISPLAY_COLUMNS) * DISPLAY_HGAP)) / DISPLAY_COLUMNS);
        int newImgHeight = (int)((displayPanel.getHeight() - ((DISPLAY_ROWS) * DISPLAY_VGAP)) / DISPLAY_ROWS);

        // DEBUGGING

        // DEBUGGING

        Image tempImg = inImg.getImage();
        tempImg = tempImg.getScaledInstance(newImgWidth, newImgHeight, Image.SCALE_DEFAULT);
        inImg.setImage(tempImg);
    }
}
