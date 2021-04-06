package src.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.mainwindow.Main;
import src.model.MenuItems;
import src.view.MainView;

public class MenuController {
    private MenuItems mi;
    private MainView mv;

    public MenuController(MenuItems menuI, MainView menuV){
        this.mi = menuI;
        this.mv = menuV;

        CloseEventHandler ceh = new CloseEventHandler();
        mv.setCloseHandler(ceh);

        AboutEventHandler aeh = new AboutEventHandler();
        mv.setAboutHandler(aeh);
    }

    //Closes the application

    class CloseEventHandler implements EventHandler{
        @Override
        public void handle(Event event){
            System.exit(0);
        }
    }

    //Creates the About window

    class AboutEventHandler implements EventHandler{
        @Override
        public void handle(Event event){
            ScrollPane sp = new ScrollPane();
            Stage stage = new Stage();

            VBox vb = new VBox();


            Text intro = new Text("Greetings clients, and welcome to our application. This application was made in the scope of a project for the\nIntegrative Project in Computer Science and Mathematics class this semester, Winter 2021." +
                                    "\n\nThe group that was in charge of creating this project was comprised of Alessio Cipriano-Kardous, Victor Pereira and Alexander Glisic.");

            Text pointOfAbout = new Text("\nThis window was made to facilitate the use of the project that you, the client, are currently using.\n\n" +
                                            "This application is meant to represent a simulation of a perfect environment where we have electrical suppliers and consumers:");

            Text infoOnObjects = new Text("Here are the different structures that are available to create using our project.\n");

            Text info2OnObjects = new Text("\nOn the right-hand side of the small images, the number represents how much energy 1 object consumes" +
                                            "\nor produces, and this unit is kilowatts per hour.\n");

            Text parameter = new Text("The next part of the program is where the user is free to choose whatever values they want to input, of course, in the scope\nof what" +
                                        " the program is requiring you to input.\n");

            Text note = new Text("Note that, for number of houses/buildings as well as the number of suppliers, the value inputted should be greater than 0\n" +
                                    "and the consumption per week should be a number between 1 and 168, since there are 168 hours in a week.\n");

            Text parameter2 = new Text("\nDepending on which object the user decides to take, some parameter boxes will be disable, for the sake of creating\n" +
                                        "the object. For instance, if the house of the building is chosen, the first and second text field will remain open\n" +
                                        "whereas if the user chooses any of the producers, only the third text field will remain open.\n");

            Text genButton = new Text("Once the user is happy with the values chosen in the previous steps, it is now time to generate this object." +
                                    "\nThe " + '"' + "Generate" + '"' + " button is the button that should be pressed once all the text fields are filled out, for" +
                                    " the object that wants to be created.");

            Text resButton = new Text("\nThe " + '"' + "Reset" + '"' + " button is used to restart the whole program, to clear all of the objects created as well as the images\n" +
                                        "that will be created within the program");

            Text alertText = new Text("If, for some reason, the user has inputted an invalid type of parameter, the program will not execute and will not create an object.\n" +
                                        "It will, however, let the user know that there is an error with the values that they have inputted and will let the user restart.\n" +
                                        "Here are 2 examples of what will show up.");

            Text objPic = new Text("\nIf the user inputted correct values, the program will execute and will add an image of the object created onto the screen.\n");

            Text objPicInfo = new Text("\nAdditionally, hovering your mouse over an image that was added to the screen will also show some" +
                    "\nadditional information of the object created.\n");

            Text projInfo = new Text("\nTo show the user how much energy is being produced and consumed, a small section was created to have a dedicated space to\n" +
                                        "show it off.\n" +
                                        "\nIt will also show how many structures were created in total, to paint a picture of the amount of objects created.");


            Image parameters = new Image("images/parameters.png");
            Image buttons = new Image("images/buttons.png");
            Image error1 = new Image("images/errormessage.png");
            Image error2 = new Image("images/errormessage2.png");
            Image info = new Image("images/information.png");
            Image radio = new Image("images/radiobuttons.png");
            Image proj = new Image("images/project.png", 640, 387, false, false);
            Image tooltip = new Image("images/tooltip.png");

            ImageView param = new ImageView(parameters);
            ImageView rButtons = new ImageView(radio);
            ImageView contButtons = new ImageView(buttons);
            ImageView err1 = new ImageView(error1);
            ImageView err2 = new ImageView(error2);
            ImageView project = new ImageView(proj);
            ImageView tool = new ImageView(tooltip);
            ImageView information = new ImageView(info);

            intro.setFont(Font.font(16));
            pointOfAbout.setFont(Font.font(16));
            infoOnObjects.setFont(Font.font(16));
            info2OnObjects.setFont(Font.font(16));
            parameter.setFont(Font.font(16));
            note.setFont(Font.font(16));
            parameter2.setFont(Font.font(16));
            genButton.setFont(Font.font(16));
            resButton.setFont(Font.font(16));
            alertText.setFont(Font.font(16));
            objPic.setFont(Font.font(16));
            objPicInfo.setFont(Font.font(16));
            projInfo.setFont(Font.font(16));

            vb.getChildren().addAll(intro, pointOfAbout, infoOnObjects, rButtons, info2OnObjects, parameter, note, param, parameter2, genButton, resButton,
                                    contButtons, alertText, err1, err2, objPic, project, objPicInfo, tool, projInfo, information);

            sp.setContent(vb);
            Scene scene = new Scene(sp, 1000, 500);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setResizable(false);
            stage.initOwner(Main.getS());

            stage.setTitle("About - Power Consumption and Production");

            stage.setScene(scene);
            stage.showAndWait();
        }
    }
}