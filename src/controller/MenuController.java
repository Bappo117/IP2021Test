package src.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
            Pane root = new Pane();
            Stage stage = new Stage();

            VBox vb = new VBox();
            Text t = new Text("About");

            vb.getChildren().add(t);
            root.getChildren().add(vb);

            Scene scene = new Scene(root, 500, 500);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Main.getS());

            stage.setTitle("About");

            stage.setScene(scene);
            stage.showAndWait();
        }
    }
}