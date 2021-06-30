package com.company;

import javax.swing.*;
import java.awt.*;

public class SortPage {
    private JFrame frame;

    // Prompt part
    private JPanel promptPanel;
    private JLabel prompt;
    private GridBagConstraints promptConstraints;

    // Image part
    private JPanel imagePanel;
    private GridBagConstraints imagePanelConstraints;
    private ImageIcon leftImage;
    private JLabel leftLabel;
    private ImageIcon rightImage;
    private JLabel rightLabel;


    private double LEFT_LABEL_HEIGHT_RATIO = 1; // These 4 constant are relative to the imagePanel
    private double RIGHT_LABEL_HEIGHT_RATIO = 1;
    private double LEFT_LABEL_WIDTH_RATIO = 0.5;
    private double RIGHT_LABEL_WIDTH_RATIO = 0.5;

    // Button part
    private JPanel buttonPanel;
    private GridBagConstraints buttonPanelConstraints;
    private JButton leftButton;
    private JButton rightButton;

    SortPage(){
        // Initializing the frame
        frame = new JFrame();
        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());


        //-----Start of prompt part-----//
        // Initializing the promptPanel
        promptPanel = new JPanel();
        promptPanel.setBackground(Color.RED);


        // Initialize prompt
        prompt = new JLabel("This is the default prompt in sortPage", JLabel.CENTER);
        prompt.setOpaque(true);
        prompt.setBackground(Color.PINK);

        promptPanel.add(prompt);

        // Initialize prompt part constraints
        promptConstraints = new GridBagConstraints();
        promptConstraints.fill = GridBagConstraints.BOTH;
        promptConstraints.weightx = 0.1;
        promptConstraints.weighty = 0.1;
        promptConstraints.gridx = 0;
        promptConstraints.gridy = 0;


        frame.add(promptPanel, promptConstraints);
        //-----End of prompt part-----//

        //-----Start Image Part of the component-----//
        // ImagePanel
        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1,2));

        // ImagePanel constraint
        imagePanelConstraints = new GridBagConstraints();
        imagePanelConstraints.fill = GridBagConstraints.BOTH;
        imagePanelConstraints.weightx = 0.1;
        imagePanelConstraints.weighty = 0.8;
        imagePanelConstraints.gridx = 0;
        imagePanelConstraints.gridy = 1;

        // Left image icon + Left Image label (Kinda need to be together)
        leftImage = new ImageIcon("0.png");
        leftLabel = new JLabel();
        leftLabel.setSize((int) (imagePanel.getWidth() * LEFT_LABEL_WIDTH_RATIO), (int)(imagePanel.getHeight() * LEFT_LABEL_HEIGHT_RATIO));
        leftLabel.setText("Left image is suppose to go here!");
        leftLabel.setBackground(Color.GREEN);
        leftLabel.setOpaque(true);
        leftLabel.setIcon(leftImage);


        imagePanel.add(leftLabel);

        // Right image icon
        rightImage = new ImageIcon("1.png");

        // Right image label

        rightLabel = new JLabel();
        rightLabel.setText("Right image is suppose to go here!");
        rightLabel.setBackground(Color.BLUE);
        rightLabel.setOpaque(true);
        rightLabel.setIcon(rightImage);

        imagePanel.add(rightLabel);


        frame.add(imagePanel, imagePanelConstraints);
        //-----End of Image part-----//

        //-----Start of Button part-----//
        // Initialize buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.setBackground(Color.YELLOW);

        // Initialize buttonPanel constraints
        buttonPanelConstraints = new GridBagConstraints();
        buttonPanelConstraints.fill = GridBagConstraints.BOTH;
        buttonPanelConstraints.weightx = 0.1;
        buttonPanelConstraints.weighty = 0.1;
        buttonPanelConstraints.gridx = 0;
        buttonPanelConstraints.gridy = 2;

        // Left button
        leftButton = new JButton();
        leftButton.setText("Left button");

        buttonPanel.add(leftButton);

        // Right button
        rightButton = new JButton();
        rightButton.setText("Right Button");

        buttonPanel.add(rightButton);

        frame.add(buttonPanel, buttonPanelConstraints);
        //-----End of Button part-----//

        // Making it all visible
        frame.setVisible(true);

    }
}
