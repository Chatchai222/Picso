package com.company;

import java.util.ArrayList;

public class BubbleSorter extends PicsoSorter {
    final private String name = "Bubble Sorter";
    final private String description = "Bubble sort is a sorting algorithm with very high redundancy";

    public BubbleSorter(){}
    public void sort(ArrayList<String> stringArray, PicsoComparator comparator){
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
