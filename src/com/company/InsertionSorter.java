package com.company;

import java.util.ArrayList;

public class InsertionSorter extends PicsoSorter {
    private String name = "InsertionSorter";
    private String description = "Insertion sort is most \"natural way\" we sort things, if you ever sort a deck of card on your hand this is probably how you did it";

    public InsertionSorter(){}

    @Override
    public void sort(ArrayList<String> imagePaths, PicsoComparator comparator) {

        // Incase the list is empty of only 1
        if (imagePaths.size() <= 1) {
            return;
        }

        // The first comparing part/loop
        for (int i = 1; i < imagePaths.size(); i++) {
            String box1, box2, box3, box4;
            box1 = imagePaths.get(i - 1);
            box2 = imagePaths.get(i);

            if (comparator.compare(box1, box2) == 0) { // Left is "bigger"
                ;// Do nothing
            } else {

                // First swap
                imagePaths.set(i-1, box2);
                imagePaths.set(i, box1);

                // Second loop for going back
                for (int j = i-1; j > 0; j--) {
                    box3 = imagePaths.get(j - 1);
                    box4 = imagePaths.get(j);
                    if (comparator.compare(box3, box4) == 1) { // Right is "bigger"
                        imagePaths.set(j, box3);
                        imagePaths.set(j - 1, box4);

                    } else {
                        break;
                    }
                }
            }
        }
        // End of first comparing loop
    }
    // End of sort function


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
