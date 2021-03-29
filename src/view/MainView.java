package src.view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import src.mainwindow.Main;
import src.model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainView extends BorderPane {
    private MenuItems mi = new MenuItems();
    private ObservableList<MenuItems> fileData = mi.getFileItems();
    private ObservableList<MenuItems> helpData = mi.getHelpItems();
    private MenuBar mb = new MenuBar();
    ParameterView pv = new ParameterView();

    //ArrayList<Consumers> cl = new ArrayList<>();
    public static ArrayList<Consumers> cList = new ArrayList<>();
    public static ArrayList<Suppliers> sList = new ArrayList<>();


    static int rowCons = 0;
    static int colCons = 0;

    static int rowSupp = 0;
    static int colSupp = 0;

    public MainView() throws FileNotFoundException {
        super();

        Menu fileMenu = new Menu("_File");
        for (MenuItems m : fileData) {
            fileMenu.getItems().add(new MenuItem(m.getItemName()));
        }

        Menu helpMenu = new Menu("_Help");
        for (MenuItems m : helpData) {
            helpMenu.getItems().add(new MenuItem(m.getItemName()));
        }

        fileMenu.getItems().add(1, new SeparatorMenuItem());

        mb.getMenus().addAll(fileMenu, helpMenu);

        this.setTop(mb);

        Scene scene = Main.getParaScene();

        VBox supplierVBox = new VBox();
        //supplierVBox.getChildren().add(new Text("Supplier section"));

        try {
            supplierVBox.setPrefSize(scene.getWidth() * 0.4, scene.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //supplierVBox.setStyle("-fx-background-color: red"); To show the area


        VBox consumerVBox = new VBox();
        //consumerVBox.getChildren().add(new Text("Consumer section"));
        Line line1 = new Line(scene.getWidth() * 0.4, 0, scene.getWidth() * 0.4, scene.getHeight());

        try {
            consumerVBox.relocate(scene.getWidth() * 0.4, 0);
            consumerVBox.setPrefSize(scene.getWidth() * 0.4, scene.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //consumerVBox.setStyle("-fx-background-color: orange"); To show the area

        VBox parameterVBox = new VBox(/*8*/);
        /*Text paramTitle = new Text("Parameter section");
        paramTitle.setFont(Font.font(26));
        parameterVBox.getChildren().add(paramTitle);*/

        Line line2 = new Line(scene.getWidth() * 0.8, 0, scene.getWidth() * 0.8, scene.getHeight());

        try {
            parameterVBox.relocate(scene.getWidth() * 0.8, 0);
            parameterVBox.setPrefSize(scene.getWidth() * 0.2, scene.getHeight());
        } catch (Exception e) {
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

        //consumerVBox.getChildren().add(cv);

        GridPane gpConsumer = new GridPane();
        /*gpConsumer.setMinWidth(128);
        gpConsumer.setMaxWidth(128);
        gpConsumer.setMinHeight(100);
        gpConsumer.setMaxHeight(100);*/
        gpConsumer.minWidth(128);
        gpConsumer.maxWidth(128);

        consumerVBox.getChildren().add(gpConsumer);

        GridPane gpSupplier = new GridPane();
        supplierVBox.getChildren().add(gpSupplier);

        //ArrayList<Consumers> cl = new ArrayList<>();
        //cl.add(new Houses(50, 50, 50));

        //System.out.println(cl);

        /*System.out.println(cList);
        for (Consumers c :  cList) {
            if (c.getName().equals("house")) {
            Image house = new Image(new FileInputStream("images/house.png"));
            ImageView ivh = new ImageView(house);
            ivh.setFitHeight(100);
            ivh.setFitWidth(128);
            gp.add(ivh, 0, 0);
            }
        }*/

        Image house = new Image("images/house.png", 128, 100, false, false);
        Image building = new Image("images/building.png", 128, 100, false, false);
        Image waterdam = new Image("images/waterdam.png", 128, 100, false, false);
        Image windturbine = new Image("images/windturbine.png", 128, 100, false, false);
        Image solarpanel = new Image("images/solarpanel.png", 128, 100, false, false);
        Image npp = new Image("images/npp.png", 128, 100, false, false);

        ArrayList<Consumers> consumerArray = new ArrayList<>();
        ArrayList<Suppliers> supplierArray = new ArrayList<>();

        pv.generateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(pv.rbList[0].isSelected() && pv.consumersList.size() < 40){
                    int numOfCons = Integer.parseInt(pv.t1.getText());
                    int hrsOfConsumption = Integer.parseInt(pv.t2.getText());
                    Houses h1 = new Houses(50, hrsOfConsumption, numOfCons);
                    pv.consumersList.add(h1);

                    consumerArray.add(h1);

                    pv.t1.clear();
                    pv.t2.clear();
                    pv.rbList[0].setSelected(false);

                }else if(pv.rbList[1].isSelected() && pv.consumersList.size() < 40){
                    int numOfCons = Integer.parseInt(pv.t1.getText());
                    int hrsOfConsumption = Integer.parseInt(pv.t2.getText());
                    Buildings b1 = new Buildings(200, hrsOfConsumption, numOfCons);
                    pv.consumersList.add(b1);

                    consumerArray.add(b1);

                    pv.t1.clear();
                    pv.t2.clear();
                    pv.rbList[1].setSelected(false);
                }else if(pv.rbList[2].isSelected() && pv.suppliersList.size() < 40){
                    int numOfSup = Integer.parseInt(pv.t3.getText());
                    HydroDam hd1 = new HydroDam(1000, numOfSup);
                    pv.suppliersList.add(hd1);

                    supplierArray.add(hd1);

                    pv.t3.clear();
                    pv.rbList[2].setSelected(false);
                }else if(pv.rbList[3].isSelected()  && pv.suppliersList.size() < 40){
                    int numOfSup = Integer.parseInt(pv.t3.getText());
                    WindFarm wf1 = new WindFarm(1500, numOfSup);
                    pv.suppliersList.add(wf1);

                    supplierArray.add(wf1);

                    pv.t3.clear();
                    pv.rbList[3].setSelected(false);
                }
                else if(pv.rbList[4].isSelected()  && pv.suppliersList.size() < 40){
                    int numOfSup = Integer.parseInt(pv.t3.getText());
                    SolarFarm sf1 = new SolarFarm(750, numOfSup);
                    pv.suppliersList.add(sf1);

                    supplierArray.add(sf1);

                    pv.t3.clear();
                    pv.rbList[4].setSelected(false);
                }else if(pv.rbList[5].isSelected()  && pv.suppliersList.size() < 40) {
                    int numOfSup = Integer.parseInt(pv.t3.getText());
                    NuclearPowerPlant npp1 = new NuclearPowerPlant(500, numOfSup);
                    pv.suppliersList.add(npp1);

                    supplierArray.add(npp1);

                    pv.t3.clear();
                    pv.rbList[5].setSelected(false);
                }else if(pv.consumersList.size() == 40 || pv.suppliersList.size() == 40){
                    System.out.println("This is the maximum amount of objects (40)");
                    pv.rbList[0].setSelected(false);
                    pv.rbList[1].setSelected(false);
                    pv.rbList[2].setSelected(false);
                    pv.rbList[3].setSelected(false);
                    pv.rbList[4].setSelected(false);
                    pv.rbList[5].setSelected(false);
                    pv.t1.clear();
                    pv.t2.clear();
                    pv.t3.clear();
                }
                ArrayList<Consumers> consList = (ArrayList<Consumers>) pv.consumersList.clone();
                System.out.println("ConsList: " + consList);
                System.out.println();
                System.out.println("cList: " + cList);
                System.out.println();
                System.out.println("Consumer Array: " + consumerArray);
                System.out.println();
                System.out.println();
                System.out.println("Supplier Array: " + supplierArray);
                System.out.println();
                System.out.println();
                System.out.println(pv.consumersList);
                System.out.println(pv.suppliersList);
                pv.updateList();

                for(int i = 0; i < cList.size(); i++){
                    if(pv.consumersList.get(i).getName().equals("house")){
                        if(rowCons == 0 && colCons == 0){
                            gpConsumer.add(new ImageView(house), colCons, rowCons);
                            colCons++;
                            pv.consumersList.remove(i);
                        }else if(colCons == 5){
                            colCons = 0;
                            rowCons++;
                            gpConsumer.add(new ImageView(house), colCons, rowCons);
                            colCons++;
                            pv.consumersList.remove(i);
                        }else{
                            gpConsumer.add(new ImageView(house), colCons, rowCons);
                            colCons++;
                            pv.consumersList.remove(i);
                        }
                    }
                    else if(pv.consumersList.get(i).getName().equals("building")){
                        if(rowCons == 0 && colCons == 0){
                            gpConsumer.add(new ImageView(building), colCons, rowCons);
                            colCons++;
                            pv.consumersList.remove(i);
                        }else if(colCons == 5){
                            colCons = 0;
                            rowCons++;
                            gpConsumer.add(new ImageView(building), colCons, rowCons);
                            colCons++;
                            pv.consumersList.remove(i);
                        }else{
                            gpConsumer.add(new ImageView(building), colCons, rowCons);
                            colCons++;
                            pv.consumersList.remove(i);
                        }
                    }
                }
                for(int i = 0; i < sList.size(); i++){
                    if(pv.suppliersList.get(i).getName().equals("waterdam")){
                        if(rowSupp == 0 && colSupp == 0){
                            gpSupplier.add(new ImageView(waterdam), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else if(colSupp == 5){
                            colSupp = 0;
                            rowSupp++;
                            gpSupplier.add(new ImageView(waterdam), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else{
                            gpSupplier.add(new ImageView(waterdam), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }
                    }else if(pv.suppliersList.get(i).getName().equals("windturbine")){
                        if(rowSupp == 0 && colSupp == 0){
                            gpSupplier.add(new ImageView(windturbine), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else if(colSupp == 5){
                            colSupp = 0;
                            rowSupp++;
                            gpSupplier.add(new ImageView(windturbine), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else{
                            gpSupplier.add(new ImageView(windturbine), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }
                    }else if(pv.suppliersList.get(i).getName().equals("solarpanel")){
                        if(rowSupp == 0 && colSupp == 0){
                            gpSupplier.add(new ImageView(solarpanel), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else if(colSupp == 5){
                            colSupp = 0;
                            rowSupp++;
                            gpSupplier.add(new ImageView(solarpanel), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else{
                            gpSupplier.add(new ImageView(solarpanel), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }
                    }else if(pv.suppliersList.get(i).getName().equals("npp")){
                        if(rowSupp == 0 && colSupp == 0){
                            gpSupplier.add(new ImageView(npp), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else if(colSupp == 5){
                            colSupp = 0;
                            rowSupp++;
                            gpSupplier.add(new ImageView(npp), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else{
                            gpSupplier.add(new ImageView(npp), colSupp, rowSupp);
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }
                    }
                }
            }
        });
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