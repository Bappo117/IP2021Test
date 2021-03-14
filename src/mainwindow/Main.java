package src.mainwindow;

import src.controller.MenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import src.model.MenuItems;
import src.view.MainView;

public class Main extends Application {
    private static Stage s;
    static Pane pane = new Pane();
    private static Scene paraScene = new Scene(pane, 1600, 800);

    @Override
    public void start(Stage stage) throws Exception{
        MenuItems mi = new MenuItems();
        MainView mv = new MainView();
        MenuController mc = new MenuController(mi, mv);

        s = stage;

        stage.setTitle("THIS IS FOR OUR IP PROJECT");

        paraScene = new Scene(mv, paraScene.getWidth(), paraScene.getHeight());

        stage.setScene(paraScene);
        stage.setResizable(false);
        stage.show();
    }

    public static Stage getS(){
        return s;
    }

    public static void setS(Stage s){
        Main.s = s;
    }

    public static Scene getParaScene(){
        return paraScene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}