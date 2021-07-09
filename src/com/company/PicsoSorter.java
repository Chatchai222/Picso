package com.company;
import java.util.ArrayList;

public abstract class PicsoSorter {
    private String name;
    private String description;

    public abstract void sort(ArrayList<String> imagePaths, PicsoComparator comparator);

    public abstract String getDescription();

    public abstract String getName();
}
