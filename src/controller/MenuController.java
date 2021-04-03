package src.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

        OptionsEventHandler oeh = new OptionsEventHandler();
        mv.setOptionsHandler(oeh);

        CloseEventHandler ceh = new CloseEventHandler();
        mv.setCloseHandler(ceh);

        AboutEventHandler aeh = new AboutEventHandler();
        mv.setAboutHandler(aeh);
    }

    //Creates the Options window

    class OptionsEventHandler implements EventHandler{
        @Override
        public void handle(Event event){
            Pane root = new Pane();
            Stage stage = new Stage();

            VBox vb = new VBox();
            Text t = new Text("Options");

            vb.getChildren().add(t);
            root.getChildren().add(vb);

            Scene scene = new Scene(root, 500, 500);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Main.getS());

            stage.setTitle("Options");

            stage.setScene(scene);
            stage.showAndWait();
        }
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


            Text one = new Text("Hello! This about section should be able to tell you everything you need to know to operate this application.\n\n" +
                    "This application is mean to be a simulation of a perfect environment where we have electrical suppliers and consumers.\n Here we have two consumers: The house and a building");
            Text two = new Text("\nAnd here you have the 4 suppliers: Hydroelectric power, Wind Farms, Solar energy, and nuclear");
            Text three = new Text("\nYou can control how many consumers or suppliers are in a specific slot and how many hours the consumers run for each week via the small console on the right.\n" +
                    "There is however a limit of only 168 hours per week which amounts to constant 24/7 usage of electricity.\n To generate a consumer, press on the house or building on the left side\n" +
                    "This should grey our one text box. Simply fill in the other two and press generate and your consumer will appear on screen!\n To generate a supplier, simply press any option on the right\n" +
                    "This should grey out two of the text boxes. Fill out the last one and press generate and the supplier will be on the left side.\n Make sure you put in a number or else nothing will be generated!");
            Text four = new Text("\nWhen the suppliers and consumers are generated we will be able to see how much power is being generated and how much power is being consumed.\n" +
                    "There will also be an indicator of how much unused power is being generated or how many consumers are without power in case there is too much power generated or not enough.");
            Text five = new Text("\n\nThat should be all! Enjoy making some energy!");

            Image house = new Image("images/house.png", 128, 100, false, false);
            Image building = new Image("images/building.png", 128, 100, false, false);
            Image waterdam = new Image("images/waterdam.png", 128, 100, false, false);
            Image windturbine = new Image("images/windturbine.png", 128, 100, false, false);
            Image solarpanel = new Image("images/solarpanel.png", 128, 100, false, false);
            Image npp = new Image("images/npp.png", 128, 100, false, false);
            Image parameters = new Image("images/Parameters.png");

            ImageView Ione = new ImageView(house);
            ImageView IIone = new ImageView(building);
            ImageView Itwo = new ImageView(waterdam);
            ImageView IItwo = new ImageView(windturbine);
            ImageView IIItwo = new ImageView(solarpanel);
            ImageView IVtwo = new ImageView(npp);
            ImageView Ithree = new ImageView(parameters);

            vb.getChildren().add(one);
            vb.getChildren().add(Ione);
            vb.getChildren().add(IIone);
            vb.getChildren().add(two);
            vb.getChildren().add(Itwo);
            vb.getChildren().add(IItwo);
            vb.getChildren().add(IIItwo);
            vb.getChildren().add(IVtwo);
            vb.getChildren().add(three);
            vb.getChildren().add(Ithree);
            vb.getChildren().add(four);
            vb.getChildren().add(five);

            sp.setContent(vb);
            Scene scene = new Scene(sp, 500, 500);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Main.getS());

            stage.setTitle("About");

            stage.setScene(scene);
            stage.showAndWait();
        }
    }
}