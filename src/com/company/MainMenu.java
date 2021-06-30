package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class MainMenu {
    private JFrame frame;
    private JLabel title;
    private JTextArea description;
    private JPanel sorterPanel;
    private JComboBox<String> sorterComboBox;
    private JTextArea sorterDescription;
    private JPanel directoryPanel;
    private JButton selectDirectoryButton;
    private JTextArea directoryTextArea;
    private JPanel promptPanel;
    private JLabel promptLabel;
    private JTextField promptTextField;
    private JButton beginSortButton;

    private ArrayList<Sorter> sorters;
    private String directoryPath;
    private ArrayList<String> imagePaths;

    public MainMenu(){
        // Initializing the frame menu
        frame = new JFrame();
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6,1,5,5));
        frame.setTitle("MainMenu");

        // Title
        title = new JLabel("Picso", SwingConstants.CENTER); // Center the text within the JLabel
        title.setForeground(Color.green);
        title.setBackground(Color.blue);
        title.setOpaque(true);
        title.setFont(new Font("MV Boli", Font.PLAIN, 20));
        frame.add(title);

        // Description
        description = new JTextArea();
        description.setText("Welcome! This program help to sort pictures into ordered list" +
                " which allow you to rank stuff that need picture as reference " +
                " anything practical from choosing to buy furniture to \"important\" things like finding best waifu ");
        description.setFont(new Font("Consolas", Font.PLAIN, 10));
        description.setBackground(Color.yellow);
        description.setLineWrap(true);
        frame.add(description);

        // SorterPanel
        //-----Start of sorter Panel------//
        sorterPanel = new JPanel();
        sorterPanel.setBackground(Color.RED);
        sorterPanel.setOpaque(true);
        sorterPanel.setLayout(new GridLayout(1,2));

        // SorterComboBox
        String[] testComboBoxArray = {"Sorter1", "Sorter2", "Sorter3"};
        sorterComboBox = new JComboBox(testComboBoxArray);
        sorterPanel.add(sorterComboBox);

        // SorterDescription
        sorterDescription = new JTextArea();
        sorterDescription.setText("Insert sorter description right here");
        sorterDescription.setBackground(Color.RED);
        sorterPanel.add(sorterDescription);

        frame.add(sorterPanel);
        //-----End of sorter Panel-----//


        // DirectoryPanel
        //-----Start of directory Panel-----//
        directoryPanel = new JPanel();
        directoryPanel.setBackground(Color.GREEN);
        directoryPanel.setOpaque(true);
        directoryPanel.setLayout(new GridLayout(1,2));

        // selectDirectoryButton
        selectDirectoryButton = new JButton();
        selectDirectoryButton.setText("Select Directory");

        directoryPanel.add(selectDirectoryButton, BorderLayout.WEST);

        // directoryLabel
        directoryTextArea = new JTextArea();
        directoryTextArea.setText("Insert the directory that user choose");
        directoryTextArea.setLineWrap(true);
        directoryTextArea.setBackground(Color.GREEN);

        directoryPanel.add(directoryTextArea);

        frame.add(directoryPanel);
        //-----End of directory Panel-----//

        // PromptPanel
        //-----Start of PromptPanel-----//
        promptPanel = new JPanel();
        promptPanel.setBackground(Color.PINK);
        promptPanel.setOpaque(true);
        promptPanel.setLayout(new GridLayout(1,2));

        // PromptLabel
        promptLabel = new JLabel();
        promptLabel.setText("Please enter prompt: ");
        promptLabel.setOpaque(true);

        promptPanel.add(promptLabel);

        // PromptTextField
        promptTextField = new JTextField();
        promptTextField.setText("Enter prompt here!");

        promptPanel.add(promptTextField);

        frame.add(promptPanel);
        //-----End of PromptPanel-----//

        // BeginSortButton
        beginSortButton = new JButton();
        beginSortButton.setText("Begin sorting!");
        frame.add(beginSortButton);




        // Making it all visible
        frame.setVisible(true);

    }

}
