package com.company;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        //SortPage sortPage = new SortPage();
        //SortedPage sortedPage = new SortedPage();
        //MainMenuPage mainMenuPage = new MainMenuPage();

        // Welcoming scene
        System.out.println("Welcome to Picso");
        System.out.println("This is a program about picture sorting");

        // Asking for the prompt
        System.out.println("Please enter a prompt: ");
        Scanner scanner = new Scanner(System.in);
        String prompt = scanner.nextLine();
        System.out.println("Prompt is " + prompt);

        // Asking for directory
        System.out.println("Please select the directory which have the image you want to sort");
        String directoryPath = getDirectory();
        System.out.println("In main directoryPath is " + directoryPath);

        // Initialize up the sort page
        SortPage sortPage = new SortPage();
        sortPage.createWindow();






    }

    // Get the directory from user by opening up a file dialog
    public static String getDirectory(){
        File tempFile = null;
        JFrame tempFrame = new JFrame();
        tempFrame.setVisible(true);
        JFileChooser directoryChooser = new JFileChooser();
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

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


    /*
    public static void bubbleSort(int[] numArray, MyComparator compObj){
        boolean swapped = true;
        while (swapped){
            swapped = false;
            for (int i = 0; i < numArray.length-1; i++){
                int firstBox = numArray[i];
                int secondBox = numArray[i+1];
                if (compObj.greaterThan(firstBox, secondBox)){
                    numArray[i] = secondBox;
                    numArray[i+1] = firstBox;
                    swapped = true;
                }
            }
        }
     */
}
