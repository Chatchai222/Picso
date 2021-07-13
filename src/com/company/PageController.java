package com.company;

import java.io.File;
import java.util.ArrayList;

public class PageController {
    // The various pages
    private MainMenuPage mainMenuPage;
    private SortPage sortPage;
    private SortedPage sortedPage;

    private PicsoPage currentPage;

    // Data for page construction
    private PicsoSorter sorter;
    private String prompt;
    private File imagesDirectory;
    private ArrayList<String> sortedImages;

    public PageController(){
    }

    public void setCurrentPage(String pageName){

        // Checking if there is current page
        if (currentPage != null){
            currentPage.destroyWindow();
            currentPage = null;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (pageName.equalsIgnoreCase("MAINMENUPAGE")){
            currentPage = new MainMenuPage();
            currentPage.setPageController(this);
            currentPage.createWindow();
        } else if (pageName.equalsIgnoreCase("SORTPAGE")){
            currentPage = new SortPage();
            currentPage.setPageController(this);
            currentPage.createWindow();
        } else if (pageName.equalsIgnoreCase("SORTEDPAGE")){
            currentPage = new SortedPage();
            currentPage.setPageController(this);
            currentPage.createWindow();
        } else {
            System.out.println("Page not found");
        }
    }

    // Setter methods

    public void setImagesDirectory(File imagesDirectory) {
        this.imagesDirectory = imagesDirectory;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setSortedImages(ArrayList<String> sortedImages) {
        this.sortedImages = sortedImages;
    }

    public void setSorter(PicsoSorter sorter) {
        this.sorter = sorter;
    }

    // Getters method

    public File getImagesDirectory() {
        return imagesDirectory;
    }

    public PicsoSorter getSorter() {
        return sorter;
    }

    public String getPrompt() {
        return prompt;
    }

    public ArrayList<String> getSortedImages() {
        return sortedImages;
    }

}
