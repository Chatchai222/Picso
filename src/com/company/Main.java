package com.company;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        //SortPage sortPage = new SortPage();
        //SortedPage sortedPage = new SortedPage();
        //MainMenuPage mainMenuPage = new MainMenuPage();

        PageController pageController = new PageController();
        pageController.setCurrentPage("MAINMENUPAGE");


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
