package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MainMenuPage implements ActionListener, PicsoPage {

    // Regarding the main frame title and description
    private JFrame frame;
    private JLabel title;
    private JTextArea description;

    // Variable for the sorter part
    private JPanel sorterPanel;
    private JComboBox<String> sorterComboBox;
    private JTextArea sorterDescription;

    // Variable for the directory part
    private JPanel directoryPanel;
    private JFileChooser directoryChooser;
    private JButton selectDirectoryButton;
    private JTextArea directoryTextArea;

    // Variable for the prompt part
    private JPanel promptPanel;
    private JLabel promptLabel;
    private JTextField promptTextField;

    private JButton beginSortButton;

    // The under the hood stuff
    private ArrayList<String> sorterNames;
    private String directoryPath;
    private ArrayList<String> imagePaths;
    private PageController pageController;

    public MainMenuPage(){
    }

    // Get the directory from user by opening up a file dialog
    private String getDirectory(){
        File tempFile = null;
        JFrame tempFrame = new JFrame();

        int option = directoryChooser.showOpenDialog(tempFrame);
        if(option == JFileChooser.APPROVE_OPTION){
            tempFile = directoryChooser.getSelectedFile();
            System.out.println("Selected directory: " + tempFile.getAbsolutePath());
        } else {
            System.out.println("User did NOT choose a file or some error occurred");
        }

        if(tempFile == null){
            return "";
        } else {
            return tempFile.getAbsolutePath();
        }

    }

    // Facade for getting the directory displaying the directory on the screen
    private void processDirectory(){
        String dirPath = getDirectory();
        directoryTextArea.setText(dirPath);
    }

    private String getPrompt(){
        return promptTextField.getText();
    }

    // Set the sorter description box
    private void setSorterDescription(String description){
        sorterDescription.setText(description);
        sorterDescription.repaint();
    }

    // Facade for selecting a sorter
    private void processSorter(){

        String sorterName = (String)sorterComboBox.getSelectedItem();
        PicsoSorter tempSorter = SorterFactory.getSorter(sorterName);
        if (tempSorter == null){
            System.out.println("tempSorter in processSorter is null");
        } else {
            this.setSorterDescription(tempSorter.getDescription());
        }

    }

    private void processBeginSort(){
        System.out.println("Process of begin sort");

        String sorterType = (String) sorterComboBox.getSelectedItem();
        PicsoSorter tempSorter = SorterFactory.getSorter(sorterType);

        String tempDirectory = directoryTextArea.getText();

        String tempPrompt = this.getPrompt();

        pageController.setPrompt(tempPrompt);
        pageController.setImagesDirectory(new File(tempDirectory));
        pageController.setSorter(tempSorter);

        pageController.setCurrentPage("SORTPAGE");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == selectDirectoryButton){
            System.out.println("User pressed select directory button");
            this.processDirectory();
        }
        if(e.getSource() == sorterComboBox){
            System.out.println("User has selected something from Sorter ComboBox");
            this.processSorter();
        }
        if(e.getSource() == beginSortButton){
            System.out.println("User pressed beginSort button");
            this.processBeginSort();
        }
    }

    @Override
    public void createWindow() {
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
        description.setEditable(false);

        frame.add(description);

        // SorterPanel
        //-----Start of sorter Panel------//
        sorterPanel = new JPanel();
        sorterPanel.setBackground(Color.RED);
        sorterPanel.setOpaque(true);
        sorterPanel.setLayout(new GridLayout(1,2));

        // SorterComboBox
        String[] testComboBoxArray = {"BubbleSorter", "InsertionSorter"};
        sorterComboBox = new JComboBox(testComboBoxArray);

        sorterComboBox.addActionListener(this);

        sorterPanel.add(sorterComboBox);

        // SorterDescription
        sorterDescription = new JTextArea();
        sorterDescription.setText("Insert sorter description right here");
        sorterDescription.setBackground(Color.RED);
        sorterDescription.setLineWrap(true);
        sorterPanel.add(sorterDescription);

        frame.add(sorterPanel);
        //-----End of sorter Panel-----//


        // DirectoryPanel
        //-----Start of directory Panel-----//
        directoryPanel = new JPanel();
        directoryPanel.setBackground(Color.GREEN);
        directoryPanel.setOpaque(true);
        directoryPanel.setLayout(new GridLayout(1,2));

        // directoryChooser
        directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // selectDirectoryButton
        selectDirectoryButton = new JButton();
        selectDirectoryButton.setText("Select Directory");

        selectDirectoryButton.addActionListener(this);

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

        beginSortButton.addActionListener(this);

        frame.add(beginSortButton);

        // Making it all visible
        frame.setVisible(true);
    }

    @Override
    public void destroyWindow() {
        frame.setVisible(false);
        frame.dispose();
    }

    public PageController getPageController() {
        return pageController;
    }

    public void setPageController(PageController pageController) {
        this.pageController = pageController;
    }
}
