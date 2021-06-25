package com.company;

import java.util.ArrayList;

public class Sorter {
    public static void bubbleSort(ArrayList<Integer> numberArray){
        if (numberArray.size() <= 1){
            ; // Do nothing
        } else {
            boolean swapped = true;

            while (swapped){

                swapped = false;

                for(int i = 1; i < numberArray.size(); i++){

                    int num1 = numberArray.get(i-1);
                    int num2 = numberArray.get(i);

                    if (num1 >= num2){
                        numberArray.set(i-1, num2);
                        numberArray.set(i, num1);
                        swapped = true;
                    }
                }
            }
        }
    }

    public static void insertionSort(int[] numArray){
        if (numArray.length < 2){
            return;
        }
        else {
            for (int i = 1; i < numArray.length; i++) {
                int box1, box2;
                int box3, box4;
                box1 = numArray[i - 1];
                box2 = numArray[i];
                if (box1 < box2) {
                    ; // Do nothing
                } else {
                    for (int j = i; j > 0; j--){
                        box3 = numArray[j-1];
                        box4 = numArray[j];
                        if (box3 > box4){
                            numArray[j] = box3;
                            numArray[j-1] = box4;
                        } else {
                            break;
                        }
                    }
                }

            }
        }
    }
}
