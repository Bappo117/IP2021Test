package view;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ParameterView extends Pane {
    RadioButton[] rbList = new RadioButton[6];

    public ParameterView(){
        super();

        //Title
        Text title = new Text("Parameters");
        title.setFont(Font.font(30));
        title.relocate(80, -3);

        //Radio Buttons
        ToggleGroup tg = new ToggleGroup();
        for(int i = 1; i < 7; i++){
            rbList[i-1] = new RadioButton("Radio Button " + i);
            rbList[i-1].setToggleGroup(tg);
        }

        //First TextField
        Text text1 = new Text("First Text");
        text1.relocate(25, 255);

        TextField firstTextField = new TextField();
        //testTextField.setPromptText("Enter a number"); If needed to put text inside of TextField
        firstTextField.setFocusTraversable(false); //Used to not prompt as the program starts
        firstTextField.setDisable(false); //Used to disable a text field
        firstTextField.setMaxWidth(100);

        firstTextField.relocate(100, 250);

        //Second TextField
        Text text2 = new Text("Second Text");
        text2.relocate(25, 305);

        TextField secondTextField = new TextField();
        //testTextField.setPromptText("Enter a number"); If needed to put text inside of TextField
        secondTextField.setFocusTraversable(false); //Used to not prompt as the program starts
        secondTextField.setDisable(false); //Used to disable a text field
        secondTextField.setMaxWidth(100);

        secondTextField.relocate(100, 300);

        //Third TextField
        Text text3 = new Text("Third Text");
        text3.relocate(25, 355);

        TextField thirdTextField = new TextField();
        //testTextField.setPromptText("Enter a number"); If needed to put text inside of TextField
        thirdTextField.setFocusTraversable(false); //Used to not prompt as the program starts
        thirdTextField.setDisable(false); //Used to disable a text field
        thirdTextField.setMaxWidth(100);

        thirdTextField.relocate(100, 350);

        //Generate Button
        Button generateButton = new Button("Generate");
        generateButton.relocate(125, 400);

        this.getChildren().add(rbList[0]);
        rbList[0].relocate(15, 40);

        this.getChildren().add(rbList[1]);
        rbList[1].relocate(15, 80);

        this.getChildren().add(rbList[2]);
        rbList[2].relocate(130, 40);

        this.getChildren().add(rbList[3]);
        rbList[3].relocate(130, 80);

        this.getChildren().add(rbList[4]);
        rbList[4].relocate(130, 120);

        this.getChildren().add(rbList[5]);
        rbList[5].relocate(130, 160);

        this.getChildren().addAll(title, text1, text2, text3, firstTextField, secondTextField, thirdTextField, generateButton);
    }


}