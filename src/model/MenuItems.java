package src.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//Creation of MenuItems

public class MenuItems {
    private String itemName;

    private static ObservableList<MenuItems> fileItems = FXCollections.observableArrayList(new MenuItems("_Options"), new MenuItems("_Close"));

    private static ObservableList<MenuItems> helpItems = FXCollections.observableArrayList(new MenuItems("_About"));


    public MenuItems(){

    }

    public MenuItems(String itemName){
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ObservableList<MenuItems> getFileItems(){
        return fileItems;
    }

    public void setFileItems(ObservableList<MenuItems> fileItems){
        this.fileItems = fileItems;
    }

    public ObservableList<MenuItems> getHelpItems(){
        return helpItems;
    }

    public void setHelpItems(ObservableList<MenuItems> helpItems){
        this.helpItems = helpItems;
    }

    @Override
    public String toString() {
        return "MenuItems{" +
                "itemName='" + itemName + '\'' +
                '}';
    }
}