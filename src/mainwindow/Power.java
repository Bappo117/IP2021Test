package src.mainwindow;

import src.controller.MenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.model.MenuItems;
import src.view.MainView;

class Main{
    public static void main(String[] args){
        Power.main(args);
    }
}

public class Power extends Application {
    private static Stage s;
    static Pane pane = new Pane();
    //private static Scene paraScene = new Scene(pane, 1600, 800);

    @Override
    public void start(Stage stage) throws Exception{
        MenuItems mi = new MenuItems();
        MainView mv = new MainView();
        MenuController mc = new MenuController(mi, mv);

        s = stage;

        stage.setTitle("Power Consumption and Production");

        //paraScene = new Scene(mv, paraScene.getWidth(), paraScene.getHeight());
        Scene scene = new Scene(mv, 1600, 800);

        //stage.setScene(paraScene);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    //Used by different classes to access the Stage and Scene of the application

    public static Stage getS(){
        return s;
    }

    public static void setS(Stage s){
        Power.s = s;
    }

    /*public static Scene getParaScene(){
        return paraScene;
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}