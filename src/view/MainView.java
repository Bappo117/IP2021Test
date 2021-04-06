package src.view;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import src.mainwindow.Main;
import src.model.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainView extends BorderPane {
    private MenuItems mi = new MenuItems();
    private ObservableList<MenuItems> fileData = mi.getFileItems();
    private ObservableList<MenuItems> helpData = mi.getHelpItems();
    private MenuBar mb = new MenuBar();
    ParameterView pv = new ParameterView();

    public static ArrayList<Consumers> cList = new ArrayList<>();
    public static ArrayList<Suppliers> sList = new ArrayList<>();


    static int rowCons = 0;
    static int colCons = 0;

    static int rowSupp = 0;
    static int colSupp = 0;

    static double totCons = 0;
    static double totSupp = 0;

    static int houseNum = 0;
    static int buildingNum = 0;
    static int hydroNum = 0;
    static int windNum = 0;
    static int solarNum = 0;
    static int nppNum = 0;

    public MainView() throws FileNotFoundException {
        super();

        //Creation of menus

        Menu fileMenu = new Menu("_File");
        for (MenuItems m : fileData) {
            fileMenu.getItems().add(new MenuItem(m.getItemName()));
        }

        Menu helpMenu = new Menu("_Help");
        for (MenuItems m : helpData) {
            helpMenu.getItems().add(new MenuItem(m.getItemName()));
        }

        mb.getMenus().addAll(fileMenu, helpMenu);

        this.setTop(mb);

        Scene scene = Main.getParaScene();

        //Creation of different sections

        VBox supplierVBox = new VBox();
        try {
            supplierVBox.setPrefSize(scene.getWidth() * 0.4, scene.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }

        VBox consumerVBox = new VBox();
        Line line1 = new Line(scene.getWidth() * 0.4, 0, scene.getWidth() * 0.4, scene.getHeight());
        try {
            consumerVBox.relocate(scene.getWidth() * 0.4, 0);
            consumerVBox.setPrefSize(scene.getWidth() * 0.4, scene.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }

        VBox parameterVBox = new VBox();
        Line line2 = new Line(scene.getWidth() * 0.8, 0, scene.getWidth() * 0.8, scene.getHeight());
        try {
            parameterVBox.relocate(scene.getWidth() * 0.8, 0);
            parameterVBox.setPrefSize(scene.getWidth() * 0.2, scene.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Adding sections to application

        Pane mainPane = new Pane();
        mainPane.getChildren().addAll(parameterVBox, supplierVBox, consumerVBox, line1, line2);
        this.setCenter(mainPane);

        //CHANGE THE POSITION OF THE PARAMETER SECTION IN THE @ParameterView CLASS TO CUSTOMIZE THE WHOLE SECTION
        parameterVBox.getChildren().add(pv);

        //GridPanes to add images of objects

        GridPane gpConsumer = new GridPane();
        consumerVBox.getChildren().add(gpConsumer);

        GridPane gpSupplier = new GridPane();
        supplierVBox.getChildren().add(gpSupplier);

        //Creation of the images to be added when creating a new object

        Image house = new Image("images/house.png", 128, 100, false, false);
        Image building = new Image("images/building.png", 128, 100, false, false);
        Image waterdam = new Image("images/waterdam.png", 128, 100, false, false);
        Image windturbine = new Image("images/windturbine.png", 128, 100, false, false);
        Image solarpanel = new Image("images/solarpanel.png", 128, 100, false, false);
        Image npp = new Image("images/npp.png", 128, 100, false, false);

        //ArrayList to keep track of objects created

        ArrayList<Consumers> consumerArray = new ArrayList<>();
        ArrayList<Suppliers> supplierArray = new ArrayList<>();


        //Whole functionality of the generate button (Creating objects from the selected object and adding images to the boxes)

        pv.generateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //Maximum amount of objects is 40
                if(consumerArray.size() == 40 & supplierArray.size() == 40){
                    System.out.println("SORRY");
                    System.out.println("This is the maximum amount of objects (40)");
                    pv.alertMessage.setText("The maximum amount of objects has been reached (40)");
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

                //Creation of new objects
                //Update Labels
                    if (pv.rbList[0].isSelected() && pv.consumersList.size() < 40) {
                        //int numOfCons = Integer.parseInt(pv.t1.getText());
                        //int hrsOfConsumption = Integer.parseInt(pv.t2.getText());

                        String numOfCons = pv.t1.getText();
                        String hrsOfConsumption = pv.t2.getText();
                        boolean numeric1 = true;
                        boolean numeric2 = true;
                        numeric1 = numOfCons.matches("\\d{0,10}");
                        numeric2 = hrsOfConsumption.matches("\\d{0,10}");

                        if(!numeric1){
                            pv.alertMessage.setText("Please enter a number");
                            pv.t1.clear();
                            pv.rbList[0].setSelected(false);
                        }
                        if(!numeric2){
                            pv.alertMessage.setText("Please enter a number");
                            pv.t1.clear();
                            pv.rbList[0].setSelected(false);
                        }

                        int num = 0;
                        int hrs = 0;

                        try{
                            num = Integer.parseInt(numOfCons);
                            hrs = Integer.parseInt(hrsOfConsumption);
                        }catch(NumberFormatException e){
                        }

                        Houses h1 = new Houses(50, hrs, num);
                        pv.consumersList.add(h1);

                        consumerArray.add(h1);

                        h1.totalConsumption(h1.getConsumption(), h1.getHours(), h1.getNumberOfX());
                        totCons = totCons + h1.getTotalConsumption();
                        pv.setEnergyLabel(totCons, totSupp);

                        houseNum = houseNum + h1.getNumberOfX();
                        pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                        if(num < 1){
                            pv.alertMessage.setText("Please enter an amount of consumers greater than 1");
                            pv.consumersList.remove(h1);
                            consumerArray.remove(h1);

                            totCons = totCons - h1.getTotalConsumption();
                            pv.setEnergyLabel(totCons, totSupp);

                            houseNum = houseNum - h1.getNumberOfX();
                            pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                            pv.t1.clear();
                            pv.t2.clear();
                            pv.rbList[0].setSelected(false);
                        }
                        else if(hrs < 1){
                            pv.alertMessage.setText("Please enter an amount of hours between 1 and 168");
                            pv.consumersList.remove(h1);
                            consumerArray.remove(h1);

                            totCons = totCons - h1.getTotalConsumption();
                            pv.setEnergyLabel(totCons, totSupp);

                            houseNum = houseNum - h1.getNumberOfX();
                            pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                            pv.t1.clear();
                            pv.t2.clear();
                            pv.rbList[0].setSelected(false);
                        }

                        pv.t1.clear();
                        pv.t2.clear();
                        pv.rbList[0].setSelected(false);

                    } else if (pv.rbList[1].isSelected() && pv.consumersList.size() < 40) {
                        /*int numOfCons = Integer.parseInt(pv.t1.getText());
                        int hrsOfConsumption = Integer.parseInt(pv.t2.getText());*/
                        String numOfCons = pv.t1.getText();
                        String hrsOfConsumption = pv.t2.getText();
                        boolean numeric1 = true;
                        boolean numeric2 = true;
                        numeric1 = numOfCons.matches("\\d{0,10}");
                        numeric2 = hrsOfConsumption.matches("\\d{0,10}");

                        if(!numeric1){
                            pv.alertMessage.setText("Please enter a number");
                            pv.t1.clear();
                            pv.rbList[1].setSelected(false);
                        }
                        if(!numeric2){
                            pv.alertMessage.setText("Please enter a number");
                            pv.t1.clear();
                            pv.rbList[1].setSelected(false);
                        }

                        int num = 0;
                        int hrs = 0;

                        try{
                            num = Integer.parseInt(numOfCons);
                            hrs = Integer.parseInt(hrsOfConsumption);
                        }catch(NumberFormatException e){
                        }

                        Buildings b1 = new Buildings(200, hrs, num);
                        pv.consumersList.add(b1);

                        consumerArray.add(b1);

                        b1.totalConsumption(b1.getConsumption(), b1.getHours(), b1.getNumberOfX());
                        totCons = totCons + b1.getTotalConsumption();
                        pv.setEnergyLabel(totCons, totSupp);

                        buildingNum = buildingNum + b1.getNumberOfX();
                        pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                        if(num < 1){
                            pv.alertMessage.setText("Please enter an amount of consumers greater than 1");
                            pv.consumersList.remove(b1);
                            consumerArray.remove(b1);

                            totCons = totCons - b1.getTotalConsumption();
                            pv.setEnergyLabel(totCons, totSupp);

                            buildingNum = buildingNum - b1.getNumberOfX();
                            pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                            pv.t1.clear();
                            pv.t2.clear();
                            pv.rbList[1].setSelected(false);
                        }
                        else if(hrs < 1){
                            pv.alertMessage.setText("Please enter an amount of hours between 1 and 168");
                            pv.consumersList.remove(b1);
                            consumerArray.remove(b1);

                            totCons = totCons - b1.getTotalConsumption();
                            pv.setEnergyLabel(totCons, totSupp);

                            buildingNum = buildingNum - b1.getNumberOfX();
                            pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                            pv.t1.clear();
                            pv.t2.clear();
                            pv.rbList[1].setSelected(false);
                        }
                        pv.t1.clear();
                        pv.t2.clear();
                        pv.rbList[1].setSelected(false);
                    } else if (pv.rbList[2].isSelected() && pv.suppliersList.size() < 40) {
                        //Comments are for future reference

                        //int numOfSup = Integer.parseInt(pv.t3.getText());

                        String numOfSup = pv.t3.getText();
                        boolean numeric = true;
                        numeric = numOfSup.matches("\\d{0,10}");

                        if(!numeric){
                            pv.alertMessage.setText("Please enter a number");
                            pv.t3.clear();
                            pv.rbList[2].setSelected(false);
                        }

                        int n = 0;

                        try{
                            n = Integer.parseInt(numOfSup);
                        }catch(NumberFormatException e){

                        }

                        HydroDam hd1 = new HydroDam(1000, /*numOfSup*/ n);
                        pv.suppliersList.add(hd1);

                        supplierArray.add(hd1);

                        hd1.totalProduction(hd1.getPower(), hd1.getNumberOfX());
                        totSupp = totSupp + hd1.getTotalProduction();
                        pv.setEnergyLabel(totCons, totSupp);

                        hydroNum = hydroNum + hd1.getNumberOfX();
                        pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                        if(/*numOfSup*/ n < 1) {
                            pv.alertMessage.setText("Please enter an amount of producers greater than 1");
                            pv.suppliersList.remove(hd1);

                            supplierArray.remove(hd1);
                            totSupp = totSupp - hd1.getTotalProduction();

                            hydroNum = hydroNum - hd1.getNumberOfX();
                            pv.setNumberLabel(houseNum, buildingNum, hydroNum, windNum, solarNum, nppNum);

                            pv.setEnergyLabel(totCons, totSupp);
                            pv.t3.clear();
                            pv.rbList[2].setSelected(false);
                        }

                        pv.t3.clear();
                        pv.rbList[2].setSelected(false);
                    } else if (pv.rbList[3].isSelected() && pv.suppliersList.size() < 40) {
                        //int numOfSup = Integer.parseInt(pv.t3.getText());
                        String numOfSup = pv.t3.getText();
                        boolean numeric = true;
                        numeric = numOfSup.matches("\\d{0,10}");

                        if(!numeric){
                            pv.alertMessage.setText("Please enter a number");
                            pv.t3.clear();
                            pv.rbList[3].setSelected(false);
                        }

                        int n = 0;

                        try{
                            n = Integer.parseInt(numOfSup);
                        }catch(NumberFormatException e){

                        }


                        WindFarm wf1 = new WindFarm(1500, n);
                        pv.suppliersList.add(wf1);

                        supplierArray.add(wf1);

                        wf1.totalProduction(wf1.getPower(), wf1.getNumberOfX());
                        totSupp = totSupp + wf1.getTotalProduction();
                        pv.setEnergyLabel(totCons, totSupp);

                        windNum = windNum + wf1.getNumberOfX();
                        pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                        if(n < 1){
                            pv.alertMessage.setText("Please enter an amount of producers greater than 1");
                            pv.suppliersList.remove(wf1);
                            supplierArray.remove(wf1);

                            totSupp = totSupp - wf1.getTotalProduction();
                            pv.setEnergyLabel(totCons, totSupp);

                            windNum = windNum - wf1.getNumberOfX();
                            pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                            pv.t3.clear();
                            pv.rbList[3].setSelected(false);
                        }

                        pv.t3.clear();
                        pv.rbList[3].setSelected(false);
                    } else if (pv.rbList[4].isSelected() && pv.suppliersList.size() < 40) {
                        //int numOfSup = Integer.parseInt(pv.t3.getText());
                        String numOfSup = pv.t3.getText();
                        boolean numeric = true;
                        numeric = numOfSup.matches("\\d{0,10}");

                        if(!numeric){
                            pv.alertMessage.setText("Please enter a number");
                            pv.t3.clear();
                            pv.rbList[4].setSelected(false);
                        }

                        int n = 0;

                        try{
                            n = Integer.parseInt(numOfSup);
                        }catch(NumberFormatException e){

                        }


                        SolarFarm sf1 = new SolarFarm(750, n);
                        pv.suppliersList.add(sf1);

                        supplierArray.add(sf1);

                        sf1.totalProduction(sf1.getPower(), sf1.getNumberOfX());
                        totSupp = totSupp + sf1.getTotalProduction();
                        pv.setEnergyLabel(totCons, totSupp);

                        solarNum = solarNum + sf1.getNumberOfX();
                        pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                        if(n < 1){
                            pv.alertMessage.setText("Please enter an amount of producers greater than 1");
                            pv.suppliersList.remove(sf1);
                            supplierArray.remove(sf1);

                            totSupp = totSupp - sf1.getTotalProduction();
                            pv.setEnergyLabel(totCons, totSupp);

                            solarNum = solarNum - sf1.getNumberOfX();
                            pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                            pv.t3.clear();
                            pv.rbList[4].setSelected(false);
                        }

                        pv.t3.clear();
                        pv.rbList[4].setSelected(false);
                    } else if (pv.rbList[5].isSelected() && pv.suppliersList.size() < 40) {
                        //int numOfSup = Integer.parseInt(pv.t3.getText());

                        String numOfSup = pv.t3.getText();
                        boolean numeric = true;
                        numeric = numOfSup.matches("\\d{0,10}");

                        if(!numeric){
                            pv.alertMessage.setText("Please enter a number");
                            pv.t3.clear();
                            pv.rbList[5].setSelected(false);
                        }

                        int n = 0;

                        try{
                            n = Integer.parseInt(numOfSup);
                        }catch(NumberFormatException e){

                        }


                        NuclearPowerPlant npp1 = new NuclearPowerPlant(500, n);
                        pv.suppliersList.add(npp1);

                        supplierArray.add(npp1);

                        npp1.totalProduction(npp1.getPower(), npp1.getNumberOfX());
                        totSupp = totSupp + npp1.getTotalProduction();
                        pv.setEnergyLabel(totCons, totSupp);

                        nppNum = nppNum + npp1.getNumberOfX();
                        pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                        if(n < 1){
                            pv.alertMessage.setText("Please enter an amount of producers greater than 1");
                            pv.suppliersList.remove(npp1);
                            supplierArray.remove(npp1);

                            totSupp = totSupp - npp1.getTotalProduction();
                            pv.setEnergyLabel(totCons, totSupp);

                            nppNum = nppNum - npp1.getNumberOfX();
                            pv.setNumberLabel(houseNum, buildingNum,hydroNum, windNum, solarNum, nppNum);

                            pv.t3.clear();
                            pv.rbList[5].setSelected(false);
                        }

                        pv.t3.clear();
                        pv.rbList[5].setSelected(false);
                    }

                //Debugging
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

                //Addition of images to the correct boxes + tooltips for users to see amount of consumers/producers per image

                for(int i = 0; i < cList.size(); i++){
                    if(pv.consumersList.get(i).getName().equals("house")){
                        if(rowCons == 0 && colCons == 0){
                            ImageView h = new ImageView(house);
                            //gpConsumer.add(new ImageView(house), colCons, rowCons); For reference in case something happens
                            gpConsumer.add(h, colCons, rowCons);
                            Tooltip.install(h, new Tooltip(String.valueOf(pv.consumersList.get(i).getNumberOfX()) + " house(s), " + pv.consumersList.get(i).getHours() + " hrs"));
                            colCons++;
                            pv.consumersList.remove(i);
                        }else if(colCons == 5){
                            colCons = 0;
                            rowCons++;
                            ImageView h = new ImageView(house);
                            gpConsumer.add(h, colCons, rowCons);
                            Tooltip.install(h, new Tooltip(String.valueOf(pv.consumersList.get(i).getNumberOfX()) + " house(s), " + pv.consumersList.get(i).getHours() + " hrs"));
                            colCons++;
                            pv.consumersList.remove(i);
                        }else{
                            ImageView h = new ImageView(house);
                            gpConsumer.add(h, colCons, rowCons);
                            Tooltip.install(h, new Tooltip(String.valueOf(pv.consumersList.get(i).getNumberOfX()) + " house(s), " + pv.consumersList.get(i).getHours() + " hrs"));
                            colCons++;
                            pv.consumersList.remove(i);
                        }
                    }
                    else if(pv.consumersList.get(i).getName().equals("building")){
                        if(rowCons == 0 && colCons == 0){
                            ImageView b = new ImageView(building);
                            gpConsumer.add(b, colCons, rowCons);
                            Tooltip.install(b, new Tooltip(String.valueOf(pv.consumersList.get(i).getNumberOfX()) + " building(s), " + pv.consumersList.get(i).getHours() + " hrs"));
                            colCons++;
                            pv.consumersList.remove(i);
                        }else if(colCons == 5){
                            colCons = 0;
                            rowCons++;
                            ImageView b = new ImageView(building);
                            gpConsumer.add(b, colCons, rowCons);
                            Tooltip.install(b, new Tooltip(String.valueOf(pv.consumersList.get(i).getNumberOfX()) + " building(s), " + pv.consumersList.get(i).getHours() + " hrs"));
                            colCons++;
                            pv.consumersList.remove(i);
                        }else{
                            ImageView b = new ImageView(building);
                            gpConsumer.add(b, colCons, rowCons);
                            Tooltip.install(b, new Tooltip(String.valueOf(pv.consumersList.get(i).getNumberOfX()) + " building(s), " + pv.consumersList.get(i).getHours() + " hrs"));
                            colCons++;
                            pv.consumersList.remove(i);
                        }
                    }
                }
                for(int i = 0; i < sList.size(); i++){
                    if(pv.suppliersList.get(i).getName().equals("waterdam")){
                        if(rowSupp == 0 && colSupp == 0){
                            ImageView w = new ImageView(waterdam);
                            gpSupplier.add(w, colSupp, rowSupp);
                            Tooltip.install(w, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " waterdam(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else if(colSupp == 5){
                            colSupp = 0;
                            rowSupp++;
                            ImageView w = new ImageView(waterdam);
                            gpSupplier.add(w, colSupp, rowSupp);
                            Tooltip.install(w, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " waterdam(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else{
                            ImageView w = new ImageView(waterdam);
                            gpSupplier.add(w, colSupp, rowSupp);
                            Tooltip.install(w, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " waterdam(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }
                    }else if(pv.suppliersList.get(i).getName().equals("windturbine")){
                        if(rowSupp == 0 && colSupp == 0){
                            ImageView win = new ImageView(windturbine);
                            gpSupplier.add(win, colSupp, rowSupp);
                            Tooltip.install(win, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " wind turbine(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else if(colSupp == 5){
                            colSupp = 0;
                            rowSupp++;
                            ImageView win = new ImageView(windturbine);
                            gpSupplier.add(win, colSupp, rowSupp);
                            Tooltip.install(win, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " wind turbine(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else{
                            ImageView win = new ImageView(windturbine);
                            gpSupplier.add(win, colSupp, rowSupp);
                            Tooltip.install(win, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " wind turbine(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }
                    }else if(pv.suppliersList.get(i).getName().equals("solarpanel")){
                        if(rowSupp == 0 && colSupp == 0){
                            ImageView s = new ImageView(solarpanel);
                            gpSupplier.add(s, colSupp, rowSupp);
                            Tooltip.install(s, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " solar panel(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else if(colSupp == 5){
                            colSupp = 0;
                            rowSupp++;
                            ImageView s = new ImageView(solarpanel);
                            gpSupplier.add(s, colSupp, rowSupp);
                            Tooltip.install(s, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " solar panel(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else{
                            ImageView s = new ImageView(solarpanel);
                            gpSupplier.add(s, colSupp, rowSupp);
                            Tooltip.install(s, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " solar panel(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }
                    }else if(pv.suppliersList.get(i).getName().equals("npp")){
                        if(rowSupp == 0 && colSupp == 0){
                            ImageView np = new ImageView(npp);
                            gpSupplier.add(np, colSupp, rowSupp);
                            Tooltip.install(np, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " power plant(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else if(colSupp == 5){
                            colSupp = 0;
                            rowSupp++;
                            ImageView np = new ImageView(npp);
                            gpSupplier.add(np, colSupp, rowSupp);
                            Tooltip.install(np, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " power plant(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }else{
                            ImageView np = new ImageView(npp);
                            gpSupplier.add(np, colSupp, rowSupp);
                            Tooltip.install(np, new Tooltip(String.valueOf(pv.suppliersList.get(i).getNumberOfX()) + " power plant(s), " + pv.suppliersList.get(i).getTotalPower() + " kW/h"));
                            colSupp++;
                            pv.suppliersList.remove(i);
                        }
                    }
                }
            }
        });

        //Functionality of reset button (Clearing arrays and images from screen)

        pv.resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.getS().close();
                totCons = 0;
                totSupp = 0;
                houseNum = 0;
                buildingNum = 0;
                hydroNum = 0;
                windNum = 0;
                solarNum = 0;
                nppNum = 0;
                Platform.runLater( () -> {
                    try {
                        new Main().start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }

    //Event handlers for the different menus

    public void setCloseHandler(EventHandler handler){
        mb.getMenus().get(0).getItems().get(0).setOnAction(handler);
    }

    public void setAboutHandler(EventHandler handler){
        mb.getMenus().get(1).getItems().get(0).setOnAction(handler);
    }
}