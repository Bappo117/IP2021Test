package src.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import src.model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ParameterView extends Pane {
    RadioButton[] rbList = new RadioButton[6];
    private final ToggleGroup group = new ToggleGroup();
    Button gb;

    TextField t1;
    TextField t2;
    TextField t3;

    ArrayList<Consumers> consumersList = new ArrayList<>();
    ArrayList<Suppliers> suppliersList = new ArrayList<>();

    Button generateButton;

    public ParameterView() throws FileNotFoundException {
        super();

        //Title
        Text title = new Text("Parameters");
        title.setFont(Font.font(30));
        title.relocate(80, -3);

        //Radio Buttons
        ToggleGroup tg = group;
        for(int i = 1; i < 7; i++){
            rbList[i-1] = new RadioButton(/*"Radio Button " + i*/);
            rbList[i-1].setToggleGroup(tg);
        }

        //Add Images
        //House
        Image house = new Image(new FileInputStream("images/house.png"));
        ImageView ivHouse = new ImageView(house);
        ivHouse.setFitHeight(30);
        ivHouse.setFitWidth(30);
        this.getChildren().add(ivHouse);
        ivHouse.relocate(45, 40);

        //Building
        Image building = new Image(new FileInputStream("images/building.png"));
        ImageView ivBuilding = new ImageView(building);
        ivBuilding.setFitHeight(30);
        ivBuilding.setFitWidth(30);
        this.getChildren().add(ivBuilding);
        ivBuilding.relocate(45, 80);


        //Water Dam
        Image waterdam = new Image(new FileInputStream("images/waterdam.png"));
        ImageView ivWaterDam = new ImageView(waterdam);
        ivWaterDam.setFitHeight(35);
        ivWaterDam.setFitWidth(35);
        this.getChildren().add(ivWaterDam);
        ivWaterDam.relocate(160, 40);

        //Wind Turbine
        Image windturbine = new Image(new FileInputStream("images/windturbine.png"));
        ImageView ivWindTurbine = new ImageView(windturbine);
        ivWindTurbine.setFitHeight(30);
        ivWindTurbine.setFitWidth(30);
        this.getChildren().add(ivWindTurbine);
        ivWindTurbine.relocate(160, 80);

        //Solar Panel
        Image solarpanel = new Image(new FileInputStream("images/solarpanel.png"));
        ImageView ivSolarPanel = new ImageView(solarpanel);
        ivSolarPanel.setFitHeight(30);
        ivSolarPanel.setFitWidth(30);
        this.getChildren().add(ivSolarPanel);
        ivSolarPanel.relocate(160, 120);

        //Nuclear Power Plant
        Image npp = new Image(new FileInputStream("images/npp.png"));
        ImageView ivNpp = new ImageView(npp);
        ivNpp.setFitHeight(30);
        ivNpp.setFitWidth(30);
        this.getChildren().add(ivNpp);
        ivNpp.relocate(160, 160);

        //First TextField
        Text text1 = new Text("Number of houses/buildings");
        text1.relocate(25, 255);

        TextField firstTextField = new TextField();


        t1 = firstTextField;

        //Creation of TextFields
        //First TextField
        firstTextField.setFocusTraversable(false); //Used to not prompt as the program starts
        firstTextField.setDisable(false); //Used to disable a text field
        firstTextField.setMaxWidth(100);

        firstTextField.relocate(190, 250);

        //Second TextField
        Text text2 = new Text("Consumption per week (hrs)");
        text2.relocate(25, 305);

        TextField secondTextField = new TextField();

        t2 = secondTextField;
        secondTextField.setFocusTraversable(false); //Used to not prompt as the program starts
        secondTextField.setDisable(false); //Used to disable a text field
        secondTextField.setMaxWidth(100);

        secondTextField.relocate(190, 300);

        //Third TextField
        Text text3 = new Text("Number of suppliers");
        text3.relocate(25, 355);

        TextField thirdTextField = new TextField();

        t3 = thirdTextField;

        thirdTextField.setFocusTraversable(false); //Used to not prompt as the program starts
        thirdTextField.setDisable(false); //Used to disable a text field
        thirdTextField.setMaxWidth(100);

        thirdTextField.relocate(190, 350);

        //Generate Button
        generateButton = new Button("Generate");
        gb = generateButton;
        generateButton.relocate(125, 400);

        //Add RadioButtons

        this.getChildren().add(rbList[0]);
        rbList[0].relocate(15, 45);

        this.getChildren().add(rbList[1]);
        rbList[1].relocate(15, 85);

        this.getChildren().add(rbList[2]);
        rbList[2].relocate(130, 45);

        this.getChildren().add(rbList[3]);
        rbList[3].relocate(130, 85);

        this.getChildren().add(rbList[4]);
        rbList[4].relocate(130, 125);

        this.getChildren().add(rbList[5]);
        rbList[5].relocate(130, 165);

        this.getChildren().addAll(title, text1, text2, text3, firstTextField, secondTextField, thirdTextField, generateButton);


        //RadioButton functionality
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if(rbList[0].isSelected() || rbList[1].isSelected()) {
                    firstTextField.setDisable(false);
                    secondTextField.setDisable(false);
                    thirdTextField.setDisable(true);
                }else if(rbList[2].isSelected() || rbList[3].isSelected() || rbList[4].isSelected() || rbList[5].isSelected()){
                    firstTextField.setDisable(true);
                    secondTextField.setDisable(true);
                    thirdTextField.setDisable(false);

                }else{
                    firstTextField.setDisable(false);
                    secondTextField.setDisable(false);
                    thirdTextField.setDisable(false);
                }
            }
        });
    }

    public void updateList(){
        MainView.cList = consumersList;
        MainView.sList = suppliersList;
    }

    public ArrayList<Consumers> getConsumersList() {
        return consumersList;
    }

    public ArrayList<Suppliers> getSuppliersList() {
        return suppliersList;
    }

    public RadioButton[] getRbList(){
        return rbList;
    }

    public ToggleGroup getToggleGroup(){
        return group;
    }
}
