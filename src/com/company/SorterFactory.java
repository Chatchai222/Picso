package com.company;

public class SorterFactory {
    public static PicsoSorter getSorter(String sorterType){
        if (sorterType == null){
            return null;
        }

        if(sorterType.equalsIgnoreCase("BUBBLESORTER")){
            return new BubbleSorter();
        } else if (sorterType.equalsIgnoreCase(("INSERTIONSORTER"))) {
            return new InsertionSorter();
        }

        return null;
    }

}
