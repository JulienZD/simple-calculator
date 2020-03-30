package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene primaryScene = new Scene(pane);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }
}