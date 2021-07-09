package com.company;

import java.util.ArrayList;
import java.util.Comparator;


public class Sorter {
    public static void bubbleSort(ArrayList<String> stringArray, SortPage comparator){
        if (stringArray.size() <= 1){
            ; // Do nothing
        } else {
            boolean swapped = true;

            while (swapped){

                swapped = false;

                for(int i = 1; i < stringArray.size(); i++){

                    String str1 = stringArray.get(i-1);
                    String str2 = stringArray.get(i);

                    if (comparator.compare(str1,str2) == 1){
                        stringArray.set(i-1, str2);
                        stringArray.set(i, str1);
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
