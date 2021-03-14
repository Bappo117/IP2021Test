package src.view;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import src.mainwindow.Main;
import src.model.MenuItems;

public class MainView extends BorderPane {
    private MenuItems mi = new MenuItems();
    private ObservableList<MenuItems> fileData = mi.getFileItems();
    private ObservableList<MenuItems> helpData = mi.getHelpItems();
    private MenuBar mb = new MenuBar();
    ParameterView pv = new ParameterView();

    public MainView(){
        super();

        Menu fileMenu = new Menu("_File");
        for(MenuItems m : fileData) {
            fileMenu.getItems().add(new MenuItem(m.getItemName()));
        }

        Menu helpMenu = new Menu("_Help");
        for(MenuItems m : helpData){
            helpMenu.getItems().add(new MenuItem(m.getItemName()));
        }

        fileMenu.getItems().add(1, new SeparatorMenuItem());

        mb.getMenus().addAll(fileMenu, helpMenu);

        this.setTop(mb);

        Scene scene = Main.getParaScene();

        VBox supplierVBox = new VBox();
        supplierVBox.getChildren().add(new Text("Supplier section"));
        try {
            supplierVBox.setPrefSize(scene.getWidth()*0.4, scene.getHeight());
        }catch(Exception e){
            e.printStackTrace();
        }
        //supplierVBox.setStyle("-fx-background-color: red"); To show the area


        VBox consumerVBox = new VBox();
        consumerVBox.getChildren().add(new Text("Consumer section"));

        Line line1 = new Line(scene.getWidth()*0.4, 0, scene.getWidth()*0.4, scene.getHeight());

        try {
            consumerVBox.relocate(scene.getWidth()*0.4, 0);
            consumerVBox.setPrefSize(scene.getWidth()*0.4, scene.getHeight());
        }catch(Exception e){
            e.printStackTrace();
        }
        //consumerVBox.setStyle("-fx-background-color: orange"); To show the area

        VBox parameterVBox = new VBox(/*8*/);
        /*Text paramTitle = new Text("Parameter section");
        paramTitle.setFont(Font.font(26));
        parameterVBox.getChildren().add(paramTitle);*/

        Line line2 = new Line(scene.getWidth()*0.8, 0, scene.getWidth()*0.8, scene.getHeight());

        try {
            parameterVBox.relocate(scene.getWidth()*0.8, 0);
            parameterVBox.setPrefSize(scene.getWidth()*0.2, scene.getHeight());
        }catch(Exception e){
            e.printStackTrace();
        }
        //parameterVBox.setStyle("-fx-background-color: yellow"); To show the area

        Pane mainPane = new Pane();
        mainPane.getChildren().addAll(parameterVBox, supplierVBox, consumerVBox, line1, line2);

        this.setCenter(mainPane);

        //THIS IS A TEST FOR THE TEXT FIELDS TO SEE IF THEY WORK AND HOW THEY WOULD LOOK LIKE
/*
        TextField testTextField = new TextField();
        //testTextField.setPromptText("Enter a number"); If needed to put text inside of TextField
        testTextField.setFocusTraversable(false); //Used to not prompt as the program starts
        testTextField.setDisable(false); //Used to disable a text field
        testTextField.setMaxWidth(100);
        Button b = new Button("Add");
*/
        //CHANGE THE POSITION OF THE PARAMETER SECTION IN THE @ParameterView CLASS TO CUSTOMIZE THE WHOLE SECTION
        parameterVBox.getChildren().add(pv);

    }

    public void setOptionsHandler(EventHandler handler){
        mb.getMenus().get(0).getItems().get(0).setOnAction(handler);
    }

    public void setCloseHandler(EventHandler handler){
        mb.getMenus().get(0).getItems().get(2).setOnAction(handler);
    }

    public void setAboutHandler(EventHandler handler){
        mb.getMenus().get(1).getItems().get(0).setOnAction(handler);
    }
}