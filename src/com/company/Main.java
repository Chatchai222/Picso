package com.company;
import java.io.File;
import java.io.IOException;
import Archive.Bar;
import Archive.Foo;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        SortPage sortPage = new SortPage();
        try{
            File myFile = new File("WhereFile.txt");
            if (myFile.createNewFile()){
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e){
            System.out.println("Error happened");
            e.printStackTrace();
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
